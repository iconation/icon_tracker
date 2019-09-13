// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.List;

public class ContractInfo
{
    String balance;
    String address;
    String usdBalance;
    String txCount;
    String ircVersion;
    String creator;
    String createTx;
    String status;
    String symbol;
    String tokenName;
    String contractVersion;
    String newVersion;
    List<ContractVersion> versionList;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getBalance() {
        return this.balance;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public String getUsdBalance() {
        return this.usdBalance;
    }
    
    public String getTxCount() {
        return this.txCount;
    }
    
    public String getIrcVersion() {
        return this.ircVersion;
    }
    
    public String getCreator() {
        return this.creator;
    }
    
    public String getCreateTx() {
        return this.createTx;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public String getTokenName() {
        return this.tokenName;
    }
    
    public String getContractVersion() {
        return this.contractVersion;
    }
    
    public String getNewVersion() {
        return this.newVersion;
    }
    
    public List<ContractVersion> getVersionList() {
        return (List<ContractVersion>)this.versionList;
    }
    
    public void setBalance(final String balance) {
        this.balance = balance;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public void setUsdBalance(final String usdBalance) {
        this.usdBalance = usdBalance;
    }
    
    public void setTxCount(final String txCount) {
        this.txCount = txCount;
    }
    
    public void setIrcVersion(final String ircVersion) {
        this.ircVersion = ircVersion;
    }
    
    public void setCreator(final String creator) {
        this.creator = creator;
    }
    
    public void setCreateTx(final String createTx) {
        this.createTx = createTx;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public void setSymbol(final String symbol) {
        this.symbol = symbol;
    }
    
    public void setTokenName(final String tokenName) {
        this.tokenName = tokenName;
    }
    
    public void setContractVersion(final String contractVersion) {
        this.contractVersion = contractVersion;
    }
    
    public void setNewVersion(final String newVersion) {
        this.newVersion = newVersion;
    }
    
    public void setVersionList(final List<ContractVersion> versionList) {
        this.versionList = versionList;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ContractInfo)) {
            return false;
        }
        final ContractInfo other = (ContractInfo)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$balance = this.getBalance();
        final Object other$balance = other.getBalance();
        Label_0065: {
            if (this$balance == null) {
                if (other$balance == null) {
                    break Label_0065;
                }
            }
            else if (this$balance.equals(other$balance)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        Label_0102: {
            if (this$address == null) {
                if (other$address == null) {
                    break Label_0102;
                }
            }
            else if (this$address.equals(other$address)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$usdBalance = this.getUsdBalance();
        final Object other$usdBalance = other.getUsdBalance();
        Label_0139: {
            if (this$usdBalance == null) {
                if (other$usdBalance == null) {
                    break Label_0139;
                }
            }
            else if (this$usdBalance.equals(other$usdBalance)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$txCount = this.getTxCount();
        final Object other$txCount = other.getTxCount();
        Label_0176: {
            if (this$txCount == null) {
                if (other$txCount == null) {
                    break Label_0176;
                }
            }
            else if (this$txCount.equals(other$txCount)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$ircVersion = this.getIrcVersion();
        final Object other$ircVersion = other.getIrcVersion();
        Label_0213: {
            if (this$ircVersion == null) {
                if (other$ircVersion == null) {
                    break Label_0213;
                }
            }
            else if (this$ircVersion.equals(other$ircVersion)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$creator = this.getCreator();
        final Object other$creator = other.getCreator();
        Label_0250: {
            if (this$creator == null) {
                if (other$creator == null) {
                    break Label_0250;
                }
            }
            else if (this$creator.equals(other$creator)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$createTx = this.getCreateTx();
        final Object other$createTx = other.getCreateTx();
        Label_0287: {
            if (this$createTx == null) {
                if (other$createTx == null) {
                    break Label_0287;
                }
            }
            else if (this$createTx.equals(other$createTx)) {
                break Label_0287;
            }
            return false;
        }
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        Label_0324: {
            if (this$status == null) {
                if (other$status == null) {
                    break Label_0324;
                }
            }
            else if (this$status.equals(other$status)) {
                break Label_0324;
            }
            return false;
        }
        final Object this$symbol = this.getSymbol();
        final Object other$symbol = other.getSymbol();
        Label_0361: {
            if (this$symbol == null) {
                if (other$symbol == null) {
                    break Label_0361;
                }
            }
            else if (this$symbol.equals(other$symbol)) {
                break Label_0361;
            }
            return false;
        }
        final Object this$tokenName = this.getTokenName();
        final Object other$tokenName = other.getTokenName();
        Label_0398: {
            if (this$tokenName == null) {
                if (other$tokenName == null) {
                    break Label_0398;
                }
            }
            else if (this$tokenName.equals(other$tokenName)) {
                break Label_0398;
            }
            return false;
        }
        final Object this$contractVersion = this.getContractVersion();
        final Object other$contractVersion = other.getContractVersion();
        Label_0435: {
            if (this$contractVersion == null) {
                if (other$contractVersion == null) {
                    break Label_0435;
                }
            }
            else if (this$contractVersion.equals(other$contractVersion)) {
                break Label_0435;
            }
            return false;
        }
        final Object this$newVersion = this.getNewVersion();
        final Object other$newVersion = other.getNewVersion();
        Label_0472: {
            if (this$newVersion == null) {
                if (other$newVersion == null) {
                    break Label_0472;
                }
            }
            else if (this$newVersion.equals(other$newVersion)) {
                break Label_0472;
            }
            return false;
        }
        final Object this$versionList = this.getVersionList();
        final Object other$versionList = other.getVersionList();
        if (this$versionList == null) {
            if (other$versionList == null) {
                return true;
            }
        }
        else if (this$versionList.equals(other$versionList)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ContractInfo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $balance = this.getBalance();
        result = result * 59 + (($balance == null) ? 43 : $balance.hashCode());
        final Object $address = this.getAddress();
        result = result * 59 + (($address == null) ? 43 : $address.hashCode());
        final Object $usdBalance = this.getUsdBalance();
        result = result * 59 + (($usdBalance == null) ? 43 : $usdBalance.hashCode());
        final Object $txCount = this.getTxCount();
        result = result * 59 + (($txCount == null) ? 43 : $txCount.hashCode());
        final Object $ircVersion = this.getIrcVersion();
        result = result * 59 + (($ircVersion == null) ? 43 : $ircVersion.hashCode());
        final Object $creator = this.getCreator();
        result = result * 59 + (($creator == null) ? 43 : $creator.hashCode());
        final Object $createTx = this.getCreateTx();
        result = result * 59 + (($createTx == null) ? 43 : $createTx.hashCode());
        final Object $status = this.getStatus();
        result = result * 59 + (($status == null) ? 43 : $status.hashCode());
        final Object $symbol = this.getSymbol();
        result = result * 59 + (($symbol == null) ? 43 : $symbol.hashCode());
        final Object $tokenName = this.getTokenName();
        result = result * 59 + (($tokenName == null) ? 43 : $tokenName.hashCode());
        final Object $contractVersion = this.getContractVersion();
        result = result * 59 + (($contractVersion == null) ? 43 : $contractVersion.hashCode());
        final Object $newVersion = this.getNewVersion();
        result = result * 59 + (($newVersion == null) ? 43 : $newVersion.hashCode());
        final Object $versionList = this.getVersionList();
        result = result * 59 + (($versionList == null) ? 43 : $versionList.hashCode());
        return result;
    }
}
