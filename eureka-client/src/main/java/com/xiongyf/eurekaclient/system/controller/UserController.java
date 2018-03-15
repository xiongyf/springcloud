package com.xiongyf.eurekaclient.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Value("${server.port}")
	private String port;

	@GetMapping("/port")
	public String port() {
		return port;
	}

	@GetMapping("/currentUser")
	public Map<String, Object> currentUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("client sessionId: " + session.getId());
		String username = (String) session.getAttribute("username");
		Map<String, Object> map = new HashMap<>();
		if (username != null) {
			map.put("state", "1");
			map.put("port", port);
			map.put("username", username);
			return map;
		}
		map.put("state", "0");
		map.put("port", port);
		map.put("msg", "haven't login");
		return map;
	}

	@PostMapping("/login")
	public Map<String, Object> login(HttpServletRequest request, String username, String password) {
		HttpSession session = request.getSession();
		System.out.println("client sessionId: " + session.getId());
		session.setAttribute("username", username);
		System.out.println("Logined, username: " + username);
		Map<String, Object> map = new HashMap<>();
		map.put("state", "1");
		map.put("msg", "Login success");
		map.put("port", port);
		map.put("username", username);
		return map;
	}

	@GetMapping("/logout")
	public Map<String, Object> logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		Map<String, Object> map = new HashMap<>();
		map.put("state", "1");
		map.put("msg", "Logout success");
		map.put("port", port);
		return map;
	}

}
