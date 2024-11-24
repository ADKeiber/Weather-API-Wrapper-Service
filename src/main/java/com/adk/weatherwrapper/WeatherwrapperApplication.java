package com.adk.weatherwrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WeatherwrapperApplication {
	public static void main(String[] args) {
		SpringApplication.run(WeatherwrapperApplication.class, args);
	}
}
