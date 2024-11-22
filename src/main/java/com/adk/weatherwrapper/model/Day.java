package com.adk.weatherwrapper.model;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class Day {
	private Date datetime; //"2024-11-22"
	private int datetimeEpoch;
	private double tempmax;
	private double tempmin;
	private double temp;
	private double feelslikemax;
	private double feelslikemin;
	private double feelslike;
	private double dew;
	private double humidity;
	private double precip;
	private double precipprob;
	private double recipcover;
	private List<String> preciptype;
	private double now;
	private double windgust;
	private double windspeed;
	private double winddir;
	private double pressure;
	private double cloudcover;
	private double visibility;
	private double solarradiation;
	private double solarenergy;
	private double uvindex;
	private double severerisk;
	private Date sunrise; // "07:32:10"
	private int sunsetEpoch;
	private double moonphase;
	private String conditions;
	private String description;
	private String icon;
	private List<Hour> hours;
}
