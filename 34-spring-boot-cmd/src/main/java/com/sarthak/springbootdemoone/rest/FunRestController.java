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
	
	// expose a new end point for workout
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "run hard 5k";
	}
	
	// expose a new end point for fortune
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "your lucky day";
	}
	
}
