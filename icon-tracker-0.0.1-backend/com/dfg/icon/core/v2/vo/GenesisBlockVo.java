// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v2.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenesisBlockVo
{
    @JsonProperty("version")
    String version;
    @JsonProperty("prev_block_hash")
    String prevBlockHash;
    @JsonProperty("merkle_tree_root_hash")
    String merkleTreeRootHash;
    @JsonProperty("time_stamp")
    Long timestamp;
    @JsonProperty("confirmed_transaction_list")
    List<GenesisTransactionVo> confrimedTransactionList;
    @JsonProperty("block_hash")
    String blockHash;
    @JsonProperty("height")
    Integer height;
    @JsonProperty("peer_id")
    String peerId;
    @JsonProperty("signature")
    String signature;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public String getPrevBlockHash() {
        return this.prevBlockHash;
    }
    
    public String getMerkleTreeRootHash() {
        return this.merkleTreeRootHash;
    }
    
    public Long getTimestamp() {
        return this.timestamp;
    }
    
    public List<GenesisTransactionVo> getConfrimedTransactionList() {
        return (List<GenesisTransactionVo>)this.confrimedTransactionList;
    }
    
    public String getBlockHash() {
        return this.blockHash;
    }
    
    public Integer getHeight() {
        return this.height;
    }
    
    public String getPeerId() {
        return this.peerId;
    }
    
    public String getSignature() {
        return this.signature;
    }
    
    public void setVersion(final String version) {
        this.version = version;
    }
    
    public void setPrevBlockHash(final String prevBlockHash) {
        this.prevBlockHash = prevBlockHash;
    }
    
    public void setMerkleTreeRootHash(final String merkleTreeRootHash) {
        this.merkleTreeRootHash = merkleTreeRootHash;
    }
    
    public void setTimestamp(final Long timestamp) {
        this.timestamp = timestamp;
    }
    
    public void setConfrimedTransactionList(final List<GenesisTransactionVo> confrimedTransactionList) {
        this.confrimedTransactionList = confrimedTransactionList;
    }
    
    public void setBlockHash(final String blockHash) {
        this.blockHash = blockHash;
    }
    
    public void setHeight(final Integer height) {
        this.height = height;
    }
    
    public void setPeerId(final String peerId) {
        this.peerId = peerId;
    }
    
    public void setSignature(final String signature) {
        this.signature = signature;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GenesisBlockVo)) {
            return false;
        }
        final GenesisBlockVo other = (GenesisBlockVo)o;
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
        final Object this$prevBlockHash = this.getPrevBlockHash();
        final Object other$prevBlockHash = other.getPrevBlockHash();
        Label_0102: {
            if (this$prevBlockHash == null) {
                if (other$prevBlockHash == null) {
                    break Label_0102;
                }
            }
            else if (this$prevBlockHash.equals(other$prevBlockHash)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$merkleTreeRootHash = this.getMerkleTreeRootHash();
        final Object other$merkleTreeRootHash = other.getMerkleTreeRootHash();
        Label_0139: {
            if (this$merkleTreeRootHash == null) {
                if (other$merkleTreeRootHash == null) {
                    break Label_0139;
                }
            }
            else if (this$merkleTreeRootHash.equals(other$merkleTreeRootHash)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$timestamp = this.getTimestamp();
        final Object other$timestamp = other.getTimestamp();
        Label_0176: {
            if (this$timestamp == null) {
                if (other$timestamp == null) {
                    break Label_0176;
                }
            }
            else if (this$timestamp.equals(other$timestamp)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$confrimedTransactionList = this.getConfrimedTransactionList();
        final Object other$confrimedTransactionList = other.getConfrimedTransactionList();
        Label_0213: {
            if (this$confrimedTransactionList == null) {
                if (other$confrimedTransactionList == null) {
                    break Label_0213;
                }
            }
            else if (this$confrimedTransactionList.equals(other$confrimedTransactionList)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$blockHash = this.getBlockHash();
        final Object other$blockHash = other.getBlockHash();
        Label_0250: {
            if (this$blockHash == null) {
                if (other$blockHash == null) {
                    break Label_0250;
                }
            }
            else if (this$blockHash.equals(other$blockHash)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$height = this.getHeight();
        final Object other$height = other.getHeight();
        Label_0287: {
            if (this$height == null) {
                if (other$height == null) {
                    break Label_0287;
                }
            }
            else if (this$height.equals(other$height)) {
                break Label_0287;
            }
            return false;
        }
        final Object this$peerId = this.getPeerId();
        final Object other$peerId = other.getPeerId();
        Label_0324: {
            if (this$peerId == null) {
                if (other$peerId == null) {
                    break Label_0324;
                }
            }
            else if (this$peerId.equals(other$peerId)) {
                break Label_0324;
            }
            return false;
        }
        final Object this$signature = this.getSignature();
        final Object other$signature = other.getSignature();
        if (this$signature == null) {
            if (other$signature == null) {
                return true;
            }
        }
        else if (this$signature.equals(other$signature)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof GenesisBlockVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $version = this.getVersion();
        result = result * 59 + (($version == null) ? 43 : $version.hashCode());
        final Object $prevBlockHash = this.getPrevBlockHash();
        result = result * 59 + (($prevBlockHash == null) ? 43 : $prevBlockHash.hashCode());
        final Object $merkleTreeRootHash = this.getMerkleTreeRootHash();
        result = result * 59 + (($merkleTreeRootHash == null) ? 43 : $merkleTreeRootHash.hashCode());
        final Object $timestamp = this.getTimestamp();
        result = result * 59 + (($timestamp == null) ? 43 : $timestamp.hashCode());
        final Object $confrimedTransactionList = this.getConfrimedTransactionList();
        result = result * 59 + (($confrimedTransactionList == null) ? 43 : $confrimedTransactionList.hashCode());
        final Object $blockHash = this.getBlockHash();
        result = result * 59 + (($blockHash == null) ? 43 : $blockHash.hashCode());
        final Object $height = this.getHeight();
        result = result * 59 + (($height == null) ? 43 : $height.hashCode());
        final Object $peerId = this.getPeerId();
        result = result * 59 + (($peerId == null) ? 43 : $peerId.hashCode());
        final Object $signature = this.getSignature();
        result = result * 59 + (($signature == null) ? 43 : $signature.hashCode());
        return result;
    }
}
