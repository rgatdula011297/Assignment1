package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("/sample")
@RestController

public class Sample {
	//http://localhost:8080/sample/viewstatus
	@GetMapping("/viewStatus")
	public String viewStatus() {
		return "OK!";
	
	}

}
