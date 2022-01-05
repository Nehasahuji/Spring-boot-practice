package com.modal.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsRequest {

	/* user sends request using this class */
	private String firstName;
	private String lastName;
	private String email;
	private String password;

}
