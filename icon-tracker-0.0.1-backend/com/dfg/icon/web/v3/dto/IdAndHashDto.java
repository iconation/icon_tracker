// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class IdAndHashDto
{
    int id;
    String hash;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getHash() {
        return this.hash;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public void setHash(final String hash) {
        this.hash = hash;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IdAndHashDto)) {
            return false;
        }
        final IdAndHashDto other = (IdAndHashDto)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getId() != other.getId()) {
            return false;
        }
        final Object this$hash = this.getHash();
        final Object other$hash = other.getHash();
        if (this$hash == null) {
            if (other$hash == null) {
                return true;
            }
        }
        else if (this$hash.equals(other$hash)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof IdAndHashDto;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getId();
        final Object $hash = this.getHash();
        result = result * 59 + (($hash == null) ? 43 : $hash.hashCode());
        return result;
    }
}
