package com.adk.weatherwrapper.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.adk.weatherwrapper.model.OutputSection;
import com.adk.weatherwrapper.model.UnitGroup;
import com.adk.weatherwrapper.model.WeatherResponse;
import com.adk.weatherwrapper.util.ApiCallBuilderUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.Resource;


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
	
	@Override
	public WeatherResponse setupApiCallInformation(OutputSection outputSection, String city, 
			String stateOrCountry, String startDate, String endDate) throws Exception {
		
		String cityState = startDate + city + "," + stateOrCountry;
		
		String apiCall = ApiCallBuilderUtil.buildVisualCrossingURL(baseURL, apiKey, OutputSection.HOURLY, city, stateOrCountry, startDate, endDate);
		
		System.out.println(apiCall);
		
		WeatherResponse wr;
		System.out.println(cityState);
		String storedData = redisTemplate.opsForList().getFirst(cityState);
		System.out.println(storedData);
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
	
	private WeatherResponse makeCall(String apiUrl) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(apiUrl))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
			
			HttpResponse<String> response = HttpClient.newHttpClient()
				.send(request, HttpResponse.BodyHandlers.ofString());
			return objectMapper.readValue(response.body().toString(), WeatherResponse.class);
	}
}
