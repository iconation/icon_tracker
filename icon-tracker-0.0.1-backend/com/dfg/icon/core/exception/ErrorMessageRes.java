// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ErrorMessageRes
{
    String errCode;
    String message;
    String detail;
    
    public ErrorMessageRes(final CustomErrorCode customErrorCode) {
        this.errCode = customErrorCode.getCode();
        this.message = customErrorCode.getMessage();
    }
    
    public ErrorMessageRes(final CustomErrorCode customErrorCode, final String detail) {
        this.errCode = customErrorCode.getCode();
        this.message = customErrorCode.getMessage();
        this.detail = detail;
    }
    
    public ErrorMessageRes() {
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getErrCode() {
        return this.errCode;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public String getDetail() {
        return this.detail;
    }
    
    public void setErrCode(final String errCode) {
        this.errCode = errCode;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public void setDetail(final String detail) {
        this.detail = detail;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ErrorMessageRes)) {
            return false;
        }
        final ErrorMessageRes other = (ErrorMessageRes)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$errCode = this.getErrCode();
        final Object other$errCode = other.getErrCode();
        Label_0065: {
            if (this$errCode == null) {
                if (other$errCode == null) {
                    break Label_0065;
                }
            }
            else if (this$errCode.equals(other$errCode)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$message = this.getMessage();
        final Object other$message = other.getMessage();
        Label_0102: {
            if (this$message == null) {
                if (other$message == null) {
                    break Label_0102;
                }
            }
            else if (this$message.equals(other$message)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$detail = this.getDetail();
        final Object other$detail = other.getDetail();
        if (this$detail == null) {
            if (other$detail == null) {
                return true;
            }
        }
        else if (this$detail.equals(other$detail)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ErrorMessageRes;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $errCode = this.getErrCode();
        result = result * 59 + (($errCode == null) ? 43 : $errCode.hashCode());
        final Object $message = this.getMessage();
        result = result * 59 + (($message == null) ? 43 : $message.hashCode());
        final Object $detail = this.getDetail();
        result = result * 59 + (($detail == null) ? 43 : $detail.hashCode());
        return result;
    }
}
