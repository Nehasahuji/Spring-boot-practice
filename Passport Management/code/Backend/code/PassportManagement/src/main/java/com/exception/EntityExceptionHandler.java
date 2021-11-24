package com.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.entity.ErrorMessage;
import com.service.exception.NoteElegibleToCreatePassport;

@ControllerAdvice
public class EntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

		String errorMessageDescription = ex.getLocalizedMessage();
		if (errorMessageDescription == null)
			errorMessageDescription = ex.toString();

		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {

		String errorMessageDescription = ex.getLocalizedMessage();
		if (errorMessageDescription == null)
			errorMessageDescription = ex.toString();

		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { NoteElegibleToCreatePassport.class, })
	public ResponseEntity<Object> NoteElegibleToCreatePassportException(NoteElegibleToCreatePassport ex,
			WebRequest request) {

		String errorMessageDescription = ex.getLocalizedMessage();
		if (errorMessageDescription == null)
			errorMessageDescription = ex.toString();

		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { UserNotFound.class })
	public ResponseEntity<Object> UserNotFoundException(UserNotFound ex, WebRequest request) {

		String errorMessageDescription = ex.getLocalizedMessage();
		if (errorMessageDescription == null)
			errorMessageDescription = ex.toString();

		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
