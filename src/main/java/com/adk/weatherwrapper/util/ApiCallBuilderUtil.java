package com.adk.weatherwrapper.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.adk.weatherwrapper.model.OutputSection;
import com.adk.weatherwrapper.model.UnitGroup;

import lombok.Data;


public class ApiCallBuilderUtil {
	
	/**
	 * 
	 * @return
	 */
	public static String buildVisualCrossingURL(String baseURL, String apiKey, OutputSection outputSection, String city, 
			String stateOrCountry, String startDate, String endDate) {

		StringBuilder sb = new StringBuilder();

		sb.append(baseURL);

		sb.append(city + "%2C%20");

		sb.append(stateOrCountry + "/");
		
		sb.append(startDate.toString() + "/" + endDate.toString() + "?");

		sb.append("unitGroup=us");

		sb.append("&include=" + outputSection.getUrlValue());

		sb.append("&key=" + apiKey);
		
		sb.append("&contentType=json");
		
		return sb.toString();
	}

}
