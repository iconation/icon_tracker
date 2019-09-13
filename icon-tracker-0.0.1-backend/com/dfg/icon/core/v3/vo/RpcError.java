// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RpcError
{
    @JsonProperty("code")
    Integer code;
    @JsonProperty("message")
    String message;
}
