package com.adk.weatherwrapper.service;

import com.adk.weatherwrapper.model.OutputSection;
import com.adk.weatherwrapper.model.WeatherResponse;

/**
 * Interface that defines the required methods for a weather service
 */
public interface IWeatherService {
	
	/**
	 * Makes an API Request based on API criteria
	 * @param outputSection {@link OutputSection} the type of data to return
	 * @param city {@link String} the city to get data for
	 * @param stateOrCountry {@link String} the name of the state or country (non US cities) that the city is in
	 * @param startDate {@link String} the start date for the weather data
	 * @param endDate {@link String} the end date for the weather data
	 * @return {@link WeatherResponse} The weather data
	 * @throws Exception if redis cache interaction fails
	 */
	public WeatherResponse makeApiCall(OutputSection outputSection, String city, 
			String stateOrCountry, String startDate, String endDate) throws Exception;
}
