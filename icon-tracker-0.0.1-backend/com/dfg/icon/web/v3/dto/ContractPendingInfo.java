// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import java.util.Date;

public class ContractPendingInfo
{
    String contractAddr;
    Integer version;
    String contractName;
    String ircVersion;
    String createTx;
    Date createDate;
    
    public String getContractAddr() {
        return this.contractAddr;
    }
    
    public Integer getVersion() {
        return this.version;
    }
    
    public String getContractName() {
        return this.contractName;
    }
    
    public String getIrcVersion() {
        return this.ircVersion;
    }
    
    public String getCreateTx() {
        return this.createTx;
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setContractAddr(final String contractAddr) {
        this.contractAddr = contractAddr;
    }
    
    public void setVersion(final Integer version) {
        this.version = version;
    }
    
    public void setContractName(final String contractName) {
        this.contractName = contractName;
    }
    
    public void setIrcVersion(final String ircVersion) {
        this.ircVersion = ircVersion;
    }
    
    public void setCreateTx(final String createTx) {
        this.createTx = createTx;
    }
    
    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ContractPendingInfo)) {
            return false;
        }
        final ContractPendingInfo other = (ContractPendingInfo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$contractAddr = this.getContractAddr();
        final Object other$contractAddr = other.getContractAddr();
        Label_0065: {
            if (this$contractAddr == null) {
                if (other$contractAddr == null) {
                    break Label_0065;
                }
            }
            else if (this$contractAddr.equals(other$contractAddr)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$version = this.getVersion();
        final Object other$version = other.getVersion();
        Label_0102: {
            if (this$version == null) {
                if (other$version == null) {
                    break Label_0102;
                }
            }
            else if (this$version.equals(other$version)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$contractName = this.getContractName();
        final Object other$contractName = other.getContractName();
        Label_0139: {
            if (this$contractName == null) {
                if (other$contractName == null) {
                    break Label_0139;
                }
            }
            else if (this$contractName.equals(other$contractName)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$ircVersion = this.getIrcVersion();
        final Object other$ircVersion = other.getIrcVersion();
        Label_0176: {
            if (this$ircVersion == null) {
                if (other$ircVersion == null) {
                    break Label_0176;
                }
            }
            else if (this$ircVersion.equals(other$ircVersion)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$createTx = this.getCreateTx();
        final Object other$createTx = other.getCreateTx();
        Label_0213: {
            if (this$createTx == null) {
                if (other$createTx == null) {
                    break Label_0213;
                }
            }
            else if (this$createTx.equals(other$createTx)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$createDate = this.getCreateDate();
        final Object other$createDate = other.getCreateDate();
        if (this$createDate == null) {
            if (other$createDate == null) {
                return true;
            }
        }
        else if (this$createDate.equals(other$createDate)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ContractPendingInfo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $contractAddr = this.getContractAddr();
        result = result * 59 + (($contractAddr == null) ? 43 : $contractAddr.hashCode());
        final Object $version = this.getVersion();
        result = result * 59 + (($version == null) ? 43 : $version.hashCode());
        final Object $contractName = this.getContractName();
        result = result * 59 + (($contractName == null) ? 43 : $contractName.hashCode());
        final Object $ircVersion = this.getIrcVersion();
        result = result * 59 + (($ircVersion == null) ? 43 : $ircVersion.hashCode());
        final Object $createTx = this.getCreateTx();
        result = result * 59 + (($createTx == null) ? 43 : $createTx.hashCode());
        final Object $createDate = this.getCreateDate();
        result = result * 59 + (($createDate == null) ? 43 : $createDate.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "ContractPendingInfo(contractAddr=" + this.getContractAddr() + ", version=" + this.getVersion() + ", contractName=" + this.getContractName() + ", ircVersion=" + this.getIrcVersion() + ", createTx=" + this.getCreateTx() + ", createDate=" + this.getCreateDate() + ")";
    }
}
