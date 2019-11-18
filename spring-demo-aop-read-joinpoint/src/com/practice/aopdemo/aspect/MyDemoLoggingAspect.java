package com.practice.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
