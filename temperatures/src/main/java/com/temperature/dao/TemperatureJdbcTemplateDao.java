package com.temperature.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.temperature.model.Temperature;

@Repository
public interface TemperatureJdbcTemplateDao {

	public void insert(String id, String temperature);
	public void update(String id, String temperature);
	public void delete(String id);
	public List<Temperature> getById(String id);
	public List<Temperature> getAll();
}
