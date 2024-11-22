package com.adk.weatherwrapper.service;

import org.springframework.stereotype.Service;

import com.adk.weatherwrapper.model.ApiCallBuilder;

public interface IWeatherService {
	//This needs to return something else.. Need to make a model based on Visual Crossing return json
	public String buildURL(ApiCallBuilder apiCallBuilder);
}
