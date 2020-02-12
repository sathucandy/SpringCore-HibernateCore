package com.sarthak.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sarthak.aopdemo.dao.AccountDAO;
import com.sarthak.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring java config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from dao
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the buisness method
		theAccountDAO.addAccount();
		
		// call the membership buisness method
		theMembershipDAO.addAccount();

		System.out.println("\nLets print it again\n");

		// call the buisness method again
		theAccountDAO.addAccount();

		// close the context
		context.close();

	}

}
