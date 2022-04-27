package com.mediscreen.medicalRecordPatient.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity MedicalRecordPatient
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@Document(collection = "histories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecordPatient {

	@Id
	@Column(name = "id", nullable = false)
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private Date date;

	private UUID idPatient;

	private String notes;

	public MedicalRecordPatient(UUID idPatient, String notes) {
		super();
		this.id = UUID.randomUUID();
		this.date = new Date();
		this.idPatient = idPatient;
		this.notes = notes;
	}

}
