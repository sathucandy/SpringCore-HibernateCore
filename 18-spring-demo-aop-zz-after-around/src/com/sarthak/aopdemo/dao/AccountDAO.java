package com.sarthak.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sarthak.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	// add a new method find account
	public List<Account> findAccounts(boolean tripWire) {
		// for academic purposes
		if(tripWire) {
			throw new RuntimeException("No soup for you");
		}
		
		List<Account> myAccount = new ArrayList<>();

		// create some sample accounts
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");
		// add them to our account list
		myAccount.add(temp1);
		myAccount.add(temp2);
		myAccount.add(temp3);

		return myAccount;
	}

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
