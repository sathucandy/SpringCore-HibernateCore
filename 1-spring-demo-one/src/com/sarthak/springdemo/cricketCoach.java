package com.sarthak.springdemo;

public class cricketCoach implements Coach {

	private FortuneService fortuneService;
	private String email;
	private String team;

	public cricketCoach() {
		super();
		System.out.println("This is empty Constructor");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("This is inside setter EMAIL method");
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("This is inside setter TEAM method");
		this.team = team;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("This is inside setter method");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do fast bowling";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
