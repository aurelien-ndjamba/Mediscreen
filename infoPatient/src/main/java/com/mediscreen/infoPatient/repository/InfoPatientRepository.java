package com.mediscreen.infoPatient.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mediscreen.infoPatient.model.InfoPatient;

/**
 * Repository InfoPatientRepository
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@Repository
public interface InfoPatientRepository extends JpaRepository<InfoPatient, UUID>{
	
}
