package com.sarthak.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sarthak.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Around("execution(* com.sarthak.aopdemo.service.*.getFortune(..))")
	public Object aroundgetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		// print out which method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n======> Executing @Around on method: " + method);

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// now let's execute the method

		Object result = theProceedingJoinPoint.proceed();

		// get end timestamp
		long end = System.currentTimeMillis();

		// compute duration and display it
		long duration = end - begin;
		System.out.println("\n=========> Duration: " + duration / 1000.0 + "seconds");
		
		return result;

	}

	@After("execution(* com.sarthak.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyAccountAdvice(JoinPoint theJoinPoint) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======> Executing @After (finally) on method: " + method);

	}

	@AfterThrowing(pointcut = "execution(* com.sarthak.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExe")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExe) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======> Executing @AfterThrowing on method: " + method);

		// log the exception
		System.out.println("\n======> Exception is: " + theExe);

	}

	// add a new advice for @AfterReturning on the find accounts advice

	@AfterReturning(pointcut = "execution(* com.sarthak.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======> Executing @AfterReturning on method: " + method);

		// print out the results of the method call
		System.out.println("\n======> Result is: " + result);

		// lets post process the data .. lets modify it

		// convert the account names to uppercase

		convertAccountNamesToUpperCase(result);

		// print out the results of the method call
		System.out.println("\n======> Result is: " + result);

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		// loop through accounts

		for (Account tempAccount : result) {
			// get upper case name of the account
			String theUpperName = tempAccount.getName().toUpperCase();

			// update the name on the account
			tempAccount.setName(theUpperName);
		}
	}

//	@Before("execution(public void add*())")
	@Before("com.sarthak.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n======> Executing @Before advice on addAccount() <======");

		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

		System.out.println("Method: " + methodSig);

		// display method arguments

		// get the args
		Object[] args = theJoinPoint.getArgs();

		// loop through args
		for (Object tempArg : args) {
			System.out.println(tempArg);
			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}
		}

	}

}
