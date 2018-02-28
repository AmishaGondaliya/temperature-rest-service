package com.temperatures.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtility {

	public static final Logger log = LoggerFactory.getLogger(DateUtility.class);
	
	private static final String DATE_FORMAT = "EEE, d MMM yyyy HH:mm:ss Z";
	
	public static String formatDate(Date date){
		String d = null;
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		d = sdf.format(date);
		if(d == null) {
			return sdf.format(new Date());
		}
		return d;
	}
}
