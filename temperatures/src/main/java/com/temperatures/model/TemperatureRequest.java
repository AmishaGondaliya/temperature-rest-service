package com.temperatures.model;

public class TemperatureRequest {

	private Long id;
	private Double temperature;
	private String temperatureType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public String getTemperatureType() {
		return temperatureType;
	}
	public void setTemperatureType(String temperatureType) {
		this.temperatureType = temperatureType;
	}
	@Override
	public String toString() {
		return "TemperatureRequest [id=" + id + ", temperature=" + temperature + ", temperatureType=" + temperatureType
				+ "]";
	}
	
	
}
