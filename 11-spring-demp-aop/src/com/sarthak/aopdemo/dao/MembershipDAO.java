package com.sarthak.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

//	public void addSillyMember()
	public boolean addSillyMember() {
		System.out.println(getClass() + ": DOING MY memebership WORK ADD ACCOUNT");
		return true;
	}

	public void goToSleep() {
		System.out.println(getClass() + ": I am going to sleep");
	}

}
