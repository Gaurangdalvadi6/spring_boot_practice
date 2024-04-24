package com.practice.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping({"/about","/"})
	public String about(Model model) {
		System.out.println("Inside about handler");
		model.addAttribute("name","Dalvadi");
		model.addAttribute("currentDate",new Date().toLocaleString());
		return "about";
	}
	
	@GetMapping("/example-loop")
	public String iterateHandler(Model m) {
		
		List<String> list = List.of("Java","Python","c","c++","php");
		m.addAttribute("names", list);
		return "iterator";
	}
}
