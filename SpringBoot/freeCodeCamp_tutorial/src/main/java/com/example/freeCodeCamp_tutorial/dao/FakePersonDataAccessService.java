package com.example.freeCodeCamp_tutorial.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.freeCodeCamp_tutorial.model.Person;

@Repository("fakeDAO")
public class FakePersonDataAccessService implements PersonDAO {

	private static List<Person> db = new ArrayList<>();

	public int insertPerson(UUID id, Person person) {
		db.add(new Person(id, person.getName()));
		return 1;
	}

	public List<Person> selectAllPeople() {
		return db;
	}

	public Optional<Person> selectPersonById(UUID id) {
		return db.stream().filter(person -> person.getId().equals(id)).findFirst();
	}

	public int updatePersonById(UUID id, Person personToUpdate) {

		return selectPersonById(id).map(person -> {
			int indexOfPersonToDelete = db.indexOf(person);
			if (indexOfPersonToDelete >= 0) {
				db.set(indexOfPersonToDelete, new Person(id, personToUpdate.getName()));
				return 1;
			}
			return 0;
		}).orElse(0);
	}

	public int deletePersonById(UUID id) {
		Optional<Person> person = selectPersonById(id);
		if (person.isEmpty()) {
			return 0;
		}
		db.remove(person.get());
		return 1;
	}
}
