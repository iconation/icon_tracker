// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.List;

public class RepResult
{
    String startTermHeight;
    String endTermHeight;
    String repHash;
    List<RepVo> rep;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getStartTermHeight() {
        return this.startTermHeight;
    }
    
    public String getEndTermHeight() {
        return this.endTermHeight;
    }
    
    public String getRepHash() {
        return this.repHash;
    }
    
    public List<RepVo> getRep() {
        return (List<RepVo>)this.rep;
    }
    
    public void setStartTermHeight(final String startTermHeight) {
        this.startTermHeight = startTermHeight;
    }
    
    public void setEndTermHeight(final String endTermHeight) {
        this.endTermHeight = endTermHeight;
    }
    
    public void setRepHash(final String repHash) {
        this.repHash = repHash;
    }
    
    public void setRep(final List<RepVo> rep) {
        this.rep = rep;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RepResult)) {
            return false;
        }
        final RepResult other = (RepResult)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$startTermHeight = this.getStartTermHeight();
        final Object other$startTermHeight = other.getStartTermHeight();
        Label_0065: {
            if (this$startTermHeight == null) {
                if (other$startTermHeight == null) {
                    break Label_0065;
                }
            }
            else if (this$startTermHeight.equals(other$startTermHeight)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$endTermHeight = this.getEndTermHeight();
        final Object other$endTermHeight = other.getEndTermHeight();
        Label_0102: {
            if (this$endTermHeight == null) {
                if (other$endTermHeight == null) {
                    break Label_0102;
                }
            }
            else if (this$endTermHeight.equals(other$endTermHeight)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$repHash = this.getRepHash();
        final Object other$repHash = other.getRepHash();
        Label_0139: {
            if (this$repHash == null) {
                if (other$repHash == null) {
                    break Label_0139;
                }
            }
            else if (this$repHash.equals(other$repHash)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$rep = this.getRep();
        final Object other$rep = other.getRep();
        if (this$rep == null) {
            if (other$rep == null) {
                return true;
            }
        }
        else if (this$rep.equals(other$rep)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof RepResult;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $startTermHeight = this.getStartTermHeight();
        result = result * 59 + (($startTermHeight == null) ? 43 : $startTermHeight.hashCode());
        final Object $endTermHeight = this.getEndTermHeight();
        result = result * 59 + (($endTermHeight == null) ? 43 : $endTermHeight.hashCode());
        final Object $repHash = this.getRepHash();
        result = result * 59 + (($repHash == null) ? 43 : $repHash.hashCode());
        final Object $rep = this.getRep();
        result = result * 59 + (($rep == null) ? 43 : $rep.hashCode());
        return result;
    }
}
