package com.mediscreen.medicalRecordPatient.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediscreen.medicalRecordPatient.exception.BadRequestBodyException;
import com.mediscreen.medicalRecordPatient.exception.IdMedicalRecordNotFoundException;
import com.mediscreen.medicalRecordPatient.model.MedicalRecordPatient;
import com.mediscreen.medicalRecordPatient.repository.MedicalRecordPatientRepository;

import lombok.Getter;
import lombok.Setter;

/**
 * Service MedicalRecordPatientService
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@Service
@Getter
@Setter
public class MedicalRecordPatientService {

	@Autowired
	private MedicalRecordPatientRepository medicalRecordPatientRepository;

	public Optional<MedicalRecordPatient> findById(UUID id) {
		if (! medicalRecordPatientRepository.findById(id).isPresent())
			throw new IdMedicalRecordNotFoundException("Medical Record Id :" + id + " is not found in database.");
		return medicalRecordPatientRepository.findById(id);
	}

	public List<MedicalRecordPatient> findByIdPatient(UUID id) {
		return medicalRecordPatientRepository.findByIdPatientOrderByDateDesc(id);
	}

	public List<MedicalRecordPatient> findAll() {
		return medicalRecordPatientRepository.findByOrderByDateDesc();
	}

	public MedicalRecordPatient save(MedicalRecordPatient medicalRecordPatient) {
		if (medicalRecordPatient.getId() == null 
				|| medicalRecordPatient.getIdPatient() == null 
				|| medicalRecordPatient.getDate() == null
				|| medicalRecordPatient.getNotes() == null)
			throw new BadRequestBodyException("Check @RequestBody MedicalRecordPatient");
		medicalRecordPatient.setDate(new Date());
		return medicalRecordPatientRepository.save(medicalRecordPatient);
	}

	public Optional<MedicalRecordPatient> deleteById(UUID id) {
		if (medicalRecordPatientRepository.findById(id).isEmpty())
			throw new IdMedicalRecordNotFoundException("Medical Record Id :" + id + " is not found in database.");
		Optional<MedicalRecordPatient> result = findById(id);
		medicalRecordPatientRepository.deleteById(id);
		return result;
	}

} 
