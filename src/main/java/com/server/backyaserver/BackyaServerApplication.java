package com.server.backyaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.query.JSqlParserUtils;

@EnableJpaAuditing
@SpringBootApplication
public class BackyaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackyaServerApplication.class, args);
    }

}
