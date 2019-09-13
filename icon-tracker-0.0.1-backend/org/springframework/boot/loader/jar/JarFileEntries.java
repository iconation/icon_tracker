// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader.jar;

import java.util.NoSuchElementException;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.boot.loader.data.RandomAccessData;

class JarFileEntries implements CentralDirectoryVisitor, Iterable<JarEntry>
{
    private static final long LOCAL_FILE_HEADER_SIZE = 30L;
    private static final String SLASH = "/";
    private static final String NO_SUFFIX = "";
    protected static final int ENTRY_CACHE_SIZE = 25;
    private final JarFile jarFile;
    private final JarEntryFilter filter;
    private RandomAccessData centralDirectoryData;
    private int size;
    private int[] hashCodes;
    private int[] centralDirectoryOffsets;
    private int[] positions;
    private final Map<Integer, FileHeader> entriesCache;
    
    JarFileEntries(final JarFile jarFile, final JarEntryFilter filter) {
        this.entriesCache = Collections.synchronizedMap((Map<Integer, FileHeader>)new LinkedHashMap<Integer, FileHeader>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(final Map.Entry<Integer, FileHeader> eldest) {
                return !JarFileEntries.this.jarFile.isSigned() && this.size() >= 25;
            }
        });
        this.jarFile = jarFile;
        this.filter = filter;
    }
    
    @Override
    public void visitStart(final CentralDirectoryEndRecord endRecord, final RandomAccessData centralDirectoryData) {
        final int maxSize = endRecord.getNumberOfRecords();
        this.centralDirectoryData = centralDirectoryData;
        this.hashCodes = new int[maxSize];
        this.centralDirectoryOffsets = new int[maxSize];
        this.positions = new int[maxSize];
    }
    
    @Override
    public void visitFileHeader(final CentralDirectoryFileHeader fileHeader, final int dataOffset) {
        final AsciiBytes name = this.applyFilter(fileHeader.getName());
        if (name != null) {
            this.add(name, fileHeader, dataOffset);
        }
    }
    
    private void add(final AsciiBytes name, final CentralDirectoryFileHeader fileHeader, final int dataOffset) {
        this.hashCodes[this.size] = name.hashCode();
        this.centralDirectoryOffsets[this.size] = dataOffset;
        this.positions[this.size] = this.size;
        ++this.size;
    }
    
    @Override
    public void visitEnd() {
        this.sort(0, this.size - 1);
        final int[] positions = this.positions;
        this.positions = new int[positions.length];
        for (int i = 0; i < this.size; ++i) {
            this.positions[positions[i]] = i;
        }
    }
    
    private void sort(final int left, final int right) {
        if (left < right) {
            final int pivot = this.hashCodes[left + (right - left) / 2];
            int i;
            int j;
            for (i = left, j = right; i <= j; ++i, --j) {
                while (this.hashCodes[i] < pivot) {
                    ++i;
                }
                while (this.hashCodes[j] > pivot) {
                    --j;
                }
                if (i <= j) {
                    this.swap(i, j);
                }
            }
            if (left < j) {
                this.sort(left, j);
            }
            if (right > i) {
                this.sort(i, right);
            }
        }
    }
    
    private void swap(final int i, final int j) {
        this.swap(this.hashCodes, i, j);
        this.swap(this.centralDirectoryOffsets, i, j);
        this.swap(this.positions, i, j);
    }
    
    private void swap(final int[] array, final int i, final int j) {
        final int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    @Override
    public Iterator<JarEntry> iterator() {
        return new EntryIterator();
    }
    
    public boolean containsEntry(final String name) {
        return this.getEntry(name, FileHeader.class, true) != null;
    }
    
    public JarEntry getEntry(final String name) {
        return this.getEntry(name, JarEntry.class, true);
    }
    
    public InputStream getInputStream(final String name, final RandomAccessData.ResourceAccess access) throws IOException {
        final FileHeader entry = this.getEntry(name, FileHeader.class, false);
        return this.getInputStream(entry, access);
    }
    
    public InputStream getInputStream(final FileHeader entry, final RandomAccessData.ResourceAccess access) throws IOException {
        if (entry == null) {
            return null;
        }
        InputStream inputStream = this.getEntryData(entry).getInputStream(access);
        if (entry.getMethod() == 8) {
            inputStream = new ZipInflaterInputStream(inputStream, (int)entry.getSize());
        }
        return inputStream;
    }
    
    public RandomAccessData getEntryData(final String name) throws IOException {
        final FileHeader entry = this.getEntry(name, FileHeader.class, false);
        if (entry == null) {
            return null;
        }
        return this.getEntryData(entry);
    }
    
    private RandomAccessData getEntryData(final FileHeader entry) throws IOException {
        final RandomAccessData data = this.jarFile.getData();
        final byte[] localHeader = Bytes.get(data.getSubsection(entry.getLocalHeaderOffset(), 30L));
        final long nameLength = Bytes.littleEndianValue(localHeader, 26, 2);
        final long extraLength = Bytes.littleEndianValue(localHeader, 28, 2);
        return data.getSubsection(entry.getLocalHeaderOffset() + 30L + nameLength + extraLength, entry.getCompressedSize());
    }
    
    private <T extends FileHeader> T getEntry(final String name, final Class<T> type, final boolean cacheEntry) {
        int hashCode = AsciiBytes.hashCode(name);
        T entry = this.getEntry(hashCode, name, "", type, cacheEntry);
        if (entry == null) {
            hashCode = AsciiBytes.hashCode(hashCode, "/");
            entry = this.getEntry(hashCode, name, "/", type, cacheEntry);
        }
        return entry;
    }
    
    private <T extends FileHeader> T getEntry(final int hashCode, final String name, final String suffix, final Class<T> type, final boolean cacheEntry) {
        for (int index = this.getFirstIndex(hashCode); index >= 0 && index < this.size && this.hashCodes[index] == hashCode; ++index) {
            final T entry = this.getEntry(index, type, cacheEntry);
            if (entry.hasName(name, suffix)) {
                return entry;
            }
        }
        return null;
    }
    
    private <T extends FileHeader> T getEntry(final int index, final Class<T> type, final boolean cacheEntry) {
        try {
            final FileHeader cached = this.entriesCache.get(index);
            FileHeader entry = (cached != null) ? cached : CentralDirectoryFileHeader.fromRandomAccessData(this.centralDirectoryData, this.centralDirectoryOffsets[index], this.filter);
            if (CentralDirectoryFileHeader.class.equals(entry.getClass()) && type.equals(JarEntry.class)) {
                entry = new JarEntry(this.jarFile, (CentralDirectoryFileHeader)entry);
            }
            if (cacheEntry && cached != entry) {
                this.entriesCache.put(index, entry);
            }
            return (T)entry;
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    private int getFirstIndex(final int hashCode) {
        int index = Arrays.binarySearch(this.hashCodes, 0, this.size, hashCode);
        if (index < 0) {
            return -1;
        }
        while (index > 0 && this.hashCodes[index - 1] == hashCode) {
            --index;
        }
        return index;
    }
    
    public void clearCache() {
        this.entriesCache.clear();
    }
    
    private AsciiBytes applyFilter(final AsciiBytes name) {
        return (this.filter == null) ? name : this.filter.apply(name);
    }
    
    private class EntryIterator implements Iterator<JarEntry>
    {
        private int index;
        
        private EntryIterator() {
            this.index = 0;
        }
        
        @Override
        public boolean hasNext() {
            return this.index < JarFileEntries.this.size;
        }
        
        @Override
        public JarEntry next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            final int entryIndex = JarFileEntries.this.positions[this.index];
            ++this.index;
            return (JarEntry)JarFileEntries.this.getEntry(entryIndex, (Class<FileHeader>)JarEntry.class, false);
        }
    }
}
