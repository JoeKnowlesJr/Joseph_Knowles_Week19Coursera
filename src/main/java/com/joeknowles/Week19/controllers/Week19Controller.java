package com.joeknowles.Week19.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Week19Controller {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
