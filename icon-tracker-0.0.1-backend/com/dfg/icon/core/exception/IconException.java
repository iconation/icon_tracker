// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.exception;

import org.springframework.util.StringUtils;
import org.springframework.http.HttpStatus;

public class IconException extends CustomException
{
    private String detail;
    
    public IconException(final IconCode ucoinErrorCode) {
        super(ucoinErrorCode);
        this.detail = null;
    }
    
    public IconException(final IconCode iconErrorCode, final Throwable throwable) {
        super(iconErrorCode, throwable);
        this.detail = throwable.getMessage();
    }
    
    public IconException(final IconCode iconErrorCode, final String detail) {
        super(iconErrorCode, detail);
        this.detail = detail;
    }
    
    public HttpStatus getStatus() {
        return this.getCustomErrorCode().getStatus();
    }
    
    public String getDtail() {
        if (!StringUtils.isEmpty((Object)this.detail)) {
            return this.detail;
        }
        return null;
    }
}
