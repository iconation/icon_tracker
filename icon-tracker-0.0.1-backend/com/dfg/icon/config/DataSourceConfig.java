// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.config;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.mybatis.spring.SqlSessionTemplate;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.slf4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@EnableTransactionManagement
@MapperScan(basePackages = { "com.dfg.icon.core.mappers.icon" })
public class DataSourceConfig
{
    private static final Logger logger;
    @Autowired
    Environment env;
    
    @Bean
    public DataSource dataSource() throws Exception {
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(this.env.getProperty("db.driverClassName"));
        dataSource.setUrl(this.env.getProperty("db.url"));
        dataSource.setUsername(this.env.getProperty("db.username"));
        dataSource.setPassword(this.env.getProperty("db.password"));
        dataSource.setConnectionProperties(this.env.getProperty("db.connectionProperties"));
        dataSource.setValidationQuery(this.env.getProperty("db.validationQuery"));
        dataSource.setTestWhileIdle((boolean)this.env.getProperty("db.testWhileIdle", (Class)Boolean.class));
        dataSource.setMaxTotal((int)this.env.getProperty("db.maxTotal", (Class)Integer.class));
        dataSource.setMaxWaitMillis((long)this.env.getProperty("db.maxWaitMillis", (Class)Long.class));
        dataSource.setTimeBetweenEvictionRunsMillis((long)Integer.parseInt(this.env.getProperty("db.timeBetweenEvictionRunsMillis")));
        dataSource.setTestOnBorrow((boolean)Boolean.valueOf(this.env.getProperty("db.testOnBorrow")));
        DataSourceConfig.logger.info("Init DataSource icon Url : {} ", (Object)dataSource.getUrl());
        return (DataSource)dataSource;
    }
    
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(final DataSource dataSource, final ApplicationContext applicationContext) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:core/mappers/icon/*.xml"));
        return sqlSessionFactoryBean;
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(final SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
    @Bean
    public PlatformTransactionManager transactionManager(final DataSource dataSource) throws Exception {
        return (PlatformTransactionManager)new DataSourceTransactionManager(dataSource);
    }
    
    static {
        DataSourceConfig.logger = LoggerFactory.getLogger((Class)DataSourceConfig.class);
    }
}
