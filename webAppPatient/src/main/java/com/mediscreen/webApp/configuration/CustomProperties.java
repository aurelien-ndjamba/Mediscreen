package com.mediscreen.webApp.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.mediscreen.webApp.configuration.CustomProperties;

import lombok.Data;

/**
 * CustomProperties
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@Data
@Configuration
@ConfigurationProperties(prefix="com.mediscreen")
public class CustomProperties {

	private String apiUrlInfoPatient;
	private String apiUrlMedicalRecordPatient;
	private String apiUrlRiskLevelPatient;

}
