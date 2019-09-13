// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

public class SearchQuickInfo
{
    String name;
    String address;
    String ircVersion;
    Long txCount;
    
    public SearchQuickInfo(final String[] data) {
        this.name = data[0];
        this.address = data[1];
        this.ircVersion = data[2];
    }
    
    public SearchQuickInfo(final String name, final String address, final String ircVersion, final Long txCount) {
        this.name = name;
        this.address = address;
        this.ircVersion = ircVersion;
        this.txCount = txCount;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public String getIrcVersion() {
        return this.ircVersion;
    }
    
    public Long getTxCount() {
        return this.txCount;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public void setIrcVersion(final String ircVersion) {
        this.ircVersion = ircVersion;
    }
    
    public void setTxCount(final Long txCount) {
        this.txCount = txCount;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SearchQuickInfo)) {
            return false;
        }
        final SearchQuickInfo other = (SearchQuickInfo)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        Label_0065: {
            if (this$name == null) {
                if (other$name == null) {
                    break Label_0065;
                }
            }
            else if (this$name.equals(other$name)) {
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
        final Object this$ircVersion = this.getIrcVersion();
        final Object other$ircVersion = other.getIrcVersion();
        Label_0139: {
            if (this$ircVersion == null) {
                if (other$ircVersion == null) {
                    break Label_0139;
                }
            }
            else if (this$ircVersion.equals(other$ircVersion)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$txCount = this.getTxCount();
        final Object other$txCount = other.getTxCount();
        if (this$txCount == null) {
            if (other$txCount == null) {
                return true;
            }
        }
        else if (this$txCount.equals(other$txCount)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof SearchQuickInfo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * 59 + (($name == null) ? 43 : $name.hashCode());
        final Object $address = this.getAddress();
        result = result * 59 + (($address == null) ? 43 : $address.hashCode());
        final Object $ircVersion = this.getIrcVersion();
        result = result * 59 + (($ircVersion == null) ? 43 : $ircVersion.hashCode());
        final Object $txCount = this.getTxCount();
        result = result * 59 + (($txCount == null) ? 43 : $txCount.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "SearchQuickInfo(name=" + this.getName() + ", address=" + this.getAddress() + ", ircVersion=" + this.getIrcVersion() + ", txCount=" + this.getTxCount() + ")";
    }
}
