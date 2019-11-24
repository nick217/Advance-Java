package com.practice.aopdemo.aspect;

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

import com.practice.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Around("execution(* com.practice.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint pJP) throws Throwable {

		// print out method we are advising on
		String method = pJP.getSignature().toShortString();
		System.out.println("\n Executing @Around on method: " + method);

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// now, let's execute the method
		Object result = null;

		try {
			result = pJP.proceed();
		} catch (Exception e) {
			// log the exception
			System.out.println(e.getMessage());

			/*
			 * // give user a custom message (handling the exception) 
			 * result = "Major Accident! But no worries, your private AOP helicopter is on the way!";
			 */

			// Rethrow the exception
			throw e;
		}

		// get end timestamp
		long end = System.currentTimeMillis();

		// compute duration and display it
		long duration = end - begin;
		System.out.println("Duration: " + duration / 1000.0 + " seconds");

		return result;
	}

	@After("execution(* com.practice.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {

		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n Executing @After (finally) on method: " + method);

	}

	@AfterThrowing(pointcut = "execution(* com.practice.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable theExc) {
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n Executing @AfterReturning on method: " + method);

		// log the exception
		System.out.println("\n The exception is: " + theExc);
	}

	// add a new advice for @AfterReturning
	@AfterReturning(pointcut = "execution(* com.practice.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {

		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n Executing @AfterReturning on method: " + method);

		// print out the result of the method call
		System.out.println("\n Result is: " + result);

		// lets post process the data, we modify it before returning it to the
		// requesting service

		// convert the account names to upper case

		convertAccountNamesToUpperCase(result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
	}

	@Before("com.practice.aopdemo.aspect.AopExpressionsUtil.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

		System.out.println("Method: " + methodSig);

		// display method arguments

		// get args
		Object args[] = theJoinPoint.getArgs();

		// display args
		for (Object arg : args) {
			System.out.println(arg);

			if (arg instanceof Account) {
				Account account = (Account) arg;
				System.out.println("Account Name: " + account.getName());
			}
		}
	}
}
