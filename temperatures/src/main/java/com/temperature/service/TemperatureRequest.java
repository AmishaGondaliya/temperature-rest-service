package com.temperature.service;

public class TemperatureRequest {

	private int id;
	private String temperature;
	private String temperatureType;
	
	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getTemperatureType() {
		return temperatureType;
	}

	public void setTemperatureType(String temperatureType) {
		this.temperatureType = temperatureType;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TemperatureRequest [id=" + id + ", temperature=" + temperature + ", temperatureType=" + temperatureType
				+ "]";
	}
}
