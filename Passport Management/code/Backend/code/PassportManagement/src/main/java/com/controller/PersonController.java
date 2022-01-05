package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Person;
import com.service.PersonService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping("addperson")
	private Person addPerson(@RequestBody Person person) {
		return personService.AddPerson(person);
	}

}
