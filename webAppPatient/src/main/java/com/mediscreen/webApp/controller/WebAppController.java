package com.mediscreen.webApp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mediscreen.webApp.model.Gender;
import com.mediscreen.webApp.model.InfoPatient;
import com.mediscreen.webApp.model.MedicalRecordPatient;
import com.mediscreen.webApp.service.WebAppService;

/**
 * Controller WebAppController
 * 
 * @author Aurelien NDJAMBA
 * @version 0.0.1
 */
@Controller
public class WebAppController {

	@Autowired
	private WebAppService webAppService;

	// infoPatient
	private String infoPatientCreated;
	private String infoPatientUpdated;
	private String infoPatientDeleted;
	private String infoPatientfilteredByIdPatient;
	// historyPatient
	private String idMedicalRecord;
	private String medicalRecordCreated;
	private String newMedicalRecordCreated;
	private String medicalRecordUpdated;
	private String medicalRecordDeleted;
	private String medicalRecordsfilteredByIdPatient;

	/**
	 * Méthode pour afficher la page d'accueil
	 * 
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "redirect:/home";
	}

	/**
	 * Méthode pour afficher la page d'accueil
	 * 
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	/**
	 * Méthode pour afficher les informations de tous les patients
	 * 
	 * @param Model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/infoPatients", method = RequestMethod.GET)
	public String infoPatients(Model model) {
		List<InfoPatient> patients = webAppService.findAllInfoPatients();
		
		patients.forEach(x -> x.setRiskLevel(webAppService.findRiskLevelPatient(x.getId())));
		
		model.addAttribute("patients", patients);
		model.addAttribute("infoPatientCreated", infoPatientCreated);
		model.addAttribute("infoPatientDeleted", infoPatientDeleted);
		infoPatientCreated = null;
		infoPatientDeleted = null;
		return "infoPatient/list"; //infoPatient/list  infopatientlist
	}

	/**
	 * Méthode pour afficher les informations d'un patient
	 * 
	 * @param UUID
	 * @param InfoPatient
	 * @param Model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/infoPatient", method = RequestMethod.GET)
	public String getInfoPatient(@RequestParam UUID id, @ModelAttribute("infoPatientForm") InfoPatient infoPatientForm,
			Model model) {
		infoPatientfilteredByIdPatient = "FOR ID PATIENT : " + id;
		InfoPatient infoPatient = webAppService.findInfoPatientById(id).get();
		infoPatient.setRiskLevel(webAppService.findRiskLevelPatient(infoPatient.getId()));
		List<Gender> gender = new ArrayList<>();
		gender.add(Gender.F);
		gender.add(Gender.M);
		model.addAttribute("gender", gender);
		model.addAttribute("infoPatient", infoPatient);
		model.addAttribute("infoPatientUpdated", infoPatientUpdated);
		model.addAttribute("infoPatientfilteredByIdPatient", infoPatientfilteredByIdPatient);
		infoPatientUpdated = null;
		return "infoPatient/update"; //infoPatient/update  infopatientupdate
	}

	/**
	 * Méthode pour mettre à jour les informations d'un patient
	 * 
	 * @param UUID
	 * @param InfoPatient
	 * @param Model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/updateInfoPatient", method = RequestMethod.POST)
	public String updateInfoPatient(@RequestParam UUID id,
			@Valid @ModelAttribute("infoPatientForm") InfoPatient infoPatientForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			if (result.getFieldError("family") != null)
				model.addAttribute("exFamily", result.getFieldError("family").getDefaultMessage());
			if (result.getFieldError("given") != null)
				model.addAttribute("exGiven", result.getFieldError("given").getDefaultMessage());
			if (result.getFieldError("dob") != null)
				model.addAttribute("exDob", result.getFieldError("dob").getDefaultMessage());
			if (result.getFieldError("sex") != null)
				model.addAttribute("exGender", result.getFieldError("sex").getDefaultMessage());
			if (result.getFieldError("address") != null)
				model.addAttribute("exAddress", result.getFieldError("address").getDefaultMessage());
			if (result.getFieldError("phone") != null)
				model.addAttribute("exPhone", result.getFieldError("phone").getDefaultMessage());
			List<Gender> gender = new ArrayList<>();
			gender.add(Gender.F);
			gender.add(Gender.M);
			model.addAttribute("gender", gender);
			model.addAttribute("infoPatientForm", new InfoPatient());
			InfoPatient infoPatient = webAppService.findInfoPatientById(id).get();
			infoPatientfilteredByIdPatient = "FOR ID PATIENT : " + id;
			infoPatient.setRiskLevel(webAppService.findRiskLevelPatient(infoPatient.getId()));
			model.addAttribute("infoPatient", infoPatient);
			model.addAttribute("infoPatientfilteredByIdPatient", infoPatientfilteredByIdPatient);
			return "infoPatient/update"; //infoPatient/update infopatientupdate
		} else {
			infoPatientForm.setId(id);
			webAppService.saveInfoPatient(infoPatientForm);
			infoPatientUpdated = "ID PATIENT: " + id;
			model.addAttribute("infoPatientUpdated", infoPatientUpdated);
			return "redirect:/infoPatient?id=" + id;
		}
	}

	/**
	 * Méthode pour afficher la page d'ajout des informations d'un patient
	 * 
	 * @param InfoPatient
	 * @param Model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/addInfoPatient", method = RequestMethod.GET)
	public String addInfoPatientGet(Model model) {
		List<Gender> gender = new ArrayList<>();
		gender.add(Gender.F);
		gender.add(Gender.M);
		model.addAttribute("gender", gender);
		model.addAttribute("infoPatientForm", new InfoPatient());
		return "infoPatient/add"; //infoPatient/add infopatientadd
	}

	/**
	 * Méthode pour ajouter les informations d'un patient
	 * 
	 * @param InfoPatient
	 * @param Model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/addInfoPatient", method = RequestMethod.POST)
	public String addInfoPatientPost(@Valid @ModelAttribute("infoPatientForm") InfoPatient infoPatientForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			if (result.getFieldError("family") != null)
				model.addAttribute("exFamily", result.getFieldError("family").getDefaultMessage());
			if (result.getFieldError("given") != null)
				model.addAttribute("exGiven", result.getFieldError("given").getDefaultMessage());
			if (result.getFieldError("dob") != null)
				model.addAttribute("exDob", result.getFieldError("dob").getDefaultMessage());
			if (result.getFieldError("sex") != null)
				model.addAttribute("exGender", result.getFieldError("sex").getDefaultMessage());
			if (result.getFieldError("address") != null)
				model.addAttribute("exAddress", result.getFieldError("address").getDefaultMessage());
			if (result.getFieldError("phone") != null)
				model.addAttribute("exPhone", result.getFieldError("phone").getDefaultMessage());
			List<Gender> gender = new ArrayList<>();
			gender.add(Gender.F);
			gender.add(Gender.M);
			model.addAttribute("gender", gender);
			model.addAttribute("infoPatientForm", new InfoPatient());
			return "infoPatient/add"; //infoPatient/add  infopatientadd
		} else {
			InfoPatient newInfoPatient = webAppService.saveInfoPatient(infoPatientForm);
			infoPatientCreated = "ID PATIENT: " + newInfoPatient.getId();
			model.addAttribute("infoPatientCreated", infoPatientCreated);
			return "redirect:/infoPatients";
		}
	}

	/**
	 * Méthode pour supprimer les informations d'un patient
	 * 
	 * @param UUID
	 * @param Model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/deleteInfoPatient", method = RequestMethod.GET)
	public String deleteInfoPatient(@RequestParam UUID idPatient, Model model) {
		infoPatientDeleted = "ID PATIENT: " + idPatient;
		webAppService.deleteInfoPatientById(idPatient);
		List<MedicalRecordPatient> medicalRecordPatientByIdPatient = webAppService
				.findMedicalRecordsByIdPatient(idPatient);
		List<UUID> idsmedicalRecordPatientByIdPatient = new ArrayList<>();
		medicalRecordPatientByIdPatient.forEach(x -> idsmedicalRecordPatientByIdPatient.add(x.getId()));
		idsmedicalRecordPatientByIdPatient.forEach(x -> webAppService.deleteMedicalRecordPatientById(x));
		model.addAttribute("infoPatientDeleted", infoPatientDeleted);
		return "redirect:/infoPatients";
	}

	/**
	 * Méthode pour afficher l'ensemble des historiques médicaux de tous les
	 * patients
	 * 
	 * @param Model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/medicalRecords", method = RequestMethod.GET)
	public String medicalRecords(Model model) {
		List<MedicalRecordPatient> medicalRecords = webAppService.findAllMedicalRecordsPatients();
		model.addAttribute("medicalRecords", medicalRecords);
		model.addAttribute("medicalRecordDeleted", medicalRecordDeleted);
		model.addAttribute("newMedicalRecordCreated", newMedicalRecordCreated);
		medicalRecords = null;
		medicalRecordDeleted = null;
		newMedicalRecordCreated = null;
		return "medicalRecord/list"; //medicalRecord/list  medicalrecordlist
	}

	/**
	 * Méthode pour afficher le formulaire d'ajout d'un historique médical
	 * 
	 * @param MedicalRecordPatient
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/addMedicalRecord", method = RequestMethod.GET)
	public String addMedicalRecordGet(@ModelAttribute("medicalRecordForm") MedicalRecordPatient medicalRecordForm) {
		return "medicalRecord/add"; //medicalRecord/add  medicalrecordadd
	}

	/**
	 * Méthode pour sauvegarder l'historique médical d'un patient
	 * 
	 * @param MedicalRecordPatient
	 * @param BindingResult
	 * @param Model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/addMedicalRecord", method = RequestMethod.POST)
	public String addMedicalRecordPost(
			@Valid @ModelAttribute("medicalRecordForm") MedicalRecordPatient medicalRecordForm, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			if (result.getFieldError("idPatient") != null)
				model.addAttribute("exIdPatient", "Vérifier la valeur ID Patient saisie !");
			if (result.getFieldError("notes") != null)
				model.addAttribute("exNotes", result.getFieldError("notes").getDefaultMessage());
			return "medicalRecord/add"; //medicalRecord/add  medicalrecordadd
		} else {

			try {
				webAppService.findInfoPatientById(medicalRecordForm.getIdPatient());
			} catch (Exception e) {
				model.addAttribute("idPatientCheckedInDB", "IdPatient non existant !");
				return "medicalRecord/add"; //medicalRecord/add  medicalrecordadd
			}

			medicalRecordForm.setId(UUID.randomUUID());
			medicalRecordForm.setDate(new Date());
			MedicalRecordPatient newMedicalRecord = webAppService.saveMedicalRecordPatient(medicalRecordForm);
			newMedicalRecordCreated = "MEDICAL RECORD ID : " + newMedicalRecord.getId();
			return "redirect:/medicalRecords";
		}
	}

	/**
	 * Méthode pour afficher l'historique médical d'un patient
	 * 
	 * @param UUID
	 * @param MedicalRecordPatient
	 * @param Model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/getMedicalRecordById", method = RequestMethod.GET)
	public String getMedicalRecordById(@ModelAttribute("medicalRecordForm") MedicalRecordPatient medicalRecordForm,
			@RequestParam("id") UUID id, Model model) {
		MedicalRecordPatient medicalRecord = webAppService.findMedicalRecordPatientById(id).get();
		idMedicalRecord = "MEDICAL RECORD ID : " + medicalRecord.getId();
		model.addAttribute("medicalRecord", medicalRecord);
		model.addAttribute("idMedicalRecord", idMedicalRecord);
		model.addAttribute("id", id);
		model.addAttribute("medicalRecordUpdated", medicalRecordUpdated);
		medicalRecord = null;
		idMedicalRecord = null;
		id = null;
		medicalRecordUpdated = null;
		return "medicalRecord/update"; //medicalRecord/update  medicalrecordupdate
	}

	/**
	 * Méthode pour mettre à jour l'historique médical d'un patient
	 * 
	 * @param UUID
	 * @param MedicalRecordPatient
	 * @param Model
	 * 
	 */
	@RequestMapping(value = "/updateMedicalRecordById", method = RequestMethod.POST)
	public String updateMedicalRecordById(@ModelAttribute("medicalRecordForm") MedicalRecordPatient medicalRecordForm,
			@RequestParam("id") UUID id, Model model) {
		medicalRecordForm.setId(id);
		webAppService.updateMedicalRecordPatient(medicalRecordForm);
		medicalRecordUpdated = "YES";
		model.addAttribute("medicalRecordUpdated", medicalRecordUpdated);
		return "redirect:/getMedicalRecordById?id=" + id;
	}

