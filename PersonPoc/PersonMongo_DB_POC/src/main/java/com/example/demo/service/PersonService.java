package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.exception.PersonIdNotFoundException;
import com.example.demo.model.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao dao;

	public List<Person> getAllPersons() {

		return dao.findAll();
	}

	public Person postPersons(Person per) {
		return dao.save(per);
	}

	public void deletePersonById(Integer id) throws PersonIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Person> p = dao.findById(id);
		if (p.isPresent()) {
			dao.deleteById(id);
		} else {
			throw new PersonIdNotFoundException("Person Id " + id + " Not Found");
		}

	}

	public Person updatePerson(Person person, Integer id) {
		Optional<Person> p1 = dao.findById(id);
		Person pers = null;
		if (p1.isPresent()) {
			Person person1 = p1.get();
			person1.setpId(id);
			person1.setFirstName(person.getFirstName());
			person1.setLastName(person.getLastName());
			pers = dao.save(person1);
		} else {
			pers = new Person();
			pers.setFirstName(person.getFirstName());
			pers.setLastName(person.getLastName());
			pers.setpId(id);
			dao.save(pers);
		}
		return pers;

	}

}
