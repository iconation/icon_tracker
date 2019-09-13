// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;

public class TAddressPrep extends TAddressPrepKey
{
    private String repName;
    private Integer blockCount;
    private Boolean isPrep;
    private Integer startTerm;
    private Integer endTerm;
    private String url;
    private String repHash;
    private Date updateDate;
    
    public String getRepName() {
        return this.repName;
    }
    
    public void setRepName(final String repName) {
        this.repName = ((repName == null) ? null : repName.trim());
    }
    
    public Integer getBlockCount() {
        return this.blockCount;
    }
    
    public void setBlockCount(final Integer blockCount) {
        this.blockCount = blockCount;
    }
    
    public Boolean getIsPrep() {
        return this.isPrep;
    }
    
    public void setIsPrep(final Boolean isPrep) {
        this.isPrep = isPrep;
    }
    
    public Integer getStartTerm() {
        return this.startTerm;
    }
    
    public void setStartTerm(final Integer startTerm) {
        this.startTerm = startTerm;
    }
    
    public Integer getEndTerm() {
        return this.endTerm;
    }
    
    public void setEndTerm(final Integer endTerm) {
        this.endTerm = endTerm;
    }
    
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(final String url) {
        this.url = ((url == null) ? null : url.trim());
    }
    
    public String getRepHash() {
        return this.repHash;
    }
    
    public void setRepHash(final String repHash) {
        this.repHash = ((repHash == null) ? null : repHash.trim());
    }
    
    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(final Date updateDate) {
        this.updateDate = updateDate;
    }
}
