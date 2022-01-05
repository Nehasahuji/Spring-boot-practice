package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String passportNumber;

	@OneToOne(cascade = CascadeType.ALL)
	private Person person;

}
