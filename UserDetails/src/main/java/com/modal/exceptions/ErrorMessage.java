package com.modal.exceptions;

public enum ErrorMessage {
	MISSING_REQUIRED_FIELD("Missing required field please check the documentation for the required filed"),
	RECORD_ALREADY_EXIST("Record aLREADY EXIST"), INTERNAL_SERVER_ERROR("Internal server error"),
	NO_RECORD_FOUND("No record found"), AUTHENTICATION_FAILLED("Authentication failed"),
	COULD_NOT_UPDATE_RECORD("Could not update record"), COULD_NOT_DELETE_RECORD("could not delete record"),
	EMAIL_ADDRESS_NOT_VARIFIED("Email address not varified");

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	private ErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
