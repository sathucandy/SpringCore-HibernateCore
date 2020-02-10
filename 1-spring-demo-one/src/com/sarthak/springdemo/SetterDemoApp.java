package com.sarthak.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		cricketCoach theCoach = context.getBean("myCricketCoach", cricketCoach.class);

		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkout());

		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());

		context.close();

	}

}
