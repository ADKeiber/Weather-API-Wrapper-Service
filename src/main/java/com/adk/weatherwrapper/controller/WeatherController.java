package com.adk.weatherwrapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import jakarta.annotation.Resource;

@RestController
public class WeatherController {
	private static int counter = 1;
	
	@Value("${api.key}")
	private String userBucketPath;
	
	  @Autowired
	  private RedisTemplate redisTemplate;
	
	@GetMapping("/test/{testValue}")
	public ResponseEntity<Object> test(@PathVariable String testValue) {
		final String uri = String.format("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/London,UK?key=%s", userBucketPath);

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
		try {
			redisTemplate.opsForHash().put("Test", "Value", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		System.out.println(userBucketPath);
		System.out.println(redisTemplate.opsForHash().values("Test").get(0).toString().replace('\\', ' '));
		String formatted = gson.toJson(redisTemplate.opsForHash().values("Test").get(0).toString());
		formatted = formatted.replace("\"", "");
		formatted = formatted.replace("\\", "\"");
		return new ResponseEntity<>(formatted, HttpStatus.OK);
	}
}
