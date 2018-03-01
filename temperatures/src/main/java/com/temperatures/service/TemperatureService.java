package com.temperatures.service;

import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.temperature.exception.UserDefException;
import com.temperatures.dao.TemperatureRepository;
import com.temperatures.entity.Temperature;
import com.temperatures.model.TemperatureRequest;
import com.temperatures.model.TemperatureResponse;
import com.temperatures.util.DateUtility;


@RestController
public class TemperatureService {

	public static final Logger log = LoggerFactory.getLogger(TemperatureService.class);
	
	
	@Autowired
	private TemperatureRepository repository;
	
	
	@RequestMapping(method = RequestMethod.GET,path="/temperature/{temperatureId}")
	public @ResponseBody TemperatureResponse getTemperature(@PathVariable("temperatureId") Long temperatureId) {
		log.info("TemperatureService : getTemperature [IN]");
		Temperature temp = repository.findById(temperatureId);
		TemperatureResponse response = new TemperatureResponse();
		
		Temperature fTemp = new Temperature();
		fTemp.setId(temp.getId());
		fTemp.setCreate_date(temp.getCreate_date());
		System.out.println(temp.getCreate_date());
		fTemp.setUpdate_date(temp.getUpdate_date());
		fTemp.setTemperature(((Double.valueOf(temp.getTemperature()) * 1.8) + 32));
		
		response.getTemperatureList().add(fTemp);
		response.getTemperatureList().add(temp);
		log.info("Temp : " + temp);
		log.info("TemperatureService : getTemperature [OUT]");
		return response;
	}
	
	
	@RequestMapping(method = RequestMethod.GET,value = "/temperatures")
	public @ResponseBody TemperatureResponse fetchPostTemperature() {
		log.info("TemperatureService : fetchPostTemperature() [IN]");
		TemperatureResponse response = new TemperatureResponse();
		List<Temperature> tempCList = repository.findAll();
		List<Temperature> tempFList = new ArrayList<Temperature>();
		for(Temperature temp : tempCList) {
			Temperature fTemp = new Temperature();
			fTemp.setId(temp.getId());
			fTemp.setCreate_date(temp.getCreate_date());
			fTemp.setUpdate_date(temp.getUpdate_date());
			fTemp.setTemperature(((temp.getTemperature() * 1.8) + 32));
			tempFList.add(fTemp);
		}
		tempCList.addAll(tempFList);
		Collections.sort(tempCList,(t1,t2)-> t1.getId().compareTo(t2.getId()));
		response.getTemperatureList().addAll(tempCList);
		
		log.info("TemperatureService : fetchPostTemperature() [OUT]");
		System.out.println(new Date());
		return response;
	}
	
	
	@RequestMapping(method = RequestMethod.PUT,value = "/temperature")
	public ResponseEntity<?> updateTemperaturePut(@RequestBody TemperatureRequest request) {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		if(request != null && request.getId() != null) {
			log.info("TemperatureService : insertTemperature() [IN] : Temperature - > " + request.getTemperature());
			Temperature temp = repository.findOne(request.getId());
			Long tempid = temp.getId(); 
			if (tempid == null) {
				throw new UserDefException(new Date(), "Temperature Id not present in database");
			}
					
			// 	update db with the id received in the request
			Temperature temp1 = repository.save(new Temperature(request.getId(), request.getTemperature(), null, String.valueOf(currentTimestamp)));
			log.info("TemperatureService : insertTemperature() [OUT] : Temperature - > " + request.getTemperature());
			return ResponseEntity.ok("Temperature Recored Updated !");
		}
		
		else {
			if(request != null ) {
				log.info("TemperatureService : insertTemperature() [IN] : Temperature - > " + request.getTemperature());
				// 	update db with the id received in the request
				Temperature temp2 = repository.save(new Temperature(request.getId(), request.getTemperature(), String.valueOf(currentTimestamp), null));
				log.info("TemperatureService : insertTemperature() [OUT] : Temperature - > " + request.getTemperature());
				return ResponseEntity.ok("Temperature Recored Inserted !");
			}
		}
		
		
		
		
		return ResponseEntity.ok("Temperature !");
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/temperature")
	public ResponseEntity<?> updateTemperaturePost(@RequestBody TemperatureRequest request) {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		if(request != null && request.getId() != null) {
			log.info("TemperatureService : insertTemperature() [IN] : Temperature ID - > " + request.getId());
			// 	update db with the id received in the request
			Temperature temp = repository.save(new Temperature(request.getId(), request.getTemperature(), null, String.valueOf(currentTimestamp)));
			log.info("TemperatureService : insertTemperature() [OUT] : Temperature ID - > " + request.getId());
			return ResponseEntity.ok("Temperature Recored Updated !");
		}
		else {
			if (request != null ) {
				log.info("TemperatureService : insertTemperature() [IN] : Temperature - > " + request.getTemperature());
				// 	update db with the id received in the request
				Temperature temp = repository.save(new Temperature(request.getId(), request.getTemperature(), String.valueOf(currentTimestamp), null));
				log.info("TemperatureService : insertTemperature() [OUT] : Temperature - > " + request.getTemperature());
				return ResponseEntity.ok("Temperature Recored Inserted !");
			}
		}
		
		
		return ResponseEntity.ok("Temperature !");
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/temperature/{temperatureId}")
	public ResponseEntity<?> deleteTemperature(@PathVariable Long temperatureId) {
		log.info("TemperatureService : deleteTemperature() [IN] : Temperature ID - > " + temperatureId);
		Temperature temp = repository.findOne(temperatureId);
		// delete entry with the id received in the request
		if(temp != null && temp.getId() != null) {
			repository.delete(Long.valueOf(temperatureId));
		}
		log.info("TemperatureService : deleteTemperature() [OUT] : Temperature ID - > " + temperatureId);
		return ResponseEntity.ok("Temperature deleted");
	}
	
	@ExceptionHandler({SQLException.class,DataAccessException.class})
	  public String databaseError() {
	    return "databaseError : No data found";
	  }
	
	
	@ExceptionHandler({UserDefException.class})
	 public String handleUserDefError(HttpServletRequest req, Exception ex){
		  String exceptionResponse;
		 exceptionResponse="Exception is " + ex;
		 log.info(exceptionResponse,ex);
		 return exceptionResponse;
	 }
	
	 @ExceptionHandler(NullPointerException.class)
	 public String handleError(HttpServletRequest req, Exception ex){
		  String exceptionResponse;
		 exceptionResponse="Request: "+ req.getRequestURI()+" raised an Exception. Exception: Temperature id not found\n";
		 log.info(exceptionResponse,ex);
		 return exceptionResponse;
	 }
	 
	 
	 
}


