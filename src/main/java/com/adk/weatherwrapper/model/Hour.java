package com.adk.weatherwrapper.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Hour {

	@JsonProperty("datetime")
	private String dateTime;
	
	@JsonProperty("dateTimeEpoch")
	private int datetimeEpoch;
	
	@JsonProperty("temp")
	private double temp;
	
	@JsonProperty("feelslike")
	private double feelsLike;
	
	@JsonProperty("humidity")
	private double humidity;
	
	@JsonProperty("dew")
	private double dew;
	
	@JsonProperty("precip")
	private double precip;
	
	@JsonProperty("precipprob")
	private double precipProb;
	
	@JsonProperty("snow")
	private double snow;
	
	@JsonProperty("snowdepth")
	private double snowDepth;
	
	@JsonProperty("preciptype")
	private List<String> precipType;
	
	@JsonProperty("windgust")
	private double windGust;
	
	@JsonProperty("windspeed")
	private double windSpeed;
	
	@JsonProperty("winddir")
	private double windDir;
	
	@JsonProperty("pressure")
	private double pressure;
	
	@JsonProperty("visibility")
	private double visibility;
	
	@JsonProperty("cloudCover")
	private double cloudcover;
	
	@JsonProperty("solarradiation")
	private double solarRadiation;
	
	@JsonProperty("solarenergy")
	private double solarEnergy;
	
	@JsonProperty("uvindex")
	private double uvIndex;
	
	@JsonProperty("severerisk")
	private double severeRisk;
	
	@JsonProperty("conditions")
	private String conditions;
	
	@JsonProperty("icon")
	private String icon;
	
}
