package com.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.modal.responce.exceptions.CustomizeErrorMessage;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = UserServiceException.class)
	public ResponseEntity<Object> handleServiceException(UserServiceException ex, WebRequest request) {

		CustomizeErrorMessage customizeErrorMessage = new CustomizeErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<>(customizeErrorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleOtherException(Exception ex, WebRequest request) {

		CustomizeErrorMessage customizeErrorMessage = new CustomizeErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<>(customizeErrorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
