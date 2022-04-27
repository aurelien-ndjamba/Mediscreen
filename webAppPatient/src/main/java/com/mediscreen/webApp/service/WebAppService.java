package com.mediscreen.webApp.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediscreen.webApp.model.MedicalRecordPatient;
import com.mediscreen.webApp.proxy.WebAppProxy;
import com.mediscreen.webApp.model.InfoPatient;

import lombok.Getter;
import lombok.Setter;

/**
 * Service WebAppController
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@Service
@Getter
@Setter
public class WebAppService {
	
	@Autowired
	WebAppProxy webAppProxy;
	
	public Optional<InfoPatient> findInfoPatientById(UUID id) {
		return webAppProxy.findInfoPatientById(id);
	}

	public List<InfoPatient> findAllInfoPatients() {
		return webAppProxy.findAllInfoPatients();
	}

	public InfoPatient saveInfoPatient(InfoPatient patient) {
		return webAppProxy.saveInfoPatient(patient);
	}

	public InfoPatient updateInfoPatient(InfoPatient patient) {
		return webAppProxy.updateInfoPatient(patient);
	}

	public Optional<InfoPatient> deleteInfoPatientById(UUID id) {
		return webAppProxy.deleteInfoPatientById(id);
	}

	public Optional<MedicalRecordPatient> findMedicalRecordPatientById(UUID id) {
		return webAppProxy.findMedicalRecordPatientById(id);
	}
	
	public List<MedicalRecordPatient> findMedicalRecordsByIdPatient(UUID id) {
		return webAppProxy.findMedicalRecordsByIdPatient(id);
	}   

	public List<MedicalRecordPatient> findAllMedicalRecordsPatients() {
		return webAppProxy.findAllMedicalRecordsPatients();
	}

	public MedicalRecordPatient saveMedicalRecordPatient(MedicalRecordPatient medicalRecordPatient) {
		return webAppProxy.saveMedicalRecordPatient(medicalRecordPatient);
	}

	public MedicalRecordPatient updateMedicalRecordPatient(MedicalRecordPatient medicalRecordPatient) {
		MedicalRecordPatient historyPatientRecorded = findMedicalRecordPatientById(medicalRecordPatient.getId()).get();
		medicalRecordPatient.setDate(Calendar.getInstance().getTime()); 
		medicalRecordPatient.setIdPatient(historyPatientRecorded.getIdPatient());
		return webAppProxy.saveMedicalRecordPatient(medicalRecordPatient);
	}
	
	public Optional<MedicalRecordPatient> deleteMedicalRecordPatientById(UUID id) {
		return webAppProxy.deleteMedicalRecordPatientById(id);
	}

	public String findRiskLevelPatient(UUID id) {
		return webAppProxy.findRiskLevelPatient(id);
	}

}
