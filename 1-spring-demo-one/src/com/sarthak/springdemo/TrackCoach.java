package com.sarthak.springdemo;

public class TrackCoach implements Coach {

	FortuneService fortuneService;

	public TrackCoach() {

	}

	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it" + fortuneService.getFortune();
	}

	/////// ADD INIT METHOD///////

	public void doMyStartupStuff() {
		System.out.println("Track coach in: init method");
	}

	/////////// ADD DESTROY METHOD////////

	public void doMyCleanupStuff() {
		System.out.println("Track coach in: init method");
	}

}
