package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/")
	public String firstHandler() {
		System.out.println("This is Home Page");
		return "Home";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		System.out.println("This is Contact page");
		return "Contact";
	}
}
