package br.com.api.capsrnrb.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column(name="mother_name")
	private String motherName;
	
	@Column(name="nu_prontuario")
	private Long nuProntuario;
	
	@Column(name="nu_cart_sus")
	private String nuCartSus;
	
	@Column(name="file_local")
	private String fileLocal;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private Address address;
	
	@Column(name="date_of_birth")
	@DateTimeFormat
	private Calendar dateOfBirth;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinTable(name = "user_screeningdate", joinColumns = {@JoinColumn(name="user_id")}, inverseJoinColumns = {@JoinColumn(name="screeningdate_id")})
	private List<ScreeningDate> screeningDate = new ArrayList<>();
	
	@Column(name="drug_type")
	private String drugType;
	
	@Column(name="phone")
	private String phone;
	
	@Transient
	private String dateOfBirthText;
	
		
	public Long getId(){
		return this.id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getMotherName(){
		return this.motherName;
	}

	public void setMotherName(String motherName){
		this.motherName = motherName;
	}

	public Long getNuProntuario(){
		return this.nuProntuario;
	}

	public void setNuProntuario(Long nuProntuario){
		this.nuProntuario = nuProntuario;
	}

	public String getNuCartSus(){
		return this.nuCartSus;
	}

	public void setNuCartSus(String nuCartSus){
		this.nuCartSus = nuCartSus;
	}

	public Calendar getDateOfBirth(){
		return this.dateOfBirth;
	}

	public void setdateOfBirth(Calendar dateOfBirth){
		this.dateOfBirth = dateOfBirth;		
	}

	public List<ScreeningDate> getScreeningDate() {
		return this.screeningDate;
	}

	public void setScreeningDate(List<ScreeningDate> screeningDate) {
		this.screeningDate = screeningDate;
	}

	public Address getAddress(){
		return this.address;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	public String getFileLocal() {
		return fileLocal;
	}

	public void setFileLocal(String fileLocal) {
		this.fileLocal = fileLocal;
	}

	public String getDrugType() {
		return drugType;
	}

	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDateOfBirthText() {
		return dateOfBirthText;
	}

	public void setDateOfBirthText(String dateOfBirthText) {
		this.dateOfBirthText = dateOfBirthText;
	}

	

	
}
