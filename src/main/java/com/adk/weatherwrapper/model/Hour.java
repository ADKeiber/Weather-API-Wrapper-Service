package com.adk.weatherwrapper.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

import lombok.Data;

@Data
public class Hour implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8486186296153112284L;

	@JsonProperty("datetime")
	private String datetime;
	
	@JsonProperty("dateTimeEpoch")
	private int datetimeepoch;
	
	@JsonProperty("temp")
	private double temp;
	
	@JsonProperty("feelslike")
	private double feelslike;
	
	@JsonProperty("humidity")
	private double humidity;
	
	@JsonProperty("dew")
	private double dew;
	
	@JsonProperty("precip")
	private double precip;
	
	@JsonProperty("precipprob")
	private double precipprob;
	
	@JsonProperty("snow")
	private double snow;
	
	@JsonProperty("snowdepth")
	private double snowdepth;
	
	@JsonProperty("preciptype")
	private List<String> preciptype;
	
	@JsonProperty("windgust")
	private double windgust;
	
	@JsonProperty("windspeed")
	private double windspeed;
	
	@JsonProperty("winddir")
	private double winddir;
	
	@JsonProperty("pressure")
	private double pressure;
	
	@JsonProperty("visibility")
	private double visibility;
	
	@JsonProperty("cloudCover")
	private double cloudcover;
	
	@JsonProperty("solarradiation")
	private double solarradiation;
	
	@JsonProperty("solarenergy")
	private double solarenergy;
	
	@JsonProperty("uvindex")
	private double uvindex;
	
	@JsonProperty("severerisk")
	private double severerisk;
	
	@JsonProperty("conditions")
	private String conditions;
	
	@JsonProperty("icon")
	private String icon;
	
	@Override
	public String toString() {return new Gson().toJson(this);}
}
