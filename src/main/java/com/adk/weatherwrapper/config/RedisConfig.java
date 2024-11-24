package com.adk.weatherwrapper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Configuration for Redis Cache 
 */
@Configuration
public class RedisConfig {
	
	@Bean
	LettuceConnectionFactory  jedisConnectionFactory() {
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("127.0.0.1", 6379);
		return new LettuceConnectionFactory (config);
	}
	
	@Bean
	StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
		StringRedisTemplate template = new StringRedisTemplate();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}
}
