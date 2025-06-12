package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo", "repository", "service", "controller", "Model", "dto"})
@EntityScan(basePackages = "Model")
@EnableJpaRepositories(basePackages = "repository")
public class Demo2Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

}
