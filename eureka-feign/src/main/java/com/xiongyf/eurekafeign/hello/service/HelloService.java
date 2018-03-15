package com.xiongyf.eurekafeign.hello.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("client")
public interface HelloService {

	@GetMapping("/hello/say")
	public Map<String, String> say(@RequestParam("name") String name);
}
