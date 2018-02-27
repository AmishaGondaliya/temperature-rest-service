package com.temperature.service;

import java.util.List;
import com.temperature.model.*;

public class TemperatureResponse {

	private List<Temperature> temperatureList;

	/**
	 * @return the temperatureList
	 */
	public List<Temperature> getTemperatureList() {
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
