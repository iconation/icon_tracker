// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto.main;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dfg.icon.core.dao.icon.TMainTx;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class MainInfoRes
{
    @ApiModelProperty("mainInfo")
    @JsonProperty
    MainInfo tmainInfo;
    List<TMainTx> tmainTx;
    List<MainBlock> tmainBlock;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public MainInfo getTmainInfo() {
        return this.tmainInfo;
    }
    
    public List<TMainTx> getTmainTx() {
        return this.tmainTx;
    }
    
    public List<MainBlock> getTmainBlock() {
        return this.tmainBlock;
    }
    
    public void setTmainInfo(final MainInfo tmainInfo) {
        this.tmainInfo = tmainInfo;
    }
    
    public void setTmainTx(final List<TMainTx> tmainTx) {
        this.tmainTx = tmainTx;
    }
    
    public void setTmainBlock(final List<MainBlock> tmainBlock) {
        this.tmainBlock = tmainBlock;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MainInfoRes)) {
            return false;
        }
        final MainInfoRes other = (MainInfoRes)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$tmainInfo = this.getTmainInfo();
        final Object other$tmainInfo = other.getTmainInfo();
        Label_0065: {
            if (this$tmainInfo == null) {
                if (other$tmainInfo == null) {
                    break Label_0065;
                }
            }
            else if (this$tmainInfo.equals(other$tmainInfo)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$tmainTx = this.getTmainTx();
        final Object other$tmainTx = other.getTmainTx();
        Label_0102: {
            if (this$tmainTx == null) {
                if (other$tmainTx == null) {
                    break Label_0102;
                }
            }
            else if (this$tmainTx.equals(other$tmainTx)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$tmainBlock = this.getTmainBlock();
        final Object other$tmainBlock = other.getTmainBlock();
        if (this$tmainBlock == null) {
            if (other$tmainBlock == null) {
                return true;
            }
        }
        else if (this$tmainBlock.equals(other$tmainBlock)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof MainInfoRes;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $tmainInfo = this.getTmainInfo();
        result = result * 59 + (($tmainInfo == null) ? 43 : $tmainInfo.hashCode());
        final Object $tmainTx = this.getTmainTx();
        result = result * 59 + (($tmainTx == null) ? 43 : $tmainTx.hashCode());
        final Object $tmainBlock = this.getTmainBlock();
        result = result * 59 + (($tmainBlock == null) ? 43 : $tmainBlock.hashCode());
        return result;
    }
}
