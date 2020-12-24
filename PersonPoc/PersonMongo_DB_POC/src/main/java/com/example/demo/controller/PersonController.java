package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.PersonIdNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping("/listAllPersons")
	public List<Person> getAllPersons() {
		return service.getAllPersons();
	}

	@PostMapping("/post")
	public Person postPersons(@RequestBody Person person) {
		return service.postPersons(person);
	}

	@DeleteMapping("/delete/{id}")
	public void deletePersons(@PathVariable Integer id) throws PersonIdNotFoundException {
		service.deletePersonById(id);
	}

	@PutMapping("/update/{id}")
	public Person updatePerson(@RequestBody Person person, @PathVariable Integer id) {
		return service.updatePerson(person, id);
	}
}
