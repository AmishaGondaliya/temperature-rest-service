package com.temperature.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.temperature.model.Temperature;

public class TemperatureJdbcTemplateDaoImpl implements TemperatureJdbcTemplateDao{

	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public void setDataSource(@Autowired DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public void insert(String id, String temperature) {
		Map<String,String> namedParameters = new HashMap<String,String>();
		namedParameters.put("ID", id);
		namedParameters.put("TEMPERATURE", temperature);
		jdbcTemplate.update("INSERT INTO TEMPERATURE VALUES(:ID,CURDATE(),:TEMPERATURE,CURDATE())", namedParameters);
	}
	
	@Override
	public void update(String id, String temperature) {
		Map<String,String> namedParameters = new HashMap<String,String>();
		namedParameters.put("ID", id);
		namedParameters.put("TEMPERATURE", temperature);
		jdbcTemplate.update("UPDATE TEMPERATURE SET TEMPERATURE=:TEMPERATURE , UPDATE_DATE=CURDATE() WHERE ID=:ID", namedParameters);
	}
	
	@Override
	public void delete(String id) {
		Map<String,String> namedParameters = new HashMap<String,String>();
		namedParameters.put("ID", id);
		jdbcTemplate.update("DELETE FROM TEMPERATURE WHERE ID=:ID", namedParameters);
	}
	@Override
	public List<Temperature> getById(String id){
		Map<String,String> namedParameters = new HashMap<String,String>();
		namedParameters.put("ID", id);
		List<Temperature> tempList = jdbcTemplate.query("SELECT * FROM TEMPERATURE WHERE ID=:ID" , namedParameters, new TemperatureRowMapper());
		return tempList;
	}
	@Override
	public List<Temperature> getAll(){
		List<Temperature> tempList = jdbcTemplate.query("SELECT * FROM TEMPERATURE", new TemperatureRowMapper());
		return tempList;
	}
}
