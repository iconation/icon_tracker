// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader.archive;

import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Comparator;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.jar.Manifest;
import java.io.File;
import java.util.Set;

public class ExplodedArchive implements Archive
{
    private static final Set<String> SKIPPED_NAMES;
    private final File root;
    private final boolean recursive;
    private File manifestFile;
    private Manifest manifest;
    
    public ExplodedArchive(final File root) {
        this(root, true);
    }
    
    public ExplodedArchive(final File root, final boolean recursive) {
        if (!root.exists() || !root.isDirectory()) {
            throw new IllegalArgumentException("Invalid source folder " + root);
        }
        this.root = root;
        this.recursive = recursive;
        this.manifestFile = this.getManifestFile(root);
    }
    
    private File getManifestFile(final File root) {
        final File metaInf = new File(root, "META-INF");
        return new File(metaInf, "MANIFEST.MF");
    }
    
    @Override
    public URL getUrl() throws MalformedURLException {
        return this.root.toURI().toURL();
    }
    
    @Override
    public Manifest getManifest() throws IOException {
        if (this.manifest == null && this.manifestFile.exists()) {
            final FileInputStream inputStream = new FileInputStream(this.manifestFile);
            try {
                this.manifest = new Manifest(inputStream);
            }
            finally {
                inputStream.close();
            }
        }
        return this.manifest;
    }
    
    @Override
    public List<Archive> getNestedArchives(final EntryFilter filter) throws IOException {
        final List<Archive> nestedArchives = new ArrayList<Archive>();
        for (final Entry entry : this) {
            if (filter.matches(entry)) {
                nestedArchives.add(this.getNestedArchive(entry));
            }
        }
        return Collections.unmodifiableList((List<? extends Archive>)nestedArchives);
    }
    
    @Override
    public Iterator<Entry> iterator() {
        return new FileEntryIterator(this.root, this.recursive);
    }
    
    protected Archive getNestedArchive(final Entry entry) throws IOException {
        final File file = ((FileEntry)entry).getFile();
        return file.isDirectory() ? new ExplodedArchive(file) : new JarFileArchive(file);
    }
    
    @Override
    public String toString() {
        try {
            return this.getUrl().toString();
        }
        catch (Exception ex) {
            return "exploded archive";
        }
    }
    
    static {
        SKIPPED_NAMES = new HashSet<String>(Arrays.asList(".", ".."));
    }
    
    private static class FileEntryIterator implements Iterator<Entry>
    {
        private final Comparator<File> entryComparator;
        private final File root;
        private final boolean recursive;
        private final Deque<Iterator<File>> stack;
        private File current;
        
        FileEntryIterator(final File root, final boolean recursive) {
            this.entryComparator = new EntryComparator();
            this.stack = new LinkedList<Iterator<File>>();
            this.root = root;
            this.recursive = recursive;
            this.stack.add(this.listFiles(root));
            this.current = this.poll();
        }
        
        @Override
        public boolean hasNext() {
            return this.current != null;
        }
        
        @Override
        public Entry next() {
            if (this.current == null) {
                throw new NoSuchElementException();
            }
            final File file = this.current;
            if (file.isDirectory() && (this.recursive || file.getParentFile().equals(this.root))) {
                this.stack.addFirst(this.listFiles(file));
            }
            this.current = this.poll();
            final String name = file.toURI().getPath().substring(this.root.toURI().getPath().length());
            return new FileEntry(name, file);
        }
        
        private Iterator<File> listFiles(final File file) {
            final File[] files = file.listFiles();
            if (files == null) {
                return Collections.emptyList().iterator();
            }
            Arrays.sort(files, this.entryComparator);
            return Arrays.asList(files).iterator();
        }
        
        private File poll() {
            while (!this.stack.isEmpty()) {
                while (this.stack.peek().hasNext()) {
                    final File file = this.stack.peek().next();
                    if (!ExplodedArchive.SKIPPED_NAMES.contains(file.getName())) {
                        return file;
                    }
                }
                this.stack.poll();
            }
            return null;
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
        
        private static class EntryComparator implements Comparator<File>
        {
            @Override
            public int compare(final File o1, final File o2) {
                return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
            }
        }
    }
    
    private static class FileEntry implements Entry
    {
        private final String name;
        private final File file;
        
        FileEntry(final String name, final File file) {
            this.name = name;
            this.file = file;
        }
        
        public File getFile() {
            return this.file;
        }
        
        @Override
        public boolean isDirectory() {
            return this.file.isDirectory();
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
}
