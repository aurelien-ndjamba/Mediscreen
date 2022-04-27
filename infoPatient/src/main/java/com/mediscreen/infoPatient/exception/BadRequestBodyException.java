package com.mediscreen.infoPatient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestBodyException extends RuntimeException {
	
	public BadRequestBodyException(String s) {
		super(s);
	}

}
