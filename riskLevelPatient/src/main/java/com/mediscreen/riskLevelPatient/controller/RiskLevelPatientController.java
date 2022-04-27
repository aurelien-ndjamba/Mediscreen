package com.mediscreen.riskLevelPatient.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediscreen.riskLevelPatient.service.RiskLevelPatientService;

/**
 * RestController RiskLevelPatientController
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@RestController
public class RiskLevelPatientController {

	@Autowired
	private RiskLevelPatientService riskLevelPatientService;

	/**
	 * Méthode pour obtenir le niveau de risque de diabète d'un patient
	 * 
	 * @param UUID
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/assess", method = RequestMethod.GET)
	public String findRiskLevelPatient(@RequestParam UUID id) {
		return riskLevelPatientService.findRiskLevelPatient(id);
	}

}
