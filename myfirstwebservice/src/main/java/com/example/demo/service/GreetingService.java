package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	
	public String viewGreeting(double d) {		
		return "Answer: " + d;		
	}
}

