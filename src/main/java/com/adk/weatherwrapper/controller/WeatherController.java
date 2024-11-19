package com.adk.weatherwrapper.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

	@Value("${api.key}")
	private String userBucketPath;
	
	
	@GetMapping("/test")
	public ResponseEntity<Object> test() {
		System.out.println(userBucketPath);
		return new ResponseEntity<>(userBucketPath, HttpStatus.OK);
	}
}
