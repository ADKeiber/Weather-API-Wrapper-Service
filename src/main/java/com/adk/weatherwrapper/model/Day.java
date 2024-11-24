package com.adk.weatherwrapper.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Day {
	
	@JsonProperty("datetime")
	private Date dateTime; //"2024-11-22"
	
	@JsonProperty("datetimeEpoch")
	private int dateTimeEpoch;
	
	@JsonProperty("tempmax")
	private double tempMax;
	
	@JsonProperty("tempmin")
	private double tempMin;
	
	@JsonProperty("temp")
	private double temp;
	
	@JsonProperty("feelslikemax")
	private double feelsLikeMax;
	
	@JsonProperty("feelslikemin")
	private double feelsLikeMin;
	
	@JsonProperty("feelslike")
	private double feelsLike;
	
	@JsonProperty("dew")
	private double dew;
	
	@JsonProperty("humidity")
	private double humidity;
	
	@JsonProperty("precip")
	private double precip;
	
	@JsonProperty("precipProb")
	private double precipprob;
	
	@JsonProperty("precipcover")
	private double precipCover;
	
	@JsonProperty("preciptype")
	private List<String> precipType;
	
	@JsonProperty("now")
	private double now;
	
	@JsonProperty("windgust")
	private double windGust;
	
	@JsonProperty("windspeed")
	private double windSpeed;
	
	@JsonProperty("winddir")
	private double windDir;
	
	@JsonProperty("pressure")
	private double pressure;
	
	@JsonProperty("cloudcover")
	private double cloudCover;
	
	@JsonProperty("visibility")
	private double visibility;
	
	@JsonProperty("solarradiation")
	private double solarRadiation;
	
	@JsonProperty("solarenergy")
	private double solarEnergy;
	
	@JsonProperty("uvindex")
	private double uvIndex;
	
	@JsonProperty("severerisk")
	private double severeRisk;
	
	@JsonProperty("sunrise")
	private Date sunrise; // "07:32:10"
	
	@JsonProperty("sunsetEpoch")
	private int sunsetEpoch;
	
	@JsonProperty("moonphase")
	private double moonPhase;
	
	@JsonProperty("conditions")
	private String conditions;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("icon")
	private String icon;
	
	@JsonProperty("hours")
	private List<Hour> hours;
}
