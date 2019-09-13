// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import java.util.ArrayList;
import java.util.Iterator;
import com.dfg.icon.core.dao.icon.TTxResultLog;
import java.util.List;

public class TokenEventLogList
{
    List<TokenEventLog> tokenEventLog;
    
    public void setTokenEventLogList(final List<TTxResultLog> txResultLog) {
        for (final TTxResultLog txLog : txResultLog) {
            final TokenEventLog eventLog = new TokenEventLog();
            eventLog.setTokenEventLog(txLog);
            this.tokenEventLog.add(eventLog);
        }
    }
    
    public TokenEventLogList() {
        this.tokenEventLog = new ArrayList<TokenEventLog>();
    }
    
    public List<TokenEventLog> getTokenEventLog() {
        return this.tokenEventLog;
    }
    
    public void setTokenEventLog(final List<TokenEventLog> tokenEventLog) {
        this.tokenEventLog = tokenEventLog;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TokenEventLogList)) {
            return false;
        }
        final TokenEventLogList other = (TokenEventLogList)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$tokenEventLog = this.getTokenEventLog();
        final Object other$tokenEventLog = other.getTokenEventLog();
        if (this$tokenEventLog == null) {
            if (other$tokenEventLog == null) {
                return true;
            }
        }
        else if (this$tokenEventLog.equals(other$tokenEventLog)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TokenEventLogList;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $tokenEventLog = this.getTokenEventLog();
        result = result * 59 + (($tokenEventLog == null) ? 43 : $tokenEventLog.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "TokenEventLogList(tokenEventLog=" + this.getTokenEventLog() + ")";
    }
}
