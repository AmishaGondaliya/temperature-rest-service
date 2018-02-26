package com.temperature.service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.temperature.dao.TemperatureJdbcTemplateDao;
import com.temperature.model.Temperature;


@RestController
public class TemperatureService {

	Logger log = LoggerFactory.getLogger(TemperatureService.class);
	
	@Autowired
	private TemperatureJdbcTemplateDao temperatureJdbcTemplateDao;
	
	@RequestMapping("/")
	public String message() {
		return "Hello World! Temperature is : 40";
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/temperature/{temperatureId}")
	public Collection<Temperature> fetchTemperature(@PathVariable String temperatureId) {
		log.info("TemperatureService : fetchTemperature() [IN] : Temperature ID - > " + temperatureId);
		List<Temperature> tempList = temperatureJdbcTemplateDao.getById(temperatureId);
		for(Temperature temp : tempList) {
			String tempInC = temp.getTemperatureInCelsius();
			BigInteger tempC = new BigInteger(tempInC);
			temp.setTemperatureInFahrenheit(String.valueOf(( tempC.doubleValue() * 1.8 ) + 32));
		}
		log.info("TemperatureService : fetchTemperature() [OUT] : Temperature ID - > " + temperatureId);
		return tempList;
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/temperatures")
	public Collection<Temperature> fetchAllTemperature() {
		log.info("TemperatureService : fetchAllTemperature() [IN]");
		List<Temperature> tempList = temperatureJdbcTemplateDao.getAll();
		for(Temperature temp : tempList) {
			String tempInC = temp.getTemperatureInCelsius().trim();
			BigInteger tempC = new BigInteger(tempInC);
			temp.setTemperatureInFahrenheit(String.valueOf(( tempC.doubleValue() * 1.8 ) + 32));
		}
		log.info("TemperatureService : fetchAllTemperature() [OUT]");
		return tempList;
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/inserttemperaturedata")
	public void insertTemperatureData(@RequestBody TemperatureRequest request) {
		if(request != null) {
			log.info("TemperatureService : insertTemperatureData() [IN] : Temperature ID - > " + request.getId());
			temperatureJdbcTemplateDao.insert(String.valueOf(request.getId()),request.getTemperature());
			log.info("TemperatureService : insertTemperatureData() [OUT] : Temperature ID - > " + request.getId());
		}
	}
	
	
	@RequestMapping(method = RequestMethod.PUT,value = "/temperature")
	public ResponseEntity<?> updateTemperature(@RequestBody TemperatureRequest request) {
		if(request != null) {
			System.out.println("TemperatureService : updateTemperature() : Temperature ID - > " + request.getId());
			// 	update db with the id received in the request
			temperatureJdbcTemplateDao.update(String.valueOf(request.getId()),request.getTemperature());
		}
		return ResponseEntity.ok("Temperature Recored Inserted !");
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/temperature/{temperatureId}")
	public ResponseEntity<?> deleteTemperature(@PathVariable String temperatureId) {
		System.out.println("TemperatureService : deleteTemperature() : Temperature ID - > " + temperatureId);
		// delete entry with the id received in the request
		temperatureJdbcTemplateDao.delete(temperatureId);
		return ResponseEntity.ok("Temperature deleted");
	}
}
