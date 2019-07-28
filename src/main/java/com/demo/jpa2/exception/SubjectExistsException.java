package com.demo.jpa2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason="Subject already exists!")
public class SubjectExistsException extends RuntimeException {

	private static final long serialVersionUID = 6455056271933367131L;

	public SubjectExistsException(){
		super();
	}
}