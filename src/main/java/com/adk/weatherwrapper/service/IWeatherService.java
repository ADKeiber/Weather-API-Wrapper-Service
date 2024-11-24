package com.adk.weatherwrapper.service;

import com.adk.weatherwrapper.model.OutputSection;
import com.adk.weatherwrapper.model.UnitGroup;
import com.adk.weatherwrapper.model.WeatherResponse;

public interface IWeatherService {
	public WeatherResponse setupApiCallInformation(OutputSection outputSection,String city, 
			String stateOrCountry, String startDate, String endDate) throws Exception;
}
