package com.example.freeCodeCamp_tutorial.model;

import java.util.UUID;

import lombok.Getter;

public class Person {
	@Getter
	private final UUID id;
	@Getter
	private final String name;

	public Person(UUID id, String name) {
		this.id = id;
		this.name = name;
	}
}
