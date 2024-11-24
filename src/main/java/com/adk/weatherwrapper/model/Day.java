package com.adk.weatherwrapper.model;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import lombok.Data;

/**
 * DTO class that holds the weather information for a day
 */
@Data
public class Day implements Serializable {
	
	private static final long serialVersionUID = -3026446132044188445L;

	@JsonProperty("datetime")
	private String datetime;
	
	@JsonProperty("datetimeEpoch")
	private int datetimeEpoch;
	
	@JsonProperty("tempmax")
	private double tempmax;
	
	@JsonProperty("tempmin")
	private double tempmin;
	
	@JsonProperty("temp")
	private double temp;
	
	@JsonProperty("feelslikemax")
	private double feelslikemax;
	
	@JsonProperty("feelslikemin")
	private double feelslikemin;
	
	@JsonProperty("feelslike")
	private double feelslike;
	
	@JsonProperty("dew")
	private double dew;
	
	@JsonProperty("humidity")
	private double humidity;
	
	@JsonProperty("precip")
	private double precip;
	
	@JsonProperty("precipprob")
	private double precipprob;
	
	@JsonProperty("precipcover")
	private double precipcover;
	
	@JsonProperty("preciptype")
	private List<String> preciptype;
	
	@JsonProperty("now")
	private double now;
	
	@JsonProperty("windgust")
	private double windgust;
	
	@JsonProperty("windspeed")
	private double windspeed;
	
	@JsonProperty("winddir")
	private double winddir;
	
	@JsonProperty("pressure")
	private double pressure;
	
	@JsonProperty("cloudcover")
	private double cloudcover;
	
	@JsonProperty("visibility")
	private double visibility;
	
	@JsonProperty("solarradiation")
	private double solarradiation;
	
	@JsonProperty("solarenergy")
	private double solarenergy;
	
	@JsonProperty("uvindex")
	private double uvindex;
	
	@JsonProperty("severerisk")
	private double severerisk;
	
	@JsonProperty("sunrise")
	private String sunrise;
	
	@JsonProperty("sunsetEpoch")
	private int sunsetepoch;
	
	@JsonProperty("moonphase")
	private double moonphase;
	
	@JsonProperty("conditions")
	private String conditions;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("icon")
	private String icon;
	
	@JsonProperty("hours")
	private List<Hour> hours;
	
	@Override
	public String toString() {return new Gson().toJson(this);}
}
