// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader.jar;

import java.util.Iterator;
import java.io.IOException;
import org.springframework.boot.loader.data.RandomAccessData;
import java.util.ArrayList;
import java.util.List;

class CentralDirectoryParser
{
    private int CENTRAL_DIRECTORY_HEADER_BASE_SIZE;
    private final List<CentralDirectoryVisitor> visitors;
    
    CentralDirectoryParser() {
        this.CENTRAL_DIRECTORY_HEADER_BASE_SIZE = 46;
        this.visitors = new ArrayList<CentralDirectoryVisitor>();
    }
    
    public <T extends CentralDirectoryVisitor> T addVisitor(final T visitor) {
        this.visitors.add(visitor);
        return visitor;
    }
    
    public RandomAccessData parse(RandomAccessData data, final boolean skipPrefixBytes) throws IOException {
        final CentralDirectoryEndRecord endRecord = new CentralDirectoryEndRecord(data);
        if (skipPrefixBytes) {
            data = this.getArchiveData(endRecord, data);
        }
        final RandomAccessData centralDirectoryData = endRecord.getCentralDirectory(data);
        this.visitStart(endRecord, centralDirectoryData);
        this.parseEntries(endRecord, centralDirectoryData);
        this.visitEnd();
        return data;
    }
    
    private void parseEntries(final CentralDirectoryEndRecord endRecord, final RandomAccessData centralDirectoryData) throws IOException {
        final byte[] bytes = Bytes.get(centralDirectoryData);
        final CentralDirectoryFileHeader fileHeader = new CentralDirectoryFileHeader();
        int dataOffset = 0;
        for (int i = 0; i < endRecord.getNumberOfRecords(); ++i) {
            fileHeader.load(bytes, dataOffset, null, 0, null);
            this.visitFileHeader(dataOffset, fileHeader);
            dataOffset += this.CENTRAL_DIRECTORY_HEADER_BASE_SIZE + fileHeader.getName().length() + fileHeader.getComment().length() + fileHeader.getExtra().length;
        }
    }
    
    private RandomAccessData getArchiveData(final CentralDirectoryEndRecord endRecord, final RandomAccessData data) {
        final long offset = endRecord.getStartOfArchive(data);
        if (offset == 0L) {
            return data;
        }
        return data.getSubsection(offset, data.getSize() - offset);
    }
    
    private void visitStart(final CentralDirectoryEndRecord endRecord, final RandomAccessData centralDirectoryData) {
        for (final CentralDirectoryVisitor visitor : this.visitors) {
            visitor.visitStart(endRecord, centralDirectoryData);
        }
    }
    
    private void visitFileHeader(final int dataOffset, final CentralDirectoryFileHeader fileHeader) {
        for (final CentralDirectoryVisitor visitor : this.visitors) {
            visitor.visitFileHeader(fileHeader, dataOffset);
        }
    }
    
    private void visitEnd() {
        for (final CentralDirectoryVisitor visitor : this.visitors) {
            visitor.visitEnd();
        }
    }
}
