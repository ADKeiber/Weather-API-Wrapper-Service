package com.adk.weatherwrapper.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.adk.weatherwrapper.model.ApiCallBuilder;
import com.adk.weatherwrapper.model.WeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class VisualCrossingWeatherService implements IWeatherService {
	
	@Autowired 
	private RedisTemplate redisTemplate;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	ApiCallBuilder apiCallBuilder;
	
	@Override
	public WeatherResponse buildURL() {
		
		System.out.println(apiCallBuilder.buildVisualCrossingURL());
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create(apiCallBuilder.buildVisualCrossingURL()))
			    .method("GET", HttpRequest.BodyPublishers.noBody()).build();
		
			HttpResponse response = null;
			WeatherResponse wr = null;
			try {
				response = HttpClient.newHttpClient()
				    .send(request, HttpResponse.BodyHandlers.ofString());
				wr = objectMapper.readValue(response.body().toString(), WeatherResponse.class);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return wr;
	}
	
}
