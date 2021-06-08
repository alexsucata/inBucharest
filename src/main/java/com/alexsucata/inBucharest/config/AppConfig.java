package com.alexsucata.inBucharest.config;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.alexsucata.inBucharest.entities")
@ComponentScan("com.alexsucata.inBucharest")
@EnableJpaRepositories("com.alexsucata.inBucharest.repositories")
public class AppConfig {



}
