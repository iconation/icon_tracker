// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

public class ContractList
{
    String address;
    String contractName;
    String compiler;
    String balance;
    String txCount;
    String verifiedDate;
    String ircVersion;
    String status;
    
    public String getAddress() {
        return this.address;
    }
    
    public String getContractName() {
        return this.contractName;
    }
    
    public String getCompiler() {
        return this.compiler;
    }
    
    public String getBalance() {
        return this.balance;
    }
    
    public String getTxCount() {
        return this.txCount;
    }
    
    public String getVerifiedDate() {
        return this.verifiedDate;
    }
    
    public String getIrcVersion() {
        return this.ircVersion;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public void setContractName(final String contractName) {
        this.contractName = contractName;
    }
    
    public void setCompiler(final String compiler) {
        this.compiler = compiler;
    }
    
    public void setBalance(final String balance) {
        this.balance = balance;
    }
    
    public void setTxCount(final String txCount) {
        this.txCount = txCount;
    }
    
    public void setVerifiedDate(final String verifiedDate) {
        this.verifiedDate = verifiedDate;
    }
    
    public void setIrcVersion(final String ircVersion) {
        this.ircVersion = ircVersion;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ContractList)) {
            return false;
        }
        final ContractList other = (ContractList)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        Label_0065: {
            if (this$address == null) {
                if (other$address == null) {
                    break Label_0065;
                }
            }
            else if (this$address.equals(other$address)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$contractName = this.getContractName();
        final Object other$contractName = other.getContractName();
        Label_0102: {
            if (this$contractName == null) {
                if (other$contractName == null) {
                    break Label_0102;
                }
            }
            else if (this$contractName.equals(other$contractName)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$compiler = this.getCompiler();
        final Object other$compiler = other.getCompiler();
        Label_0139: {
            if (this$compiler == null) {
                if (other$compiler == null) {
                    break Label_0139;
                }
            }
            else if (this$compiler.equals(other$compiler)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$balance = this.getBalance();
        final Object other$balance = other.getBalance();
        Label_0176: {
            if (this$balance == null) {
                if (other$balance == null) {
                    break Label_0176;
                }
            }
            else if (this$balance.equals(other$balance)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$txCount = this.getTxCount();
        final Object other$txCount = other.getTxCount();
        Label_0213: {
            if (this$txCount == null) {
                if (other$txCount == null) {
                    break Label_0213;
                }
            }
            else if (this$txCount.equals(other$txCount)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$verifiedDate = this.getVerifiedDate();
        final Object other$verifiedDate = other.getVerifiedDate();
        Label_0250: {
            if (this$verifiedDate == null) {
                if (other$verifiedDate == null) {
                    break Label_0250;
                }
            }
            else if (this$verifiedDate.equals(other$verifiedDate)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$ircVersion = this.getIrcVersion();
        final Object other$ircVersion = other.getIrcVersion();
        Label_0287: {
            if (this$ircVersion == null) {
                if (other$ircVersion == null) {
                    break Label_0287;
                }
            }
            else if (this$ircVersion.equals(other$ircVersion)) {
                break Label_0287;
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
        return other instanceof ContractList;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $address = this.getAddress();
        result = result * 59 + (($address == null) ? 43 : $address.hashCode());
        final Object $contractName = this.getContractName();
        result = result * 59 + (($contractName == null) ? 43 : $contractName.hashCode());
        final Object $compiler = this.getCompiler();
        result = result * 59 + (($compiler == null) ? 43 : $compiler.hashCode());
        final Object $balance = this.getBalance();
        result = result * 59 + (($balance == null) ? 43 : $balance.hashCode());
        final Object $txCount = this.getTxCount();
        result = result * 59 + (($txCount == null) ? 43 : $txCount.hashCode());
        final Object $verifiedDate = this.getVerifiedDate();
        result = result * 59 + (($verifiedDate == null) ? 43 : $verifiedDate.hashCode());
        final Object $ircVersion = this.getIrcVersion();
        result = result * 59 + (($ircVersion == null) ? 43 : $ircVersion.hashCode());
        final Object $status = this.getStatus();
        result = result * 59 + (($status == null) ? 43 : $status.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "ContractList(address=" + this.getAddress() + ", contractName=" + this.getContractName() + ", compiler=" + this.getCompiler() + ", balance=" + this.getBalance() + ", txCount=" + this.getTxCount() + ", verifiedDate=" + this.getVerifiedDate() + ", ircVersion=" + this.getIrcVersion() + ", status=" + this.getStatus() + ")";
    }
}
