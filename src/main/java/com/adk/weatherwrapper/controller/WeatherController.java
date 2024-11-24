package com.adk.weatherwrapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.adk.weatherwrapper.model.OutputSection;
import com.adk.weatherwrapper.service.VisualCrossingWeatherService;

/**
 * Controller that contains end points for access a locations weather on a specified date
 * Program Goals/Limitations:
 * Can edit location, data range, units, 
 * daily, current, or hourly
 */
@RestController
public class WeatherController {
	
	@Autowired
	private VisualCrossingWeatherService visualCrossingWeatherService;

	@GetMapping("/hourly/{city}/{state}/{startDate}/{endDate}")
	public ResponseEntity<Object> getHourlyWeather(@PathVariable String city, @PathVariable String state, @PathVariable String startDate, @PathVariable String endDate) throws Exception{
		return new ResponseEntity<>(visualCrossingWeatherService.makeApiCall(OutputSection.HOURLY, city, state, startDate, endDate), HttpStatus.OK);
	}
	
	@GetMapping("/daily/{city}/{state}/{startDate}/{endDate}")
	public ResponseEntity<Object> getDailyWeather(@PathVariable String city, @PathVariable String state, @PathVariable String startDate, @PathVariable String endDate) throws Exception{
		return new ResponseEntity<>(visualCrossingWeatherService.makeApiCall(OutputSection.DAILY, city, state, startDate, endDate), HttpStatus.OK);
	}
	
	@GetMapping("/current/{city}/{state}/{startDate}/{endDate}")
	public ResponseEntity<Object> getCurrentWeather(@PathVariable String city, @PathVariable String state, @PathVariable String startDate, @PathVariable String endDate) throws Exception{
		return new ResponseEntity<>(visualCrossingWeatherService.makeApiCall(OutputSection.CURRENT, city, state, startDate, endDate), HttpStatus.OK);
	}
}
