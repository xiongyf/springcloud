package com.xiongyf.eurekafeign.config.hystrix;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixConfig {

	@Bean
	public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy() {
		return new FeignHystrixConcurrencyStrategy();
	}
}
