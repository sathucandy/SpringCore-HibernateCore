package com.sarthak.springbootdemoone.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	// inject properties for coach.name and team.name
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	// end a new endpoint for teaminfo
	@GetMapping("/teaminfo")
	public String teamInfo() {
		return "Coach: " + coachName + ". Team name: " + teamName;
	}
	
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
