package com.sarthak.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.sarthak.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK ADD ACCOUNT");
	}

	public boolean doWork() {
		System.out.println(getClass() + ": Doing work");
		return false;
	}
}
