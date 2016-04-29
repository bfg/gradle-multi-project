package com.example.something.restservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan
@EnableConfigurationProperties
class RestSpringApp {
    static {
        System.setProperty("org.jboss.logging.provider", "slf4j")
    }

    static void main(String... args) {
        SpringApplication.run(RestSpringApp, args);
    }
}