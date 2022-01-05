package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "user")
@Getter
@Setter
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -8917241480540199531L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false, length = 50)
	private String firstName;

	@Column(nullable = false, length = 50)
	private String lastName;

	@Column(nullable = true, length = 120)
	private String email;

	@Column(nullable = false)
	private String encryptedPassword;

	private String emailVerficationToken;

	@Column(nullable = false)
	private Boolean emailVerficationStatus = false;
}
