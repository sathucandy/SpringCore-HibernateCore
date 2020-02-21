package com.sarthak.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sarthak.aopdemo.dao.AccountDAO;
import com.sarthak.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring java config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain program demo app");

		System.out.println("Calling getFortune");

		String data = fortuneService.getFortune();
		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");

		// close the context
		context.close();

	}

}
