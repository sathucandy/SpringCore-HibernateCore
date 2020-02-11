package com.sarthak.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// pick a random fortune//
	private String[] data = { "Happy", "Sad", "Smile" };

	private Random myRandom = new Random();

	@Override
	public String getFortune() {

		int index = myRandom.nextInt(data.length);

		String theFortune = data[index];

		return theFortune;
	}

}
