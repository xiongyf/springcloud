package com.xiongyf.eurekafeign.system.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class UserHystrix implements UserService {

	@Override
	public Map<String, Object> currentUser() {
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "Some problems occurred, please try again later");
		return map;
	}

	@Override
	public Map<String, Object> login(String username, String password) {
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "Some problems occurred, please try again later");
		return map;
	}

	@Override
	public Map<String, Object> logout() {
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "Some problems occurred, please try again later");
		return map;
	}

}
