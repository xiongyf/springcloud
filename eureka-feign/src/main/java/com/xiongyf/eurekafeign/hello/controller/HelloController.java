package com.xiongyf.eurekafeign.hello.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiongyf.eurekafeign.hello.service.HelloService;


@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@Autowired
	private HelloService helloService;
	
	@GetMapping("/say")
	public Map<String, String> say(@RequestParam("name") String name) {
		return helloService.say(name);
	}
}
