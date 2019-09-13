// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto.main;

import com.dfg.icon.core.dao.icon.TMainChart;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

public class MainChart
{
    Date targetDate;
    Integer txCount;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public void setMainChart(final TMainChart tMainChart) {
        this.targetDate = tMainChart.getTargetDate();
        this.txCount = tMainChart.getTxCount();
    }
    
    public Date getTargetDate() {
        return this.targetDate;
    }
    
    public Integer getTxCount() {
        return this.txCount;
    }
    
    public void setTargetDate(final Date targetDate) {
        this.targetDate = targetDate;
    }
    
    public void setTxCount(final Integer txCount) {
        this.txCount = txCount;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MainChart)) {
            return false;
        }
        final MainChart other = (MainChart)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$targetDate = this.getTargetDate();
        final Object other$targetDate = other.getTargetDate();
        Label_0065: {
            if (this$targetDate == null) {
                if (other$targetDate == null) {
                    break Label_0065;
                }
            }
            else if (this$targetDate.equals(other$targetDate)) {
                break Label_0065;
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
        return other instanceof MainChart;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $targetDate = this.getTargetDate();
        result = result * 59 + (($targetDate == null) ? 43 : $targetDate.hashCode());
        final Object $txCount = this.getTxCount();
        result = result * 59 + (($txCount == null) ? 43 : $txCount.hashCode());
        return result;
    }
}
