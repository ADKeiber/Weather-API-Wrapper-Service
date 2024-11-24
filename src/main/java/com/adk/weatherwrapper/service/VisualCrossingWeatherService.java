package com.adk.weatherwrapper.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.adk.weatherwrapper.model.OutputSection;
import com.adk.weatherwrapper.model.WeatherResponse;
import com.adk.weatherwrapper.util.ApiCallBuilderUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementation of weather service interface that uses formatting specific to
 * the Visual Crossing Weather Service
 */
@Service
public class VisualCrossingWeatherService implements IWeatherService {
	
	@Autowired
	private StringRedisTemplate redisTemplate;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Value("${api.url}")
	private String baseURL;
	
	@Value("${api.key}")
	private String apiKey;
	
	/**
	  * {@inheritDoc}
	  * Uses the Visual Crossing Weather API
	  */
	@Override
	public WeatherResponse makeApiCall(OutputSection outputSection, String city, 
			String stateOrCountry, String startDate, String endDate) throws Exception {
		
		String cityState = startDate + city + "," + stateOrCountry;
		
		String apiCall = ApiCallBuilderUtil.buildVisualCrossingURL(baseURL, apiKey, OutputSection.HOURLY, city, stateOrCountry, startDate, endDate);
		WeatherResponse wr;
		String storedData = redisTemplate.opsForList().getFirst(cityState);
		
		if(startDate.equals(endDate) && outputSection != OutputSection.CURRENT) {
			
				if(storedData != null) {
					System.out.println("Getting Data from Redis...");
					wr = objectMapper.readValue(storedData, WeatherResponse.class);
					if(outputSection != OutputSection.HOURLY)
						wr.getDays().get(0).setHours(null);
					
				} else {
					System.out.println("Setting Data for Redis...");
					wr = makeCall(apiCall);
					redisTemplate.opsForList().leftPush(cityState, wr.toString());
					redisTemplate.expire(cityState, 1, TimeUnit.DAYS);
					if(outputSection != OutputSection.HOURLY)
						wr.getDays().get(0).setHours(null);
				}
				
		} else {
			apiCall = ApiCallBuilderUtil.buildVisualCrossingURL(baseURL, apiKey, outputSection, city, stateOrCountry, startDate, endDate);
			wr = makeCall(apiCall);
		}
		
		return wr;
	}
	

	/**
	 * Makes an API call given its URL and returns a weather response
	 * @param apiUrl {@link String} the URL for the API request
	 * @return {@link WeatherResponse} the mapped response from the API Call
	 * @throws InterruptedException If API call fails
	 * @throws IOException If object fails to map from JSON String
	 */
	private WeatherResponse makeCall(String apiUrl) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(apiUrl))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
			
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return objectMapper.readValue(response.body().toString(), WeatherResponse.class);
	}
}
