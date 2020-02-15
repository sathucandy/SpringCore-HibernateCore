package com.sarthak.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.sarthak.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public String getName() {
		System.out.println(getClass() + ": in get name");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in set name");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": int setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK ADD ACCOUNT");
	}

	public boolean doWork() {
		System.out.println(getClass() + ": Doing work");
		return false;
	}
}
