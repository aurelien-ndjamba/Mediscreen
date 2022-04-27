package com.mediscreen.medicalRecordPatient.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mediscreen.medicalRecordPatient.model.MedicalRecordPatient;
import com.mediscreen.medicalRecordPatient.repository.MedicalRecordPatientRepository;

@SpringBootTest
public class MedicalRecordPatientServiceTests {
	
	@Mock
	MedicalRecordPatientRepository medicalRecordPatientRepositoryMock;
	@Autowired
	MedicalRecordPatientService medicalRecordPatientService;

	@Test
	public void findByIdTest() {
		// GIVEN
		UUID id = UUID.fromString("440b6771-041b-4bca-895c-3c3ba7f2b92f");
		UUID idPatient = UUID.fromString("9a0fe80e-65be-4c9b-a557-4858d6f20602");
		MedicalRecordPatient medicalRecordPatient = new MedicalRecordPatient();
		medicalRecordPatient.setId(id);
		medicalRecordPatient.setIdPatient(idPatient);
		medicalRecordPatient.setNotes("New diag");

		// WHEN
		when(medicalRecordPatientRepositoryMock.findById(id)).thenReturn(Optional.of(medicalRecordPatient));
		medicalRecordPatientService.setMedicalRecordPatientRepository(medicalRecordPatientRepositoryMock);

		// THEN
		assertTrue(medicalRecordPatientService.findById(id).get().getNotes().equals("New diag"));
	}
	
	@Test
	public void findByIdPatientTest() {
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
		when(medicalRecordPatientRepositoryMock.findByIdPatientOrderByDateDesc(idPatient)).thenReturn(medicalRecordPatients);
		medicalRecordPatientService.setMedicalRecordPatientRepository(medicalRecordPatientRepositoryMock);

		// THEN
		assertEquals(medicalRecordPatientService.findByIdPatient(idPatient).size(),1);
	}

	@Test
	public void findAllTest() {
		// GIVEN
		UUID id = UUID.fromString("440b6771-041b-4bca-895c-3c3ba7f2b92f");
		UUID idPatient = UUID.fromString("9a0fe80e-65be-4c9b-a557-4858d6f20602");
		MedicalRecordPatient medicalRecordPatient = new MedicalRecordPatient();
		medicalRecordPatient.setId(id);
		medicalRecordPatient.setIdPatient(idPatient);
		medicalRecordPatient.setNotes("New diag");
		medicalRecordPatient.setDate(new Date());
		List<MedicalRecordPatient> medicalRecordPatients = new ArrayList<>();
		medicalRecordPatients.add(medicalRecordPatient);

		// WHEN
		when(medicalRecordPatientRepositoryMock.findByOrderByDateDesc()).thenReturn(medicalRecordPatients);
		medicalRecordPatientService.setMedicalRecordPatientRepository(medicalRecordPatientRepositoryMock);

		// THEN
		assertEquals(medicalRecordPatientService.findAll().size(), 1);
	}

	@Test
	public void saveTest() {
		// GIVEN
		UUID id = UUID.fromString("440b6771-041b-4bca-895c-3c3ba7f2b92f");
		UUID idPatient = UUID.fromString("9a0fe80e-65be-4c9b-a557-4858d6f20602");
		MedicalRecordPatient medicalRecordPatient = new MedicalRecordPatient();
		medicalRecordPatient.setId(id);
		medicalRecordPatient.setIdPatient(idPatient);
		medicalRecordPatient.setNotes("New diag");
		medicalRecordPatient.setDate(new Date());

		// WHEN
		when(medicalRecordPatientRepositoryMock.save(medicalRecordPatient)).thenReturn(medicalRecordPatient);
		medicalRecordPatientService.setMedicalRecordPatientRepository(medicalRecordPatientRepositoryMock);

		// THEN
		assertTrue(medicalRecordPatientService.save(medicalRecordPatient).getNotes().equals("New diag"));
	}

	@Test
	public void deleteByIdTest() {
		// GIVEN
		UUID id = UUID.fromString("440b6771-041b-4bca-895c-3c3ba7f2b92f");
		UUID idPatient = UUID.fromString("9a0fe80e-65be-4c9b-a557-4858d6f20602");
		MedicalRecordPatient medicalRecordPatient = new MedicalRecordPatient();
		medicalRecordPatient.setId(id);
		medicalRecordPatient.setIdPatient(idPatient);
		medicalRecordPatient.setNotes("New diag");

		// WHEN
		when(medicalRecordPatientRepositoryMock.findById(id)).thenReturn(Optional.of(medicalRecordPatient));
		doNothing().when(medicalRecordPatientRepositoryMock).deleteById(id);
		medicalRecordPatientService.setMedicalRecordPatientRepository(medicalRecordPatientRepositoryMock);

		// THEN
		assertTrue(medicalRecordPatientService.deleteById(id).get().getNotes().equals("New diag"));
	}

}
