package com.sarthak.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuvAopExpressions {
	@Pointcut("execution(* com.sarthak.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	// create pointcut for getter method
	@Pointcut("execution(* com.sarthak.aopdemo.dao.*.get*(..))")
	public void getter() {

	}

	// create pointcut for setter method
	@Pointcut("execution(* com.sarthak.aopdemo.dao.*.set*(..))")
	public void setter() {

	}

	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {

	}
}
