package com.temperatures.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"com.temperatures"})
@EnableJpaRepositories("com.temperatures.dao")
@EntityScan("com.temperatures.entity")
public class TemperatureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemperatureServiceApplication.class, args);
	}
}
