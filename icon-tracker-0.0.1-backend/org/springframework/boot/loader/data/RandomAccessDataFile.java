// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader.data;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;

public class RandomAccessDataFile implements RandomAccessData
{
    private static final int DEFAULT_CONCURRENT_READS = 4;
    private final File file;
    private final FilePool filePool;
    private final long offset;
    private final long length;
    
    public RandomAccessDataFile(final File file) {
        this(file, 4);
    }
    
    public RandomAccessDataFile(final File file, final int concurrentReads) {
        if (file == null) {
            throw new IllegalArgumentException("File must not be null");
        }
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("File %s must exist", file.getAbsolutePath()));
        }
        this.file = file;
        this.filePool = new FilePool(file, concurrentReads);
        this.offset = 0L;
        this.length = file.length();
    }
    
    private RandomAccessDataFile(final File file, final FilePool pool, final long offset, final long length) {
        this.file = file;
        this.filePool = pool;
        this.offset = offset;
        this.length = length;
    }
    
    public File getFile() {
        return this.file;
    }
    
    @Override
    public InputStream getInputStream(final ResourceAccess access) throws IOException {
        return new DataInputStream(access);
    }
    
    @Override
    public RandomAccessData getSubsection(final long offset, final long length) {
        if (offset < 0L || length < 0L || offset + length > this.length) {
            throw new IndexOutOfBoundsException();
        }
        return new RandomAccessDataFile(this.file, this.filePool, this.offset + offset, length);
    }
    
    @Override
    public long getSize() {
        return this.length;
    }
    
    public void close() throws IOException {
        this.filePool.close();
    }
    
    private class DataInputStream extends InputStream
    {
        private RandomAccessFile file;
        private int position;
        
        DataInputStream(final ResourceAccess access) throws IOException {
            if (access == ResourceAccess.ONCE) {
                (this.file = new RandomAccessFile(RandomAccessDataFile.this.file, "r")).seek(RandomAccessDataFile.this.offset);
            }
        }
        
        @Override
        public int read() throws IOException {
            return this.doRead(null, 0, 1);
        }
        
        @Override
        public int read(final byte[] b) throws IOException {
            return this.read(b, 0, (b == null) ? 0 : b.length);
        }
        
        @Override
        public int read(final byte[] b, final int off, final int len) throws IOException {
            if (b == null) {
                throw new NullPointerException("Bytes must not be null");
            }
            return this.doRead(b, off, len);
        }
        
        public int doRead(final byte[] b, final int off, final int len) throws IOException {
            if (len == 0) {
                return 0;
            }
            final int cappedLen = this.cap(len);
            if (cappedLen <= 0) {
                return -1;
            }
            RandomAccessFile file = this.file;
            try {
                if (file == null) {
                    file = RandomAccessDataFile.this.filePool.acquire();
                    file.seek(RandomAccessDataFile.this.offset + this.position);
                }
                if (b == null) {
                    final int rtn = file.read();
                    this.moveOn((rtn != -1) ? 1 : 0);
                    return rtn;
                }
                return (int)this.moveOn(file.read(b, off, cappedLen));
            }
            finally {
                if (this.file == null && file != null) {
                    RandomAccessDataFile.this.filePool.release(file);
                }
            }
        }
        
        @Override
        public long skip(final long n) throws IOException {
            return (n <= 0L) ? 0L : this.moveOn(this.cap(n));
        }
        
        @Override
        public void close() throws IOException {
            if (this.file != null) {
                this.file.close();
            }
        }
        
        private int cap(final long n) {
            return (int)Math.min(RandomAccessDataFile.this.length - this.position, n);
        }
        
        private long moveOn(final int amount) {
            this.position += amount;
            return amount;
        }
    }
    
    static class FilePool
    {
        private final File file;
        private final int size;
        private final Semaphore available;
        private final Queue<RandomAccessFile> files;
        
        FilePool(final File file, final int size) {
            this.file = file;
            this.size = size;
            this.available = new Semaphore(size);
            this.files = new ConcurrentLinkedQueue<RandomAccessFile>();
        }
        
        public RandomAccessFile acquire() throws IOException {
            this.available.acquireUninterruptibly();
            final RandomAccessFile file = this.files.poll();
            if (file != null) {
                return file;
            }
            return new RandomAccessFile(this.file, "r");
        }
        
        public void release(final RandomAccessFile file) {
            this.files.add(file);
            this.available.release();
        }
        
        public void close() throws IOException {
            this.available.acquireUninterruptibly(this.size);
            try {
                for (RandomAccessFile pooledFile = this.files.poll(); pooledFile != null; pooledFile = this.files.poll()) {
                    pooledFile.close();
                }
            }
            finally {
                this.available.release(this.size);
            }
        }
    }
}
