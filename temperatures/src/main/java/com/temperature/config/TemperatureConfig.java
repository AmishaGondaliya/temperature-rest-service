package com.temperature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.temperature.dao.TemperatureJdbcTemplateDao;
import com.temperature.dao.TemperatureJdbcTemplateDaoImpl;

@Configuration
public class TemperatureConfig {

	@Bean
	public TemperatureJdbcTemplateDao temperatureJdbcTemplateDao() {
		return new TemperatureJdbcTemplateDaoImpl();
	}
}
