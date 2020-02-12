package com.sarthak.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all our related advises for logging

	// lets start with an @Before advice

	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======> Executin @Before advice on addAccount() <======");
	}

}
