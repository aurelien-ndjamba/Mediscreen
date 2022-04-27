package com.mediscreen.medicalRecordPatient;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mediscreen.medicalRecordPatient.model.MedicalRecordPatient;
import com.mediscreen.medicalRecordPatient.repository.MedicalRecordPatientRepository;

/** 
 * Entity MedicalRecordPatientApplication
 * 
 * @author Aurelien NDJAMBA 
 * @version 0.0.1
 */
@SpringBootApplication
@EnableMongoRepositories
public class MedicalRecordPatientApplication implements CommandLineRunner{
	
	@Autowired
	MedicalRecordPatientRepository medicalRecordPatientRepository;

	public static void main(String[] args) {
		SpringApplication.run(MedicalRecordPatientApplication.class, args);
	}
 
	@Override
	public void run(String... args) throws Exception { 

//		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("338b4dba-6707-469d-b15e-8ed7a03bb1fd"), "Practitioner's notes/recommendations: Patient states that they are 'feeling terrific' Weight at or below recommended level"));
//		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("637b3fff-290c-4bf5-ac6e-12b11cf12cc8"), "Practitioner's notes/recommendations: Patient states that they are feeling a great deal of stress at work Patient also complains that their hearing seems Abnormal as of late"));
//		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("637b3fff-290c-4bf5-ac6e-12b11cf12cc8"), "Practitioner's notes/recommendations: Patient states that they have had a Reaction to medication within last 3 months Patient also complains that their hearing continues to be problematic"));
//		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("255cbb6e-a28d-449e-b017-0f9d7c3b9564"), "Practitioner's notes/recommendations: Patient states that they are short term Smoker"));
//		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("255cbb6e-a28d-449e-b017-0f9d7c3b9564"), "Practitioner's notes/recommendations: Patient states that they quit within last year Patient also complains that of Abnormal breathing spells Lab reports Cholesterol LDL high"));
//		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("ec6e8d79-e612-4c18-ae78-c3384139cb7f"), "Practitioner's notes/recommendations: Patient states that walking up stairs has become difficult Patient also complains that they are having shortness of breath Lab results indicate Antibodies present elevated Reaction to medication"));
//		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("ec6e8d79-e612-4c18-ae78-c3384139cb7f"), "Practitioner's notes/recommendations: Patient states that they are experiencing back pain when seated for a long time"));
//		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("ec6e8d79-e612-4c18-ae78-c3384139cb7f"), "Practitioner's notes/recommendations: Patient states that they are a short term Smoker Hemoglobin A1C above recommended level"));
//		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("ec6e8d79-e612-4c18-ae78-c3384139cb7f"), "Practitioner's notes/recommendations: Patient states that Body Height, Body Weight, Cholesterol, Dizziness and Reaction"));

		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("bee3168f-dae3-40b2-8641-86684c384692"), "Le patient déclare qu'il « se sent très bien »"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("bee3168f-dae3-40b2-8641-86684c384692"), "Le patient déclare qu'il se sent fatigué pendant la journée"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("bee3168f-dae3-40b2-8641-86684c384692"), "Le patient déclare qu'il ne se sent pas si fatigué que ça"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("1b75bc5f-647e-463b-92e8-fc3405330eb2"), "Le patient déclare qu'il ressent beaucoup de stress au travail"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("1b75bc5f-647e-463b-92e8-fc3405330eb2"), "Le patient déclare avoir fait une réaction aux médicaments au cours des 3 derniers mois"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("1b75bc5f-647e-463b-92e8-fc3405330eb2"), "Tests de laboratoire indiquant une microalbumine élevée"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("1b75bc5f-647e-463b-92e8-fc3405330eb2"), "Le patient déclare que tout semble aller bien"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("d0ce1967-89be-4e44-ad6f-d9725dfe9e9e"), "Le patient déclare qu'il fume depuis peu"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("d0ce1967-89be-4e44-ad6f-d9725dfe9e9e"), "Tests de laboratoire indiquant une microalbumine élevée"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("d0ce1967-89be-4e44-ad6f-d9725dfe9e9e"), "Le patient déclare qu'il est fumeur et qu'il a cessé de fumer l'année dernière"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("d0ce1967-89be-4e44-ad6f-d9725dfe9e9e"), "Tests de laboratoire indiquant un taux de cholestérol LDL élevé"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("b07476eb-123d-464c-a26f-d0ac76efc4df"), "Le patient déclare qu'il lui est devenu difficile de monter les escaliers"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("b07476eb-123d-464c-a26f-d0ac76efc4df"), "Le patient déclare qu'il a mal au dos lorsqu'il reste assis pendant longtemps"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("b07476eb-123d-464c-a26f-d0ac76efc4df"), "Le patient déclare avoir commencé à fumer depuis peu"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("5671862f-36a1-49c8-8003-0e7cae420bbf"), "Le patient déclare avoir des douleurs au cou occasionnellement"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("5671862f-36a1-49c8-8003-0e7cae420bbf"), "Le patient déclare avoir eu plusieurs épisodes de vertige depuis la dernière visite."));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("5671862f-36a1-49c8-8003-0e7cae420bbf"), "Le patient déclare qu'il souffre encore de douleurs cervicales occasionnelles"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("5671862f-36a1-49c8-8003-0e7cae420bbf"), "Le patient déclare avoir eu plusieurs épisodes de vertige depuis la dernière visite."));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("d4c3df6e-2df3-4c42-a0a9-2c6e662d4372"), "Le patient déclare qu'il se sent bien"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("d4c3df6e-2df3-4c42-a0a9-2c6e662d4372"), "Le patient déclare qu'il se sent bien"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("fcb2b7bc-034f-496c-8ad1-d78d15688391"), "Le patient déclare qu'il se réveille souvent avec une raideur articulaire"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("6ed38280-ce5d-4266-8c55-ace2e70cb3cf"), "Les tests de laboratoire indiquent que les anticorps sont élevés"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("eef94901-e915-4dfe-a06d-49873f8811ad"), "Le patient déclare avoir de la difficulté à se concentrer sur ses devoirs scolaires"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("eef94901-e915-4dfe-a06d-49873f8811ad"), "Le patient déclare qu'il s’impatiente facilement en cas d’attente prolongée"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("eef94901-e915-4dfe-a06d-49873f8811ad"), "Le patient signale qu'il est facilement irrité par des broutilles"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("f6acefba-8fbf-45e7-b93a-faef2c61b218"), "Le patient déclare qu'il se sent bien"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("f6acefba-8fbf-45e7-b93a-faef2c61b218"), "Le patient déclare qu'il se sent bien"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("f6acefba-8fbf-45e7-b93a-faef2c61b218"), "Le patient déclare qu'il se sent bien"));
		medicalRecordPatientRepository.save(new MedicalRecordPatient(UUID.fromString("f6acefba-8fbf-45e7-b93a-faef2c61b218"), "Le patient déclare qu'il se sent bien"));
	
	}   
  
}  
