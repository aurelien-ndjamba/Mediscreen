package com.mediscreen.webApp.proxy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mediscreen.webApp.configuration.CustomProperties;
import com.mediscreen.webApp.model.MedicalRecordPatient;
import com.mediscreen.webApp.model.InfoPatient;

/**
 * Proxy WebAppProxy
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@Component
public class WebAppProxy {

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
	
	public List<InfoPatient> findAllInfoPatients() {
		String baseApiUrl = props.getApiUrlInfoPatient();
		String apiUrl = baseApiUrl + "/patient/findAll";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<InfoPatient>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<InfoPatient>>() {
		});
		return response.getBody();
	}

	public InfoPatient saveInfoPatient(InfoPatient patient) {  
		String baseApiUrl = props.getApiUrlInfoPatient();
		String apiUrl = baseApiUrl + "/patient/add";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<InfoPatient> request = new HttpEntity<InfoPatient>(patient);
		ResponseEntity<InfoPatient> response = restTemplate.exchange(apiUrl, HttpMethod.POST, request, InfoPatient.class);
		return response.getBody();
	}
 
	public InfoPatient updateInfoPatient(InfoPatient patient) {
		
		String baseApiUrl = props.getApiUrlInfoPatient();
		String apiUrl = baseApiUrl + "/patient/update?id="+patient.getId();
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<InfoPatient> request = new HttpEntity<InfoPatient>(patient);
		ResponseEntity<InfoPatient> response = restTemplate.exchange(apiUrl, HttpMethod.PUT, request, InfoPatient.class);
		return response.getBody();
	}

	public Optional<InfoPatient> deleteInfoPatientById(UUID id) {
		String baseApiUrl = props.getApiUrlInfoPatient();
		String apiUrl = baseApiUrl + "/patient/delete?id=" + id;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Optional<InfoPatient>> response = restTemplate.exchange(apiUrl, HttpMethod.DELETE, null, new ParameterizedTypeReference<Optional<InfoPatient>>() {
		});
		return response.getBody();
	}
	
	public Optional<MedicalRecordPatient> findMedicalRecordPatientById(UUID id) {
		String baseApiUrl = props.getApiUrlMedicalRecordPatient();
		String apiUrl = baseApiUrl + "/patHistory/findById?id=" + id;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Optional<MedicalRecordPatient>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Optional<MedicalRecordPatient>>() {
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

	public List<MedicalRecordPatient> findAllMedicalRecordsPatients() {
		String baseApiUrl = props.getApiUrlMedicalRecordPatient();
		String apiUrl = baseApiUrl + "/patHistory/findAll";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<MedicalRecordPatient>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<MedicalRecordPatient>>() {
		});
		return response.getBody();
	}
	
	public MedicalRecordPatient saveMedicalRecordPatient(MedicalRecordPatient medicalRecordPatient) {  
		String baseApiUrl = props.getApiUrlMedicalRecordPatient();
		String apiUrl = baseApiUrl + "/patHistory/add";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<MedicalRecordPatient> request = new HttpEntity<MedicalRecordPatient>(medicalRecordPatient);
		ResponseEntity<MedicalRecordPatient> response = restTemplate.exchange(apiUrl, HttpMethod.POST, request, MedicalRecordPatient.class);
		return response.getBody();
	}   

	public  Optional<MedicalRecordPatient> deleteMedicalRecordPatientById(UUID id) {
		String baseApiUrl = props.getApiUrlMedicalRecordPatient();
		String apiUrl = baseApiUrl + "/patHistory/delete?id=" + id;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Optional<MedicalRecordPatient>> response = restTemplate.exchange(apiUrl, HttpMethod.DELETE, null,
				new ParameterizedTypeReference<Optional<MedicalRecordPatient>>() {
		});
		return response.getBody();
	}     

	public String findRiskLevelPatient(UUID id) {
		String baseApiUrl = props.getApiUrlRiskLevelPatient();
		String apiUrl = baseApiUrl + "/assess?id=" + id;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, String.class);
		return response.getBody();
	}

}
