package com.xiongyf.eurekafeign.system.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiongyf.eurekafeign.system.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/currentUser")
	public Map<String, Object> currentUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("feign sessionId:" + session.getId());
		return userService.currentUser();
	}

	@PostMapping("/login")
	public Map<String, Object> login(HttpServletRequest request, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		HttpSession session = request.getSession();
		System.out.println("feign sessionId:" + session.getId());
		return userService.login(username, password);
	}

	@GetMapping("/logout")
	public Map<String, Object> logout() {
		return userService.logout();
	}

}
