package com.temperatures.model;

import java.util.ArrayList;
import java.util.List;

import com.temperatures.entity.Temperature;
public class TemperatureResponse {

	private List<Temperature> temperatureList;

	/**
	 * @return the temperatureList
	 */
	public List<Temperature> getTemperatureList() {
		if(temperatureList == null) {
			temperatureList = new ArrayList<Temperature>();
		}
		return temperatureList;
	}

	/**
	 * @param temperatureList the temperatureList to set
	 */
	public void setTemperatureList(List<Temperature> temperatureList) {
		this.temperatureList = temperatureList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TemperatureResponse [temperatureList=" + temperatureList + "]";
	}
}
