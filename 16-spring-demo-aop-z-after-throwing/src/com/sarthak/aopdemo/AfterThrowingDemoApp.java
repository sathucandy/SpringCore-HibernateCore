package com.sarthak.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sarthak.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read spring java config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method to find the account
		List<Account> theAccounts = null;
		try {
			theAccounts = theAccountDAO.findAccounts();
		} catch (Exception exe) {
			System.out.println("Main program caught exception");
		}

		// display the accounts
		System.out.println("\n\nMain Program: After Throwung Demo App");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");

		// close the context
		context.close();

	}

}
