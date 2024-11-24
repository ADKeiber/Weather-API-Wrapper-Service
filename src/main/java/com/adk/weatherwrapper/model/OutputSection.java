package com.adk.weatherwrapper.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum used to determine the return data of an API call.
 * Options: 
 * Daily (returned data will be the average weather for the day)
 * Hourly (returned data will include hourly data)
 * Current (returned data will be the current weather)
 */
@AllArgsConstructor
@Getter
public enum OutputSection { 
	DAILY("days"), HOURLY("hours"), CURRENT("current"); 
	String urlValue;
}
