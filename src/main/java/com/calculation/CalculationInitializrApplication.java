package com.calculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.calculation.respository")
public class CalculationInitializrApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculationInitializrApplication.class, args);
	}

}
