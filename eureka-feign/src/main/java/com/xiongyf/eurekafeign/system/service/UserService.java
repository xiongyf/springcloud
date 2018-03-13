package com.xiongyf.eurekafeign.system.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "client", fallback = UserHystrix.class)
public interface UserService {

	@GetMapping("/user/currentUser")
	public Map<String, Object> currentUser();

	@PostMapping("/user/login")
	public Map<String, Object> login(@RequestParam("username") String username,
			@RequestParam("password") String password);

	@GetMapping("/user/logout")
	public Map<String, Object> logout();

}
