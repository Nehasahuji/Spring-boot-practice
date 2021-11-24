package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Passport;
import com.service.PassportService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("passport")
public class PassportController {

	@Autowired
	private PassportService passportService;

	@PostMapping("addpassport/{id}")
	public Passport addPassport(@PathVariable("id") long id) {

		return passportService.addPassport(id);
	}

	@GetMapping("getpersonandpassportdetails/{id}")
	public Passport getPersonAndPassportDetails(@PathVariable("id") long id) {
		return passportService.getPersonAndPassportDetails(id);
	}

}
