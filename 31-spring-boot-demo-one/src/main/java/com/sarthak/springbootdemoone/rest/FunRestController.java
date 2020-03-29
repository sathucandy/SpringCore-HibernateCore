package com.sarthak.springbootdemoone.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	//expose the "/" endpoint to display hello world
	
	@GetMapping("/")
	public String hello() {
		return "Hello world" + LocalDateTime.now();
	}
	
}
