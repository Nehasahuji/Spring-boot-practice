package com.service;

import com.entity.Passport;
import com.service.exception.NoteElegibleToCreatePassport;

public interface PassportService {

	Passport addPassport(long id) throws NoteElegibleToCreatePassport;

	Passport getPersonAndPassportDetails(long id);

}
