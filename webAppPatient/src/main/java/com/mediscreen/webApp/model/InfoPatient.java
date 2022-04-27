package com.mediscreen.webApp.model;

import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

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

	@NotNull
	@Length(min = 1, max = 30, message = "Le nom de famille doit être comprise entre 1 et 30")
	private String family;

	@NotNull
	@Length(min = 1, max = 30, message = "Le prénom doit être comprise entre 1 et 30")
	private String given;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
//	@Pattern(regexp = "^(19|20)\\d\\d[\\-\\/.](0[1-9]|1[012])[\\-\\/.](0[1-9]|[12][0-9]|3[01])$") // YYYY-MM-DD
	@Past(message = "La date de naissance doit être antérieure à celle d'aujourd'hui")
	private Date dob;

	@NotNull
	private char sex;

	@Length(max = 30, message = "L'adresse doit être inférieure à 60 caractères")
	private String address;

	@Length(max = 30, message = "Le contact doit être inférieure à 30 caractères")
	private String phone;

	private String riskLevel;

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
