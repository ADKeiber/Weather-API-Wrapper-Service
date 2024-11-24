package com.adk.weatherwrapper.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

import lombok.Data;

@Data
@Component
public class WeatherResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("resolvedAddress")
	private String resolvedaddress;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("timezone")
	private String timezone;
	
	@JsonProperty("days")
	private List<Day> days;
	
	@Override
	public String toString() {return new Gson().toJson(this);}
}
