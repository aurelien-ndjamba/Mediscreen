package com.mediscreen.riskLevelPatient.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

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
public class MedicalRecordPatient {

    private UUID id;  
	private Date date; 
	private UUID idPatient;
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
