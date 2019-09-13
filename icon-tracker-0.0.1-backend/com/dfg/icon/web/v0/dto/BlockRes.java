// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.List;
import com.dfg.icon.web.v0.dto.block.Block;

public class BlockRes
{
    Block blockDetail;
    List<TxInBlock> txInBlock;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public Block getBlockDetail() {
        return this.blockDetail;
    }
    
    public List<TxInBlock> getTxInBlock() {
        return (List<TxInBlock>)this.txInBlock;
    }
    
    public void setBlockDetail(final Block blockDetail) {
        this.blockDetail = blockDetail;
    }
    
    public void setTxInBlock(final List<TxInBlock> txInBlock) {
        this.txInBlock = txInBlock;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BlockRes)) {
            return false;
        }
        final BlockRes other = (BlockRes)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$blockDetail = this.getBlockDetail();
        final Object other$blockDetail = other.getBlockDetail();
        Label_0065: {
            if (this$blockDetail == null) {
                if (other$blockDetail == null) {
                    break Label_0065;
                }
            }
            else if (this$blockDetail.equals(other$blockDetail)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$txInBlock = this.getTxInBlock();
        final Object other$txInBlock = other.getTxInBlock();
        if (this$txInBlock == null) {
            if (other$txInBlock == null) {
                return true;
            }
        }
        else if (this$txInBlock.equals(other$txInBlock)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof BlockRes;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $blockDetail = this.getBlockDetail();
        result = result * 59 + (($blockDetail == null) ? 43 : $blockDetail.hashCode());
        final Object $txInBlock = this.getTxInBlock();
        result = result * 59 + (($txInBlock == null) ? 43 : $txInBlock.hashCode());
        return result;
    }
}
