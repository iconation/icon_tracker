// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.exception;

import org.springframework.http.HttpStatus;

public interface CustomErrorCode
{
    HttpStatus getStatus();
    
    String getCode();
    
    String getMessage();
}
