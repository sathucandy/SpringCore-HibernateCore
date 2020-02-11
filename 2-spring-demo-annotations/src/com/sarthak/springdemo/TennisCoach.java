package com.sarthak.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("theSillyCoach")
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired // FIELD INJECTION

	@Qualifier("randomFortuneService") /// THIS IS TO CHOOSE A CLASS WHICH WE WANT TO CALL IF WE HAVE MULTIPLE CLASSES
										/// IMPLEMENTING THE SAME INTERFACES
	private FortuneService fortuneService;

//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

//	/SETTER INJECTION//////

	/// default constructor///

	public TennisCoach() {
		System.out.println(">>>This is default constructor<<<");
	}

	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * System.out.println(">>>This is setter method<<<"); this.fortuneService =
	 * fortuneService; }
	 */

	///////////////////// METHOD AUTOWIRED/////////////////////

	/*
	 * @Autowired public void doSomeStuff(FortuneService fortuneService) {
	 * System.out.println(">>>This is crazy method method<<<"); this.fortuneService
	 * = fortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		return "Practice backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune(); //////// HERE FILED INJECTION IS ALSO TAKING PLACE
	}

}
