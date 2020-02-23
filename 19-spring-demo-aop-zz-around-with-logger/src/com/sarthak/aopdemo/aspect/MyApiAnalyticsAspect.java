package com.sarthak.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	@Before("com.sarthak.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void performAPIAnalytics() {
		System.out.println("\n======> Perform API analytics <======");
	}
}
