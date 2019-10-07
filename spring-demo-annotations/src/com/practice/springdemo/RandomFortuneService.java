package com.practice.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Value("${foo.fortune}")
	private String fortunes;

	private String[] fortunesList;

	private Random rand;

	public RandomFortuneService() {

	}

	@PostConstruct
	void setupMyData(){
		fortunesList = fortunes.split(",");
		rand = new Random();
	}
	@Override
	public String getFortune() {
		int index = rand.nextInt(fortunesList.length);
		return fortunesList[index];
	}

}
