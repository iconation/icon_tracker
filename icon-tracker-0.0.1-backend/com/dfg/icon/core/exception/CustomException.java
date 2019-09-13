// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.exception;

public class CustomException extends Exception
{
    private CustomErrorCode customErrorCode;
    
    public CustomException(final CustomErrorCode customErrorCode) {
        super(customErrorCode.getMessage());
        this.customErrorCode = customErrorCode;
    }
    
    public CustomException(final CustomErrorCode customErrorCode, final Throwable throwable) {
        super(customErrorCode.getMessage(), throwable);
        this.customErrorCode = customErrorCode;
    }
    
    public CustomException(final CustomErrorCode customErrorCode, final String description) {
        super(customErrorCode.getMessage(), new Throwable(description));
        this.customErrorCode = customErrorCode;
    }
    
    public CustomErrorCode getCustomErrorCode() {
        return this.customErrorCode;
    }
}
