package com.sarthak.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all our related advises for logging

	// lets start with an @Before advice

	@Pointcut("execution(* com.sarthak.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {

	}

//	@Before("execution(public void add*())")
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======> Executin @Before advice on addAccount() <======");
	}

}
