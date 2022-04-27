package com.mediscreen.riskLevelPatient.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediscreen.riskLevelPatient.configuration.CustomProperties;
import com.mediscreen.riskLevelPatient.exception.IdInfoPatientNotFoundException;
import com.mediscreen.riskLevelPatient.model.InfoPatient;
import com.mediscreen.riskLevelPatient.model.MedicalRecordPatient;
import com.mediscreen.riskLevelPatient.proxy.RiskLevelPatientProxy;

import lombok.Getter;
import lombok.Setter;

/**
 * RiskLevelPatientService
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@Service
@Getter
@Setter
public class RiskLevelPatientService {

	@Autowired
	private RiskLevelPatientProxy riskLevelPatientProxy;
	@Autowired
	private CustomProperties props;

	public Optional<InfoPatient> findInfoPatientById(UUID id) {
		try {
			riskLevelPatientProxy.findInfoPatientById(id);
		} catch (Exception e) {
			throw new IdInfoPatientNotFoundException("Information Patient Id :" + id + " is not found in database.");
		}
//		if (! riskLevelPatientProxy.findInfoPatientById(id).isPresent())
//			throw new IdInfoPatientNotFoundException("Information Patient Id :" + id + " is not found in database.");
		return riskLevelPatientProxy.findInfoPatientById(id);
	}

	public List<MedicalRecordPatient> findMedicalRecordsPatientsByIdPatient(UUID id) {
		return riskLevelPatientProxy.findMedicalRecordsByIdPatient(id);
	}

	public List<String> readTriggersFile() {
		List<String> triggers = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(props.getPathTriggers());
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				triggers.add(scanner.nextLine().toLowerCase());
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();  
		}

		return triggers;
	}

	public int findAgePatient(UUID id) {
		int agePatient;

		Calendar now = Calendar.getInstance();
		Calendar dob = Calendar.getInstance();

		InfoPatient infoPatient = riskLevelPatientProxy.findInfoPatientById(id).get();
		dob.setTime(infoPatient.getDob());
		if (dob.after(now))
			throw new IllegalArgumentException("Can't be born in the future");

		int year1 = now.get(Calendar.YEAR);
		int year2 = dob.get(Calendar.YEAR);
		agePatient = year1 - year2;

		int month1 = now.get(Calendar.MONTH);
		int month2 = dob.get(Calendar.MONTH);
		if (month2 > month1) {
			agePatient--;
		} else if (month1 == month2) {
			int day1 = now.get(Calendar.DAY_OF_MONTH);
			int day2 = dob.get(Calendar.DAY_OF_MONTH);
			if (day2 > day1) {
				agePatient--;
			}
		}

		return agePatient; 
	}

	public int findTriggerCount(UUID id) {
		int triggerCount = 0;
		for (MedicalRecordPatient medicalRecordPatient : findMedicalRecordsPatientsByIdPatient(id)) {
			for (String trigger : readTriggersFile()) {
				if (medicalRecordPatient.getNotes().toLowerCase().contains(trigger))
					triggerCount++;
			}
		}

		return triggerCount;
	}

	public String findRiskLevelPatient(UUID id) {
		
		int agePatient = findAgePatient(id);
		int triggerCount = findTriggerCount(id);
		String sex = String.valueOf(findInfoPatientById(id).get().getSex());
		String result = null;

		if (triggerCount == 0)
			result = "None"; 
		else if (triggerCount == 2 && agePatient > 30)
			result = "Borderline";
		else if ((triggerCount == 3 && agePatient < 30 && sex.contains("M"))
				|| (triggerCount == 4 && agePatient < 30 && sex.contains("F")) || (triggerCount == 6 && agePatient > 30))
			result = "In Danger";
		else if ((triggerCount == 5 && agePatient < 30 && sex.contains("M"))
				|| (triggerCount == 7 && agePatient < 30 && sex.contains("F")) || (triggerCount >= 8 && agePatient > 30))
			result = "Early onset";

		return result;
	}

}
