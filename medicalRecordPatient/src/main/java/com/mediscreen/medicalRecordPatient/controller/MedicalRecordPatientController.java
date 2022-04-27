package com.mediscreen.medicalRecordPatient.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mediscreen.medicalRecordPatient.model.MedicalRecordPatient;
import com.mediscreen.medicalRecordPatient.service.MedicalRecordPatientService;

/**
 * RestController MedicalRecordPatientController
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */ 
@RestController
public class MedicalRecordPatientController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private MedicalRecordPatientService medicalRecordPatientService;

	/**
	 * Méthode pour afficher le détail d'un historique médical
	 * 
	 * @param UUID
	 * @return Optional<MedicalRecordPatient>
	 * 
	 */
	@RequestMapping(value = "/patHistory/findById", method = RequestMethod.GET)
	public Optional<MedicalRecordPatient> findById(@RequestParam UUID id) {
		logger.info("INFO: Afficher le détail de l'historique médical ayant l'id :" + id);
		return medicalRecordPatientService.findById(id);
	}

	/**
	 * Méthode pour afficher les historiques médicaux d'un patient
	 * 
	 * @param UUID
	 * @return List<MedicalRecordPatient>
	 * 
	 */
	@RequestMapping(value = "/patHistory/findByIdPatient", method = RequestMethod.GET)
	public List<MedicalRecordPatient> findByIdPatient(@RequestParam UUID id) {
		logger.info("INFO: Afficher l'historique médical complet d'un patient ayant l'id :" + id);
		return medicalRecordPatientService.findByIdPatient(id);
	}

	/**
	 * Méthode pour afficher tous les historiques médicaux complet
	 * 
	 * @return List<MedicalRecordPatient>
	 * 
	 */
	@RequestMapping(value = "/patHistory/findAll", method = RequestMethod.GET)
	public List<MedicalRecordPatient> findAll() {
		logger.info("INFO: Afficher l'historique médical de tous les patients");
		return medicalRecordPatientService.findAll();
	}

	/**
	 * Méthode pour sauvegarder l' historique médical d'un patient
	 * 
	 * @param MedicalRecordPatient
	 * @return MedicalRecordPatient
	 * 
	 */
	@RequestMapping(value = "/patHistory/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public MedicalRecordPatient save(@RequestBody MedicalRecordPatient medicalRecord) {
		logger.info("INFO: Sauvegarder l'historique médical d'un patient");
		return medicalRecordPatientService.save(medicalRecord);
	}

	/**
	 * Méthode pour supprimer l' historique médical d'un patient
	 * 
	 * @param UUID
	 * @return Optional<MedicalRecordPatient>
	 * 
	 */
	@RequestMapping(value = "/patHistory/delete", method = RequestMethod.DELETE)
	public Optional<MedicalRecordPatient> deleteById(@RequestParam UUID id) {
		logger.info("INFO: Supprimer l'historique médical d'un patient");
		return medicalRecordPatientService.deleteById(id);
	}

}
