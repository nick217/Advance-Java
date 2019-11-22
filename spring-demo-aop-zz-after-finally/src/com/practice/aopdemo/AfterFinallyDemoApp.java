package com.practice.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practice.aopdemo.dao.AccountDAO;
import com.practice.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method to find accounts
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exception
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program: Caught Exception! " + e);
		}
		// display the accounts
		System.out.println("\n\nMain Program: AfterReturningDemoApp \n----");

		System.out.println(theAccounts + "\n");

		// close the context
		context.close();
	}

}
