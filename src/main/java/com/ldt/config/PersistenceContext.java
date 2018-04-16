package com.ldt.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Ludovic on 16/04/2018.
 */
@Configuration
@EnableNeo4jRepositories("com.ldt.repository")
@EnableTransactionManagement
@ComponentScan("com.ldt")
public class PersistenceContext {

    @Bean(name = "configu")
    public org.neo4j.ogm.config.Configuration getConfiguration() {
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
                .uri("bolt://neo4j:starwarsgraph@localhost:11002")
                .connectionPoolSize(150)
                .build();
        return configuration;
    }
    @DependsOn(value = "configu")
    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory(getConfiguration(), "com.ldt.dto");
    }
}
