package com.sarthak.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + ": DOING MY memebership WORK ADD ACCOUNT");
	}

}
