package com.mediscreen.infoPatient.controller;

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

import com.mediscreen.infoPatient.exception.IdInfoPatientNotFoundException;
import com.mediscreen.infoPatient.model.InfoPatient;
import com.mediscreen.infoPatient.service.InfoPatientService;

/**
 * RestController InfoPatientController
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@RestController
public class InfoPatientController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired 
	private InfoPatientService infoPatientService;

	/**
	 * Méthode pour afficher les informations d'un patient
	 * 
	 * @param UUID
	 * @return Optional<InfoPatient>
	 * @throws IdInfoPatientNotFoundException
	 * 
	 */
	@RequestMapping(value = "/patient/findById", method = RequestMethod.GET)
	public Optional<InfoPatient> findById(@RequestParam UUID id) {
		logger.info("INFO: Afficher les informations d'un patient");
		return infoPatientService.findById(id);
	} 
  
	/**
	 * Méthode pour afficher les informations de tous les patients
	 * 
	 * @return List<InfoPatient>
	 * 
	 */
	@RequestMapping(value = "/patient/findAll", method = RequestMethod.GET)
	public List<InfoPatient> findAll() {
		logger.info("INFO: Afficher les informations de tous les patients");
		return infoPatientService.findAll();
	}

	/**
	 * Méthode pour sauvegarder les informations d'un patient
	 * 
	 * @param InfoPatient
	 * @return InfoPatient
	 * 
	 */
	@RequestMapping(value = "/patient/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public InfoPatient save(@RequestBody InfoPatient infoPatient) {
		logger.info("INFO: Sauvegarder les informations d'un patient");
		return infoPatientService.save(infoPatient);
	}

	/**
	 * Méthode pour supprimer les informations d'un patient
	 * 
	 * @param UUID
	 * @return Optional<InfoPatient>
	 * 
	 */
	@RequestMapping(value = "/patient/delete", method = RequestMethod.DELETE)
	public Optional<InfoPatient> deleteById(@RequestParam UUID id) {
		logger.info("INFO: Supprimer les informations d'un patient");
		return infoPatientService.deleteById(id);
	}

}
