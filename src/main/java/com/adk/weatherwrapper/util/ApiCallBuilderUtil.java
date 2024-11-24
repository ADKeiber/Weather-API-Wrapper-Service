package com.adk.weatherwrapper.util;

import com.adk.weatherwrapper.model.OutputSection;


/**
 * Utility class the builds a URL for an API for different Weather APIs.
 * Current Supported:
 * <p>
 * Visual Crossing API
 * 
 */
public class ApiCallBuilderUtil {

	/**
	 * Builds URL For Visual Crossing API
	 * @param baseURL {@link String} The Base URl for Visual Crossing that the query is built on
	 * @param apiKey {@link String} The Unique Key for the API
	 * @param outputSection {@link OutputSection} the type of data to return
	 * @param city {@link String} The city to retrieve weather data from
	 * @param stateOrCountry {@link String} the state or country (non US cities) that a city is in
	 * @param startDate {@link String} the start date for the weather data (Format: yyyy-MM-DD)
	 * @param endDate {@link String} the end date for the weather data (Format: yyyy-MM-DD)
	 * @return {@link String} the built Visual Crossing URL
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
