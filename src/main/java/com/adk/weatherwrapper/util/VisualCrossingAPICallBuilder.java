package com.adk.weatherwrapper.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import com.adk.weatherwrapper.model.OutputSection;
import com.adk.weatherwrapper.model.UnitGroup;

import lombok.Data;

@Data
public class VisualCrossingAPICallBuilder {
	
	@Value("${api.url}")
	private String baseURL;
	@Value("${api.key}")
	private String apiKey;
	private UnitGroup unitGroup = UnitGroup.US;
	private String city = "Washington";
	private String stateOrCountry = "DC";
	private Date startDate;
	private Date endDate;
	private OutputSection outputSection = OutputSection.CURRENT;
	
	/**
	 * 
	 * @return
	 */
	public String buildURL() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(baseURL + "/");
		
		sb.append(city + "%2C%20");
		
		sb.append(stateOrCountry + "/");
		
		if (endDate == null || startDate == null || endDate.equals(startDate))
			sb.append("today/");
		else
			sb.append(startDate.toString() + "/" + endDate.toString() + "?");
		
		sb.append("unitGroup=" + unitGroup.toString());
		
		sb.append("&include=" + outputSection.getUrlValue());
		
		sb.append("&key=" + apiKey);
		
		return sb.toString();
	}
	
}
