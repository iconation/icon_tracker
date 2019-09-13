// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.config;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestTemplateConfig
{
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder.json().featuresToDisable(new Object[] { SerializationFeature.WRITE_DATES_AS_TIMESTAMPS }).modules(new Module[] { (Module)new JavaTimeModule() }).build();
    }
}
