package com.demo.jpa2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Student already exists!")
public class StudentExistsException extends RuntimeException {

	private static final long serialVersionUID = -7329461539806807498L;

	public StudentExistsException() {
		super();
	}
}