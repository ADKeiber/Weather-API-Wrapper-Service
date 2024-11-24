package com.adk.weatherwrapper.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class WeatherResponse {
	
	@JsonProperty("datetime")
	private String resolvedAddress;
	
	@JsonProperty("datetime")
	private String address;
	
	@JsonProperty("datetime")
	private String timeZone;
	
	@JsonProperty("datetime")
	private List<Day> days;
}
