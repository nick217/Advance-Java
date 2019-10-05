package com.practice.springdemo;

import java.util.ArrayList;
import java.util.Random;

public class RandomFortuneService implements FortuneService {

	ArrayList<String> fortunes;
	Random rand;

	public RandomFortuneService() {
		fortunes = new ArrayList<>();
		fortunes.add("Today is your lucky day!");
		fortunes.add("Today will be a normal day.");
		fortunes.add("Be careful, today might get you!");

		rand = new Random();
	}

	@Override
	public String getFortune() {
		return fortunes.get(rand.nextInt(fortunes.size()));
	}

}
