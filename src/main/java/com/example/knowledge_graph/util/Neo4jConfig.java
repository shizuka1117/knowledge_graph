package com.example.knowledge_graph.util;

import org.neo4j.driver.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * neo4j连接配置
 */
@Configuration
public class Neo4jConfig {
    @Value("${spring.data.neo4j.uri}")
    private String neo4jUri;

    @Value("${spring.data.neo4j.username}")
    private String neo4jUsername;

    @Value("${spring.data.neo4j.password}")
    private String neo4jPassword;

    @Bean
    public Session getSession(){
        Driver driver = GraphDatabase.driver(neo4jUri, AuthTokens.basic(neo4jUsername, neo4jPassword));
        SessionConfig sessionConfig = SessionConfig.defaultConfig();
        return driver.session(sessionConfig);
    }
}
