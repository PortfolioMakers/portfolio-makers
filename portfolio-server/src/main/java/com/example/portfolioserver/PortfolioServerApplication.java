package com.example.portfolioserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@Import(JacksonConfig.class)
public class PortfolioServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfolioServerApplication.class, args);
    }

}
