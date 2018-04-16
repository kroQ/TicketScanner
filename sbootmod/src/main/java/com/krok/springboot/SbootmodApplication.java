package com.krok.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SbootmodApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbootmodApplication.class, args);
    }
}
