package com.mediscreen.medicalRecordPatient.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.mediscreen.medicalRecordPatient.service.MedicalRecordPatientService;

@WebMvcTest(controllers = MedicalRecordPatientController.class)
@AutoConfigureDataMongo
public class MedicalRecordPatientControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
    private MedicalRecordPatientService medicalRecordPatientService;
	
	@Test
	public void TestFindById() throws Exception {
		mockMvc.perform(get("/patHistory/findById?id=bee3168f-dae3-40b2-8641-86684c384692"))
				.andExpect(status().isOk())
				.andReturn();
	}
	
	@Test
	public void TestFindByIdPatient() throws Exception {
		mockMvc.perform(get("/patHistory/findByIdPatient?id=bee3168f-dae3-40b2-8641-86684c384692"))
				.andExpect(status().isOk())
				.andReturn();
	}
	
	@Test
	public void TestFindAll() throws Exception {
		mockMvc.perform(get("/patHistory/findAll"))
				.andExpect(status().isOk())
				.andReturn();
	}
	
	@Test
	public void TestSave() throws Exception {
		String medicalRecordPatientJson = "{{\r\n"
				+ "    \"id\": \"fa9f5878-d258-4a49-80c6-af40e4162481\",\r\n"
				+ "    \"date\": \"2022-04-20T00:17:12.710+00:00\",\r\n"
				+ "    \"idPatient\": \"b63d6a9b-5804-465f-8e0d-21cfc3e1ca94\",\r\n"
				+ "    \"notes\": \"ça ne va PLUSSSSSSSSSSSSSSSSS\"\r\n"
				+ "}";
				
		mockMvc.perform(post("/patHistory/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(medicalRecordPatientJson))
                .andExpect(status().is4xxClientError())
                .andReturn();
	}
	
	@Test
	public void TestDelete() throws Exception {
		mockMvc.perform(delete("/patHistory/delete?id=5a85400d-90dc-4571-a860-2545c79d927c"))
		.andExpect(status().isOk())
		.andReturn();
	}

}
