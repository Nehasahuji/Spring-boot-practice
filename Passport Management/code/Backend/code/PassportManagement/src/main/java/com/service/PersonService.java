package com.service;

import com.entity.Person;

public interface PersonService {

	Person AddPerson(Person person);

	public Object findById(long id);
}
