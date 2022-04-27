package com.mediscreen.infoPatient.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
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

import com.mediscreen.infoPatient.model.InfoPatient;
import com.mediscreen.infoPatient.repository.InfoPatientRepository;

@SpringBootTest
public class InfoPatientServiceTests {

	@Mock
	InfoPatientRepository infoPatientRepositoryMock;
	@Autowired
	InfoPatientService infoPatientService;

	@Test
	public void findByIdTest() throws ParseException {
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
		when(infoPatientRepositoryMock.findById(id)).thenReturn(Optional.of(infoPatient));
		infoPatientService.setInfoPatientRepository(infoPatientRepositoryMock);

		// THEN
		assertTrue(infoPatientService.findById(id).get().getFamily().equals("MACRON"));
	}

	@Test
	public void findAllTest() throws ParseException {
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
		when(infoPatientRepositoryMock.findAll()).thenReturn(infoPatients);
		infoPatientService.setInfoPatientRepository(infoPatientRepositoryMock);

		// THEN
		assertEquals(infoPatientService.findAll().size(), 1);
	}

	@Test
	public void saveTest() throws ParseException {
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
		when(infoPatientRepositoryMock.save(infoPatient)).thenReturn(infoPatient);
		infoPatientService.setInfoPatientRepository(infoPatientRepositoryMock);

		// THEN
		assertTrue(infoPatientService.save(infoPatient).getFamily().equals("MACRON"));
	}

	@Test
	public void deleteByIdTest() throws ParseException {
		//GIVEN
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
		when(infoPatientRepositoryMock.findById(id)).thenReturn(Optional.of(infoPatient));
		doNothing().when(infoPatientRepositoryMock).deleteById(id);
		infoPatientService.setInfoPatientRepository(infoPatientRepositoryMock);

		// THEN
		assertTrue(infoPatientService.deleteById(id).get().getFamily().equals("MACRON"));
	}
}
