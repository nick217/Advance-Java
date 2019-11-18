package com.practice.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressionsUtil {
	// Below are pointcut declarations.

	@Pointcut("execution(* com.practice.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// create pointcut for getter methods
	@Pointcut("execution(* com.practice.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	// create pointcut for setter methods
	@Pointcut("execution(* com.practice.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	// create pointcut: include package but exclude getters/setters
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
	}
}
