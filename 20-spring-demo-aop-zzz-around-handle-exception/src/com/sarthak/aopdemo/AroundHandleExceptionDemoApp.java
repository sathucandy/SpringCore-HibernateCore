package com.sarthak.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sarthak.aopdemo.dao.AccountDAO;
import com.sarthak.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {

		// read spring java config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

//		System.out.println("\nMain program demo app");
		myLogger.info("\nMain program demo app");

//		System.out.println("Calling getFortune");
		myLogger.info("Calling getFortune");
		
		boolean tripWire = true;
		String data = fortuneService.getFortune(tripWire);
//		System.out.println("\nMy fortune is: " + data);
		myLogger.info("\nMy fortune is: " + data);

//		System.out.println("Finished");
		myLogger.info("Finished\"");

		// close the context
		context.close();

	}

}
