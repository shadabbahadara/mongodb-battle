package com.khan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.khan.repository.mongodb")
@Configuration
public class MongoDBConfig {

}
