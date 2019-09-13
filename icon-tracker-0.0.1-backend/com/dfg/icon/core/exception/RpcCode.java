// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.exception;

import org.springframework.http.HttpStatus;

public enum RpcCode implements CustomErrorCode
{
    PARSE_ERROR(Integer.valueOf(-32700), "Invalid JSON was received by the server. An error occurred on the server while parsing the JSON text."), 
    INVALID_REQUEST(Integer.valueOf(-32600), "The JSON sent is not a valid Request object."), 
    METHOD_NOT_FOUND(Integer.valueOf(-32601), "The method does not exist / is not available."), 
    INVALID_PARAMS(Integer.valueOf(-32602), "Invalid method parameter(s)."), 
    INTERNAL_ERROR(Integer.valueOf(-32603), "Internal JSON-RPC error."), 
    SERVER_ERROR(Integer.valueOf(-32000), "IconServiceEngine \ub0b4\ubd80\uc624\ub958"), 
    SCORE_ERROR(Integer.valueOf(-32100), "Score \ub0b4\ubd80\uc624\ub958");
    
    private HttpStatus status;
    private String message;
    private Integer code;
    
    private RpcCode(final Integer code, final String message) {
        this.code = code;
        this.message = message;
    }
    
    @Override
    public HttpStatus getStatus() {
        return this.status;
    }
    
    @Override
    public String getMessage() {
        return this.message;
    }
    
    @Override
    public String getCode() {
        return this.code.toString();
    }
}
