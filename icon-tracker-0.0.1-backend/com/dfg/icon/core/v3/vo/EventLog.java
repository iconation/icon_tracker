// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import java.util.ArrayList;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.List;

public class EventLog
{
    String scoreAddress;
    List<String> indexed;
    List<String> data;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public EventLog() {
        this.indexed = new ArrayList();
        this.data = new ArrayList();
    }
    
    public String getScoreAddress() {
        return this.scoreAddress;
    }
    
    public List<String> getIndexed() {
        return (List<String>)this.indexed;
    }
    
    public List<String> getData() {
        return (List<String>)this.data;
    }
    
    public void setScoreAddress(final String scoreAddress) {
        this.scoreAddress = scoreAddress;
    }
    
    public void setIndexed(final List<String> indexed) {
        this.indexed = indexed;
    }
    
    public void setData(final List<String> data) {
        this.data = data;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EventLog)) {
            return false;
        }
        final EventLog other = (EventLog)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$scoreAddress = this.getScoreAddress();
        final Object other$scoreAddress = other.getScoreAddress();
        Label_0065: {
            if (this$scoreAddress == null) {
                if (other$scoreAddress == null) {
                    break Label_0065;
                }
            }
            else if (this$scoreAddress.equals(other$scoreAddress)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$indexed = this.getIndexed();
        final Object other$indexed = other.getIndexed();
        Label_0102: {
            if (this$indexed == null) {
                if (other$indexed == null) {
                    break Label_0102;
                }
            }
            else if (this$indexed.equals(other$indexed)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$data = this.getData();
        final Object other$data = other.getData();
        if (this$data == null) {
            if (other$data == null) {
                return true;
            }
        }
        else if (this$data.equals(other$data)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof EventLog;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $scoreAddress = this.getScoreAddress();
        result = result * 59 + (($scoreAddress == null) ? 43 : $scoreAddress.hashCode());
        final Object $indexed = this.getIndexed();
        result = result * 59 + (($indexed == null) ? 43 : $indexed.hashCode());
        final Object $data = this.getData();
        result = result * 59 + (($data == null) ? 43 : $data.hashCode());
        return result;
    }
}
