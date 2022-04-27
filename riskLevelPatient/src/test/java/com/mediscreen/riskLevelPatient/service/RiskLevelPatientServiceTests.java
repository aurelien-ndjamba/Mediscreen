package com.mediscreen.riskLevelPatient.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mediscreen.riskLevelPatient.configuration.CustomProperties;
import com.mediscreen.riskLevelPatient.model.InfoPatient;
import com.mediscreen.riskLevelPatient.model.MedicalRecordPatient;
import com.mediscreen.riskLevelPatient.proxy.RiskLevelPatientProxy;

@SpringBootTest
public class RiskLevelPatientServiceTests {

	@Mock
	RiskLevelPatientProxy riskLevelPatientProxyMock;
	@Mock
	CustomProperties propsMock;
	@Autowired
	RiskLevelPatientService riskLevelPatientService;

	@Test
	public void findInfoPatientByIdTest() throws ParseException {
		// GIVEN
		UUID id = UUID.fromString("440b6771-041b-4bca-895c-3c3ba7f2b92f");
		InfoPatient infoPatient = new InfoPatient();
		infoPatient.setId(id);
		infoPatient.setFamily("MACRON");
		infoPatient.setGiven("Emmanuel");
		infoPatient.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1982-12-15"));
		infoPatient.setSex('M');
		infoPatient.setAddress("13 Rue des Champs Elysée, 75000 Paris");
		infoPatient.setPhone("0613045278");

		// WHEN
		when(riskLevelPatientProxyMock.findInfoPatientById(id)).thenReturn(Optional.of(infoPatient));
		riskLevelPatientService.setRiskLevelPatientProxy(riskLevelPatientProxyMock);

		// THEN
		assertTrue(riskLevelPatientService.findInfoPatientById(id).get().getFamily().equals("MACRON"));
	}

	@Test
	public void findMedicalRecordsByIdPatientTest() {
		// GIVEN
		UUID id = UUID.fromString("440b6771-041b-4bca-895c-3c3ba7f2b92f");
		UUID idPatient = UUID.fromString("9a0fe80e-65be-4c9b-a557-4858d6f20602");
		MedicalRecordPatient medicalRecordPatient = new MedicalRecordPatient();
		medicalRecordPatient.setId(id);
		medicalRecordPatient.setIdPatient(idPatient);
		medicalRecordPatient.setNotes("New diag");
		List<MedicalRecordPatient> medicalRecordPatients = new ArrayList<>();
		medicalRecordPatients.add(medicalRecordPatient);

		// WHEN
		when(riskLevelPatientProxyMock.findMedicalRecordsByIdPatient(idPatient)).thenReturn(medicalRecordPatients);
		riskLevelPatientService.setRiskLevelPatientProxy(riskLevelPatientProxyMock);

		// THEN
		assertEquals(riskLevelPatientService.findMedicalRecordsPatientsByIdPatient(idPatient).size(), 1);
	}

	@Test
	public void readTriggersFileTest() {
		// GIVEN
		String pathTriggers = "target/classes/triggers.txt";

		// WHEN
		when(propsMock.getPathTriggers()).thenReturn(pathTriggers);
		riskLevelPatientService.setProps(propsMock);

		// THEN
		assertEquals(riskLevelPatientService.readTriggersFile().size(), 11);
	}

	@Test
	public void findAgePatientTest() throws ParseException {
		// GIVEN
		UUID id = UUID.fromString("440b6771-041b-4bca-895c-3c3ba7f2b92f");
		InfoPatient infoPatient = new InfoPatient();
		infoPatient.setId(id);
		infoPatient.setFamily("MACRON");
		infoPatient.setGiven("Emmanuel");
		infoPatient.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1987-07-15"));
		infoPatient.setSex('M');
		infoPatient.setAddress("13 Rue des Champs Elysée, 75000 Paris");
		infoPatient.setPhone("0613045278");

		// WHEN
		when(riskLevelPatientProxyMock.findInfoPatientById(id)).thenReturn(Optional.of(infoPatient));
		riskLevelPatientService.setRiskLevelPatientProxy(riskLevelPatientProxyMock);

		// THEN
		assertEquals(riskLevelPatientService.findAgePatient(id),34);
	}

	@Test
	public void findTriggerCountTest() {
		// GIVEN
		UUID id = UUID.fromString("440b6771-041b-4bca-895c-3c3ba7f2b92f");
		UUID idPatient = UUID.fromString("9a0fe80e-65be-4c9b-a557-4858d6f20602");
		MedicalRecordPatient medicalRecordPatient = new MedicalRecordPatient();
		medicalRecordPatient.setId(id);
		medicalRecordPatient.setIdPatient(idPatient);
		medicalRecordPatient.setNotes("Taille et Poids");
		List<MedicalRecordPatient> medicalRecordPatients = new ArrayList<>();
		medicalRecordPatients.add(medicalRecordPatient);

		// WHEN
		when(riskLevelPatientProxyMock.findMedicalRecordsByIdPatient(idPatient)).thenReturn(medicalRecordPatients);
		riskLevelPatientService.setRiskLevelPatientProxy(riskLevelPatientProxyMock);

		// THEN
		assertEquals(riskLevelPatientService.findTriggerCount(idPatient), 2);
	}
	
	@Test
	public void findRiskLevelPatientTest() throws ParseException {
		// GIVEN
		UUID id = UUID.fromString("440b6771-041b-4bca-895c-3c3ba7f2b92f");
		UUID idPatient = UUID.fromString("9a0fe80e-65be-4c9b-a557-4858d6f20602");
		InfoPatient infoPatient = new InfoPatient();
		infoPatient.setId(idPatient);
		infoPatient.setFamily("MACRON");
		infoPatient.setGiven("Emmanuel");
		infoPatient.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("2000-07-15"));
		infoPatient.setSex('M');
		infoPatient.setAddress("13 Rue des Champs Elysée, 75000 Paris");
		infoPatient.setPhone("0613045278");
		MedicalRecordPatient medicalRecordPatient = new MedicalRecordPatient();
		medicalRecordPatient.setId(id);
		medicalRecordPatient.setIdPatient(idPatient);
		medicalRecordPatient.setNotes("Taille et Poids et Fumeur");
		List<MedicalRecordPatient> medicalRecordPatients = new ArrayList<>();
		medicalRecordPatients.add(medicalRecordPatient);

		// WHEN
		when(riskLevelPatientProxyMock.findInfoPatientById(idPatient)).thenReturn(Optional.of(infoPatient));
		when(riskLevelPatientProxyMock.findMedicalRecordsByIdPatient(idPatient)).thenReturn(medicalRecordPatients);
		riskLevelPatientService.setRiskLevelPatientProxy(riskLevelPatientProxyMock);

		// THEN
		assertEquals(riskLevelPatientService.findRiskLevelPatient(idPatient), "In Danger");
	}

}
