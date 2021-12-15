package com.kh.spring21.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataController {
	
	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "home";
	}
}
