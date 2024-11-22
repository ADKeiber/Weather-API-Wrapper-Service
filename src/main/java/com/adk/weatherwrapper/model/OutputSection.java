package com.adk.weatherwrapper.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OutputSection { 
	DAILY("days"), HOURLY("hours"), CURRENT("current"); 
	
	String urlValue;
	
}
