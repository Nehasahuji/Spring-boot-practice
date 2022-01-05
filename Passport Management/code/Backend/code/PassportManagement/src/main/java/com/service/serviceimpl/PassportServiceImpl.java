package com.service.serviceimpl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Passport;
import com.entity.Person;
import com.exception.UserNotFound;
import com.repository.PassportRepository;
import com.repository.PersonRepository;
import com.service.PassportService;
import com.service.exception.NoteElegibleToCreatePassport;

@Service
public class PassportServiceImpl implements PassportService {

	@Autowired
	private PassportRepository passportRepository;

	@Autowired
	PersonRepository personRepository;

	@Override
	public Passport addPassport(long id) throws NoteElegibleToCreatePassport {

		Person person = this.findById(id);

		if (person.getAge() < 18) {
			throw new NoteElegibleToCreatePassport("User is not eligeble to create passport");
		} else {
			Passport passport = new Passport();
			passport.setPassportNumber(getRandomNumberString());
			passport.setPerson(person);

			return passportRepository.save(passport);
		}
	}

	@Override
	public Passport getPersonAndPassportDetails(long id) {

		this.findById(id);
		return passportRepository.findByPerson_id(id);
	}

	public static String getRandomNumberString() {
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		// this will convert any number sequence into 6 character.
		return String.format("%06d", number);
	}

	public Person findById(long id) {

		Optional<Person> person = personRepository.findById(id);

		if (person.isEmpty()) {
			throw new UserNotFound("No such personID there in the system");
		} else {
			return person.get();
		}
	}

}
