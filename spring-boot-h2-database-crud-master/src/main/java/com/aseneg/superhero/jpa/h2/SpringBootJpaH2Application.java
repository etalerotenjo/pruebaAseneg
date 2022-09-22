package com.aseneg.superhero.jpa.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.aseneg.superhero.*"})
@EnableJpaRepositories(basePackages = "com.aseneg.superhero.jpa.h2.repository")
@EntityScan(basePackages = "com.aseneg.superhero.jpa.h2.model")
public class SpringBootJpaH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaH2Application.class, args);
	}

}
