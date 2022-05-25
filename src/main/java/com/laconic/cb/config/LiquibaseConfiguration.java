package com.laconic.cb.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfiguration {

    private final Environment environment;
    private final DataSource dataSource;
    private static final String CHANGE_LOG_FILE = "classpath:db-changelog.yml";
    private static final String CONTEXTS = "spring.liquibase.contexts";

    @Autowired
    public LiquibaseConfiguration(Environment environment, DataSource dataSource) {
        this.environment = environment;
        this.dataSource = dataSource;
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(CHANGE_LOG_FILE);
        liquibase.setDataSource(dataSource);
        liquibase.setContexts(environment.getProperty(CONTEXTS));
        return liquibase;
    }
}

