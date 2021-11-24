package com.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entity.Person;
import com.repository.PersonRepository;
import com.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person AddPerson(Person person) {
		return personRepository.save(person);
	}

	public Object findById(long id) {

		Optional<Person> person = personRepository.findById(id);

		if (person.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("record does not exist");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(person);
		}
	}
}
