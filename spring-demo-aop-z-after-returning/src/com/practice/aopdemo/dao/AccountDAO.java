package com.practice.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.practice.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	// add a new method: findAccounts()
	public List<Account> findAccounts() {
		List<Account> myAccounts = new ArrayList<>();

		// add sample accounts

		myAccounts.add(new Account("Jack", "Gold"));
		myAccounts.add(new Account("Gloria", "Silver"));
		myAccounts.add(new Account("Jay", "Platinum"));
		
		return myAccounts;
	}

	public void addAccount(Account theAccount, boolean vipFlag) {

		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

	}

	public boolean doWork() {

		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}

}
