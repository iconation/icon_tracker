// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import com.dfg.icon.config.DataSourceConfig;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = { "com.dfg.icon" }, excludeFilters = { @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = { "com.dfg.icon.web.v0.controller" }) })
@Import({ DataSourceConfig.class })
public class Application
{
    private static String SERVER_URL;
    
    public static void main(final String[] args) {
        SpringApplication.run((Object)Application.class, args);
    }
    
    @Value("${server.url}")
    private void setIcxUrl(final String serverUrl) {
        Application.SERVER_URL = serverUrl;
    }
}
