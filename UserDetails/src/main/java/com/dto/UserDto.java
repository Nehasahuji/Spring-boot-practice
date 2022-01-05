package com.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto implements Serializable {

	/*
	 * connecting class between user request and user response connected with the
	 * entity class which is used to enter data into database
	 */
	private static final long serialVersionUID = 3051668650019136134L;
	private long id;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String encryptedPassword;
	private String emailVerficationToken;
	private Boolean emailVerficationStatus = false;

}
