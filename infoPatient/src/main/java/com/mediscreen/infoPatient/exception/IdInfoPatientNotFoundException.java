package com.mediscreen.infoPatient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdInfoPatientNotFoundException extends RuntimeException {

	public IdInfoPatientNotFoundException(String s) {
		super(s);
	}

}
