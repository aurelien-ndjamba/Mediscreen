package com.mediscreen.infoPatient.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.mediscreen.infoPatient.service.InfoPatientService;


@WebMvcTest(controllers = InfoPatientController.class)
public class InfoPatientControllerTests {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
    private InfoPatientService infoPatientService;
	
	@Test
	public void TestFindById() throws Exception {
		mockMvc.perform(get("/patient/findById?id=338b4dba-6707-469d-b15e-8ed7a03bb1fd"))
				.andExpect(status().isOk())
				.andReturn();
	}
	
	@Test
	public void TestFindAll() throws Exception {
		mockMvc.perform(get("/patient/findAll"))
				.andExpect(status().isOk())
				.andReturn();
	}
	
	@Test
	public void TestSave() throws Exception {
		String infoPatientJson = "{\r\n"
				+ "    \"family\": \"NDJAMBA\",\r\n"
				+ "    \"given\": \"AUREL\",\r\n"
				+ "    \"dob\": \"2021-11-21T23:00:00.000+00:00\",\r\n"
				+ "    \"sex\": \"F\",\r\n"
				+ "    \"address\": \"13 Rue Belchamps, 57000 Metz\",\r\n"
				+ "    \"phone\": \"0613047188\"\r\n"
				+ "}";
				
		mockMvc.perform(post("/patient/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(infoPatientJson))
				.andDo(print())
                .andExpect(status().isCreated()) 
                .andReturn();
	}
	
	@Test
	public void TestDelete() throws Exception {
		mockMvc.perform(delete("/patient/delete?id=5a85400d-90dc-4571-a860-2545c79d927c"))
				.andExpect(status().isOk())
				.andReturn();
	}

}
