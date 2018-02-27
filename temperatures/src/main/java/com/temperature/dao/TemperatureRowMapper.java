package com.temperature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.RowMapper;

import com.temperature.model.Temperature;


public class TemperatureRowMapper implements RowMapper<Temperature>{

	@Override
	public Temperature mapRow(ResultSet rs, int rowNum) throws SQLException {
		Temperature temperature = new Temperature();
		temperature.setId(Long.valueOf(rs.getString("ID")));
		
		String temp = rs.getString("TEMPERATURE");
		if(temp != null && StringUtils.isNotEmpty(temp)) {
			temperature.setTemperatureInCelsius(temp);
		}
		String createDate = rs.getString("CREATE_DATE");
		if(createDate != null && StringUtils.isNotEmpty(createDate)) {
			temperature.setCreateTimeStamp(createDate);
		}
		String updateDate = rs.getString("UPDATE_DATE");
		if(updateDate != null && StringUtils.isNotEmpty(updateDate)) {
			temperature.setUpdateTimeStamp(updateDate);
		}
		return temperature;
	}


}
