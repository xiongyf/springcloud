package com.xiongyf.eurekaclient.system.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Value("${server.port}")
	private String port;

	@GetMapping("/say")
	public Map<String, String> say(@RequestParam("name") String name) {
		Map<String, String> map = new HashMap<>();
		map.put("msg", "Hello " + name + "!");
		map.put("port", port);
		return map;
	}
}
