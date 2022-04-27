package com.mediscreen.riskLevelPatient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * IdInfoPatientNotFoundException
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdInfoPatientNotFoundException extends RuntimeException {

	public IdInfoPatientNotFoundException(String s) {
		super(s);
	}

}
