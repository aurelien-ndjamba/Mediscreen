package com.mediscreen.riskLevelPatient.model;

import java.util.Date;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * InfoPatient 
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@Data
@NoArgsConstructor
public class InfoPatient {
	
	private UUID id;
	private String family;
	private String given; 
	private Date dob; 
	private char sex;
	private String address;
	private String phone;
	
	public InfoPatient(String family, String given, Date dob, char sex, String address, String phone) {
		super();
		this.family = family;
		this.given = given;
		this.dob = dob;
		this.sex = sex;
		this.address = address;  
		this.phone = phone;
	}
	
}
 