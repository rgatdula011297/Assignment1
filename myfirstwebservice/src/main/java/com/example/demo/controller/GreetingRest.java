package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.GreetingService;

@RestController
@RequestMapping("/api")
public class GreetingRest {
	@Autowired
	GreetingService service;
	
	@Value("${custom.config.key}")
	float key;
	
	
	@GetMapping("/calc")
	public String calcByPassingParam(@RequestParam int a, @RequestParam int b, @RequestParam int c, @RequestParam int d) {
		return service.viewGreeting((a + b + c +d) * key);
	}

}
