package com.mediscreen.infoPatient.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.Past;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "infopatient", schema = "public")
@NoArgsConstructor
public class InfoPatient{
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
	
	@Column(name = "family")
	private String family;
	
	@Column(name = "given")
	private String given;
	
//	@NotNull
//	@Past(message = "Date of birth cannot be later than today")
//	@Length(min = 10, max = 10)
//	@Pattern(regexp="^(19|20)\\d\\d[\\-\\/.](0[1-9]|1[012])[\\-\\/.](0[1-9]|[12][0-9]|3[01])$") //YYYY-MM-DD
	@Column(name = "dob")
	private Date dob; 
	
	@Column(name = "sex") 
	private char sex;
	
	@Column(name = "address")   
	private String address;
	
	@Column(name = "phone")
	private String phone;

	public InfoPatient(String family, String given, Date dob, char sex, String address, String phone) {
		super();
		this.family = family;
		this.given = given;
		this.dob = dob;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
	}
	
}
