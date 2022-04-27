package com.mediscreen.webApp.service;

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

import com.mediscreen.webApp.model.InfoPatient;
import com.mediscreen.webApp.model.MedicalRecordPatient;
import com.mediscreen.webApp.proxy.WebAppProxy;

@SpringBootTest
public class WebAppServiceTests {

	@Mock
	WebAppProxy webAppProxymock;
	@Autowired
	WebAppService webAppService;

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
		when(webAppProxymock.findInfoPatientById(id)).thenReturn(Optional.of(infoPatient));
		webAppService.setWebAppProxy(webAppProxymock);

		// THEN
		assertTrue(webAppService.findInfoPatientById(id).get().getFamily().equals("MACRON"));
	}

	@Test
	public void findAllInfoPatientsTest() throws ParseException {
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
		List<InfoPatient> infoPatients = new ArrayList<>();
		infoPatients.add(infoPatient);

		// WHEN
		when(webAppProxymock.findAllInfoPatients()).thenReturn(infoPatients);
		webAppService.setWebAppProxy(webAppProxymock);

		// THEN
		assertEquals(webAppService.findAllInfoPatients().size(), 1);
	}

	@Test
	public void saveInfoPatientTest() throws ParseException {
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
		when(webAppProxymock.saveInfoPatient(infoPatient)).thenReturn(infoPatient);
		webAppService.setWebAppProxy(webAppProxymock);

		// THEN
		assertTrue(webAppService.saveInfoPatient(infoPatient).getFamily().equals("MACRON"));
	}

	@Test
	public void updateInfoPatientTest() throws ParseException {
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
		when(webAppProxymock.updateInfoPatient(infoPatient)).thenReturn(infoPatient);
		webAppService.setWebAppProxy(webAppProxymock);

		// THEN
		assertTrue(webAppService.updateInfoPatient(infoPatient).getFamily().equals("MACRON"));
	}

	@Test
	public void deleteInfoPatientByIdTest() throws ParseException {
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
		when(webAppProxymock.deleteInfoPatientById(id)).thenReturn(Optional.of(infoPatient));
		webAppService.setWebAppProxy(webAppProxymock);

		// THEN
		assertTrue(webAppService.deleteInfoPatientById(id).get().getFamily().equals("MACRON"));
	}

	@Test
	public void findMedicalRecordPatientByIdTest() {
		// GIVEN
		UUID id = UUID.fromString("440b6771-041b-4bca-895c-3c3ba7f2b92f");
		UUID idPatient = UUID.fromString("9a0fe80e-65be-4c9b-a557-4858d6f20602");
		MedicalRecordPatient medicalRecordPatient = new MedicalRecordPatient();
		medicalRecordPatient.setId(id);
		medicalRecordPatient.setIdPatient(idPatient);
		medicalRecordPatient.setNotes("New diag");

		// WHEN
		when(webAppProxymock.findMedicalRecordPatientById(id)).thenReturn(Optional.of(medicalRecordPatient));
		webAppService.setWebAppProxy(webAppProxymock);

		// THEN
		assertTrue(webAppService.findMedicalRecordPatientById(id).get().getNotes().equals("New diag"));
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
		when(webAppProxymock.findMedicalRecordsByIdPatient(idPatient)).thenReturn(medicalRecordPatients);
		webAppService.setWebAppProxy(webAppProxymock);

		// THEN
		assertEquals(webAppService.findMedicalRecordsByIdPatient(idPatient).size(), 1);
	}

	@Test
	public void findAllMedicalRecordsPatientsTest() {
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
		when(webAppProxymock.findAllMedicalRecordsPatients()).thenReturn(medicalRecordPatients);
		webAppService.setWebAppProxy(webAppProxymock);

		// THEN
		assertEquals(webAppService.findAllMedicalRecordsPatients().size(), 1);
	}

	@Test
	public void saveMedicalRecordPatientTest() {
		// GIVEN
		UUID id = UUID.fromString("440b6771-041b-4bca-895c-3c3ba7f2b92f");
		UUID idPatient = UUID.fromString("9a0fe80e-65be-4c9b-a557-4858d6f20602");
		MedicalRecordPatient medicalRecordPatient = new MedicalRecordPatient();
		medicalRecordPatient.setId(id);
		medicalRecordPatient.setIdPatient(idPatient);
		medicalRecordPatient.setNotes("New diag");

		// WHEN
		when(webAppProxymock.saveMedicalRecordPatient(medicalRecordPatient)).thenReturn(medicalRecordPatient);
		webAppService.setWebAppProxy(webAppProxymock);

		// THEN
		assertTrue(webAppService.saveMedicalRecordPatient(medicalRecordPatient).getNotes().equals("New diag"));
	}

	@Test
	public void updateMedicalRecordPatientTest() {
		// GIVEN
		UUID id = UUID.fromString("440b6771-041b-4bca-895c-3c3ba7f2b92f");
		UUID idPatient = UUID.fromString("9a0fe80e-65be-4c9b-a557-4858d6f20602");
		MedicalRecordPatient medicalRecordPatient = new MedicalRecordPatient();
		medicalRecordPatient.setId(id);
		medicalRecordPatient.setIdPatient(idPatient);
		medicalRecordPatient.setNotes("New diag");

		// WHEN
		when(webAppProxymock.findMedicalRecordPatientById(id)).thenReturn(Optional.of(medicalRecordPatient));
		when(webAppProxymock.saveMedicalRecordPatient(medicalRecordPatient)).thenReturn(medicalRecordPatient);
		webAppService.setWebAppProxy(webAppProxymock);

		// THEN
		assertTrue(webAppService.updateMedicalRecordPatient(medicalRecordPatient).getNotes().equals("New diag"));
	}

	@Test
	public void deleteMedicalRecordPatientByIdTest() {
		// GIVEN
		UUID id = UUID.fromString("440b6771-041b-4bca-895c-3c3ba7f2b92f");
		UUID idPatient = UUID.fromString("9a0fe80e-65be-4c9b-a557-4858d6f20602");
		MedicalRecordPatient medicalRecordPatient = new MedicalRecordPatient();
		medicalRecordPatient.setId(id);
		medicalRecordPatient.setIdPatient(idPatient);
		medicalRecordPatient.setNotes("New diag");

		// WHEN
		when(webAppProxymock.deleteMedicalRecordPatientById(id)).thenReturn(Optional.of(medicalRecordPatient));
		webAppService.setWebAppProxy(webAppProxymock);

		// THEN
		assertTrue(webAppService.deleteMedicalRecordPatientById(id).get().getNotes().equals("New diag"));
	}

	@Test
	public void findRiskLevelPatientTest() throws ParseException {
		// GIVEN
		String riskLevel = "In Danger";
		UUID idPatient = UUID.fromString("9a0fe80e-65be-4c9b-a557-4858d6f20602");

		// WHEN
		when(webAppProxymock.findRiskLevelPatient(idPatient)).thenReturn(riskLevel);
		webAppService.setWebAppProxy(webAppProxymock);

		// THEN
		assertEquals(webAppService.findRiskLevelPatient(idPatient), riskLevel);
	}

}
