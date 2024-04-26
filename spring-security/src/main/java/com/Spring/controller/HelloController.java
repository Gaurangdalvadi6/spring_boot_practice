package com.Spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String great(HttpServletRequest rq) {
		return "Hello "+rq.getSession().getId();
	}
	
	@GetMapping("/about")
	public String about(HttpServletRequest rq) {
		return "Gaurang "+rq.getSession().getId();
	}
}
