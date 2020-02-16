package com.demo.jpa2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Student does not exists!")
public class StudentDoesNotExistException extends RuntimeException {

	private static final long serialVersionUID = 687957859330403391L;

	public StudentDoesNotExistException() {
		super();
	}
}
