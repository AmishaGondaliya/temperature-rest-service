package com.temperature.model;

import java.util.Date;

public class Temperature {

	private long id;
	private String temperatureInCelsius;
	private String temperatureInFahrenheit;
	private String createTimeStamp;
	private String updateTimeStamp;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTemperatureInCelsius() {
		return temperatureInCelsius;
	}
	public void setTemperatureInCelsius(String temperatureInCelsius) {
		this.temperatureInCelsius = temperatureInCelsius;
	}
	public String getTemperatureInFahrenheit() {
		return temperatureInFahrenheit;
	}
	public void setTemperatureInFahrenheit(String temperatureInFahrenheit) {
		this.temperatureInFahrenheit = temperatureInFahrenheit;
	}
	public String getCreateTimeStamp() {
		return createTimeStamp;
	}
	public void setCreateTimeStamp(String createTimeStamp) {
		this.createTimeStamp = createTimeStamp;
	}
	public String getUpdateTimeStamp() {
		return updateTimeStamp;
	}
	public void setUpdateTimeStamp(String updateTimeStamp) {
		this.updateTimeStamp = updateTimeStamp;
	}
	@Override
	public String toString() {
		return "Temperature [id=" + id + ", temperatureInCelsius=" + temperatureInCelsius + ", temperatureInFahrenheit="
				+ temperatureInFahrenheit + ", createTimeStamp=" + createTimeStamp + ", updateTimeStamp="
				+ updateTimeStamp + "]";
	}

}
