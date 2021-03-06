package com.saida.spring.rest.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(value="com.saida.spring.rest")
@EnableJpaRepositories(value="com.saida.spring.rest.repository")
@PropertySource("classpath:application.properties")
@EntityScan( basePackages = {"com.saida.spring.rest.repository"} )
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}