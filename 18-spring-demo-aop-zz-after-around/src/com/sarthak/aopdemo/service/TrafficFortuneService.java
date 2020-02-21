package com.sarthak.aopdemo.service;

import java.util.concurrent.TimeUnit;

public class TrafficFortuneService {

	public String getFortune() {

		// simulate a delay

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return a fortune
		return "Expect heavy traffic this morning";

	}

}
