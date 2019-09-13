// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ContractVersion
{
    String version;
    String status;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setVersion(final String version) {
        this.version = version;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ContractVersion)) {
            return false;
        }
        final ContractVersion other = (ContractVersion)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$version = this.getVersion();
        final Object other$version = other.getVersion();
        Label_0065: {
            if (this$version == null) {
                if (other$version == null) {
                    break Label_0065;
                }
            }
            else if (this$version.equals(other$version)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null) {
            if (other$status == null) {
                return true;
            }
        }
        else if (this$status.equals(other$status)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ContractVersion;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $version = this.getVersion();
        result = result * 59 + (($version == null) ? 43 : $version.hashCode());
        final Object $status = this.getStatus();
        result = result * 59 + (($status == null) ? 43 : $status.hashCode());
        return result;
    }
}
