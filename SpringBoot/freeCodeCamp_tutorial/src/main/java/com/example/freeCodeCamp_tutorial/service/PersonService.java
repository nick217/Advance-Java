package com.example.freeCodeCamp_tutorial.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.freeCodeCamp_tutorial.dao.PersonDAO;
import com.example.freeCodeCamp_tutorial.model.Person;

@Service
public class PersonService {
	private final PersonDAO personDAO;

	@Autowired
	public PersonService(@Qualifier("fakeDAO") PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public int addPerson(Person person) {
		return personDAO.insertPerson(person);
	}

	public List<Person> getAllPeople() {
		return personDAO.selectAllPeople();
	}

	public Optional<Person> getPersonById(UUID id) {
		return personDAO.selectPersonById(id);
	}

	public int updatePerson(UUID id, Person newPerson) {
		return personDAO.updatePersonById(id, newPerson);
	}

	public int deletePersonById(UUID id) {
		return personDAO.deletePersonById(id);
	}
}
