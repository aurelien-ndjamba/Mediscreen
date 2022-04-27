package com.mediscreen.medicalRecordPatient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * IdMedicalRecordNotFoundException
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdMedicalRecordNotFoundException extends RuntimeException {

	public IdMedicalRecordNotFoundException(String s) {
		super(s);
	}

}
