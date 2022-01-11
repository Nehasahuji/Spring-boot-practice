package com.exception;

public class UserServiceException extends RuntimeException {

	private static final long serialVersionUID = 4129377005715823019L;

	public UserServiceException(String message) {
		super(message);
	}

}
