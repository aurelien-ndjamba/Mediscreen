package com.mediscreen.webApp.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MedicalRecordPatient
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecordPatient {
	
    private UUID id;
	private Date date; 
	@NotNull
//	@Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$") // UUID
	private UUID idPatient;
	@NotNull
	private String notes;
	private String riskLevel;
	 
	public MedicalRecordPatient(UUID idPatient, String notes) {
		super();
		this.id = UUID.randomUUID(); 
		this.date = Calendar.getInstance().getTime();
		this.idPatient = idPatient;
		this.notes = notes;
	} 

} 
