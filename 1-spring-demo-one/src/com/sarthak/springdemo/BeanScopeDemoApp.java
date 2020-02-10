package com.sarthak.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		/// CHECK IF THEY ARE THHE SAME BEAN

		boolean result = (theCoach == alphaCoach);

		/// PRINT RESULT
		System.out.println("Pointing to same object = " + result);

		System.out.println("Memory loacation for theCoach = " + theCoach);

		System.out.println("Memory loacation for alphaCoach = " + alphaCoach);

		context.close();

	}

}
