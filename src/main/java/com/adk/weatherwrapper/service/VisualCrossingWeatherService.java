package com.adk.weatherwrapper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.adk.weatherwrapper.model.ApiCallBuilder;


@Service
public class VisualCrossingWeatherService implements IWeatherService {
	
	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public String buildURL(ApiCallBuilder apiCallBuilder) {
		// TODO Auto-generated method stub
		return apiCallBuilder.buildVisualCrossingURL();
	}
	
}
