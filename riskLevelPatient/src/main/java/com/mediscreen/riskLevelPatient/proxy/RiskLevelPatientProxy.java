package com.mediscreen.riskLevelPatient.proxy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mediscreen.riskLevelPatient.configuration.CustomProperties;
import com.mediscreen.riskLevelPatient.model.MedicalRecordPatient;
import com.mediscreen.riskLevelPatient.model.InfoPatient;

/**
 * RiskLevelPatientProxy
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@Component
public class RiskLevelPatientProxy {
	
	@Autowired
	private CustomProperties props;

	public Optional<InfoPatient> findInfoPatientById(UUID id) {
		String baseApiUrl = props.getApiUrlInfoPatient();
		String apiUrl = baseApiUrl + "/patient/findById?id=" + id;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Optional<InfoPatient>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Optional<InfoPatient>>() {
		});
		return response.getBody();
	}

	public List<MedicalRecordPatient> findMedicalRecordsByIdPatient(UUID id) {
		String baseApiUrl = props.getApiUrlMedicalRecordPatient();
		String apiUrl = baseApiUrl + "/patHistory/findByIdPatient?id=" + id;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<MedicalRecordPatient>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<MedicalRecordPatient>>() {
		});
		return response.getBody();
	}

}
