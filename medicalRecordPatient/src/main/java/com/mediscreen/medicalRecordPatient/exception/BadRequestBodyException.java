package com.mediscreen.medicalRecordPatient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * BadRequestBodyException
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BadRequestBodyException extends RuntimeException {
	
	public BadRequestBodyException(String s) {
		super(s);
	}

}
