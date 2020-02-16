package com.demo.jpa2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Subject does not exist!")
public class SubjectDoesNotExistException extends RuntimeException {

	private static final long serialVersionUID = 8964799722637473126L;

	public SubjectDoesNotExistException() {
		super();
	}
}
