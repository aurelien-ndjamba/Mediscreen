package com.mediscreen.infoPatient.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediscreen.infoPatient.exception.BadRequestBodyException;
import com.mediscreen.infoPatient.exception.IdInfoPatientNotFoundException;
import com.mediscreen.infoPatient.model.InfoPatient;
import com.mediscreen.infoPatient.repository.InfoPatientRepository;

import lombok.Getter;
import lombok.Setter;

/**
 * Service InfoPatientService
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@Service
@Getter
@Setter
public class InfoPatientService {

	@Autowired
	private InfoPatientRepository infoPatientRepository;

	public Optional<InfoPatient> findById(UUID id) {
		if (! infoPatientRepository.findById(id).isPresent())  
			throw new IdInfoPatientNotFoundException("Information Patient Id :" + id + " is not found in database.");
		return infoPatientRepository.findById(id);
	}

	public List<InfoPatient> findAll() {
		return infoPatientRepository.findAll();
	}

	public InfoPatient save(InfoPatient infoPatient) {
		if ((infoPatient.getFamily() == null || infoPatient.getFamily().length() > 30 || infoPatient.getFamily().length() < 1 )
				|| (infoPatient.getGiven() == null || infoPatient.getGiven().length() > 30 || infoPatient.getGiven().length() < 1)
				|| (infoPatient.getDob() == null || infoPatient.getDob().after(new Date()))
				|| infoPatient.getAddress().length() > 60
				|| infoPatient.getPhone().length() > 30
				|| (infoPatient.getSex() != 'F' && infoPatient.getSex() != 'M')
				)
			throw new BadRequestBodyException("Check @RequestBody InfoPatient");
		return infoPatientRepository.save(infoPatient);
	}

	public Optional<InfoPatient> deleteById(UUID id) {
		if (! infoPatientRepository.findById(id).isPresent())
			throw new IdInfoPatientNotFoundException("Information Patient Id : " + id + " is not found in database.");
		Optional<InfoPatient> result = findById(id);
		infoPatientRepository.deleteById(id);
		return result;
	}

}
