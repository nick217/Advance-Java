package com.practice.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practice.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);

		// call the business method
		accountDao.addAccount();

		// close the context
		context.close();
	}

}