	/**
	 * Méthode pour supprimer l'historique médical d'un patient
	 * 
	 * @param UUID
	 * @param Model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/deleteMedicalRecordById", method = RequestMethod.GET)
	public String deleteMedicalRecordById(@RequestParam UUID id, Model model) {
		webAppService.deleteMedicalRecordPatientById(id);
		medicalRecordDeleted = "MEDICAL RECORD ID : " + id;
		model.addAttribute(medicalRecordDeleted, medicalRecordDeleted);
		return "redirect:/medicalRecords";
	}

	/**
	 * Méthode pour afficher l'ensemble des historiques médicaux d'un patient
	 * 
	 * @param UUID
	 * @param MedicalRecordPatient
	 * @param Model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/getMedicalRecordByPatient", method = RequestMethod.GET)
	public String getMedicalRecordByPatient(@ModelAttribute("medicalRecordForm") MedicalRecordPatient medicalRecordForm,
			@RequestParam("id") UUID id, Model model) {
		List<MedicalRecordPatient> medicalRecords = webAppService.findMedicalRecordsByIdPatient(id);
		medicalRecordsfilteredByIdPatient = "FOR ID PATIENT: " + id;
		model.addAttribute("medicalRecordCreated", medicalRecordCreated);
		model.addAttribute("medicalRecords", medicalRecords);
		model.addAttribute("medicalRecordsfilteredByIdPatient", medicalRecordsfilteredByIdPatient);
		model.addAttribute("idPatient", id);
		medicalRecordForm = null;
		medicalRecords = null;
		medicalRecordsfilteredByIdPatient = null;
		medicalRecordCreated = null;
		id = null;
		return "medicalRecord/list"; //medicalRecord/list  medicalrecordlist
	}

	/**
	 * Méthode pour sauvegarder l'historique médical d'un patient
	 * 
	 * @param UUID
	 * @param MedicalRecordPatient
	 * @param Model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/createMedicalRecord", method = RequestMethod.POST)
	public String createMedicalRecord(@ModelAttribute("medicalRecordForm") MedicalRecordPatient medicalRecordForm,
			@RequestParam UUID id, Model model) {
		medicalRecordForm.setIdPatient(id);
		medicalRecordForm.setDate(new Date());
		medicalRecordForm.setId(UUID.randomUUID());
		MedicalRecordPatient medicalRecord = webAppService.saveMedicalRecordPatient(medicalRecordForm);
		medicalRecordCreated = "MEDICAL RECORD ID : " + medicalRecord.getId();
		model.addAttribute("medicalRecordCreated", medicalRecordCreated); 
		return "redirect:/getMedicalRecordByPatient?id=" + id; 
	}

}
