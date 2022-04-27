package com.mediscreen.medicalRecordPatient.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mediscreen.medicalRecordPatient.model.MedicalRecordPatient;

/**
 * Repository MedicalRecordPatientRepository
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@Repository
public interface MedicalRecordPatientRepository extends MongoRepository<MedicalRecordPatient, UUID>{

	List<MedicalRecordPatient> findByIdPatientOrderByDateDesc(UUID id);
	List<MedicalRecordPatient> findByOrderByDateDesc();

}
