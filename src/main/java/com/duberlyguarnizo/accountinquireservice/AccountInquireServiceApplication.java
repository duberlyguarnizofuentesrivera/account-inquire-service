/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * This main class is the entry point for the Account Inquire Service application.
 * The {@code @EnableEurekaClient} annotation is used to enable the Eureka client for
 * service registration and discovery in a Eureka server.
 * The {@code @EnableMongoRepositories} annotation is used to enable the automatic repository
 * interface implementation for MongoDB.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories
public class AccountInquireServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AccountInquireServiceApplication.class, args);
  }
}
