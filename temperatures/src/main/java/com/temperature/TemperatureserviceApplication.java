package com.temperature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.temperature.config.TemperatureConfig;

@SpringBootApplication
@Import(TemperatureConfig.class)
public class TemperatureserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemperatureserviceApplication.class, args);
	}
}
