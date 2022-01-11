package com.modal.responce.exceptions;

import java.util.Date;

public class CustomizeErrorMessage {
	private Date timeStamp;
	private String message;

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomizeErrorMessage() {

	}

	public CustomizeErrorMessage(Date timeStamp, String message) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
	}

}
