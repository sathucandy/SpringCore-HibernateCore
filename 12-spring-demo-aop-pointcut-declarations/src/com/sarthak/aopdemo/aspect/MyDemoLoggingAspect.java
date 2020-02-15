package com.sarthak.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	@Pointcut("execution(* com.sarthak.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// create pointcut for getter method
	@Pointcut("execution(* com.sarthak.aopdemo.dao.*.get*(..))")
	private void getter() {

	}

	// create pointcut for setter method
	@Pointcut("execution(* com.sarthak.aopdemo.dao.*.set*(..))")
	private void setter() {

	}

	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {

	}

//	@Before("execution(public void add*())")
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======> Executing @Before advice on addAccount() <======");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performAPIAnalytics() {
		System.out.println("\n======> Perform API analytics <======");
	}

}
