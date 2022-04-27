package com.mediscreen.riskLevelPatient.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.mediscreen.riskLevelPatient.service.RiskLevelPatientService;

@WebMvcTest(controllers = RiskLevelPatientController.class)
public class RiskLevelPatientControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
    private RiskLevelPatientService riskLevelPatientServiceMock;
	
	@Test
	public void TestFindRiskLevelPatient() throws Exception {
		mockMvc.perform(get("/riskLevelPatient?id=bee3168f-dae3-40b2-8641-86684c384692"))
				.andExpect(status().is4xxClientError())
				.andReturn();
	}

}
