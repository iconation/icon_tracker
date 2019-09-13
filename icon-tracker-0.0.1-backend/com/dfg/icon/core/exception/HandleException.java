// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.exception;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.io.UnsupportedEncodingException;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class HandleException
{
    private static final Logger logger;
    
    @ExceptionHandler({ IconException.class })
    public ResponseEntity<ErrorMessageRes> handleUcoinException(final IconException e) throws UnsupportedEncodingException {
        final ErrorMessageRes res = new ErrorMessageRes(e.getCustomErrorCode(), e.getDtail());
        HandleException.logger.error("IconException : {}", (Object)res.toString());
        HandleException.logger.info("====================");
        return (ResponseEntity<ErrorMessageRes>)new ResponseEntity((Object)res, e.getStatus());
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)HandleException.class);
    }
}
