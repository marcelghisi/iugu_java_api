package com.iugu.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Address {

	// street	Rua
	private String street;
	
	// number	Número
	private String number;

	// city	Cidade
	private String city;
	
	//state	Estado (Ex: SP)
	private String state;
	
	//country	País
	private String country;
	
	//zip_code	CEP
	@JsonProperty("zip_code")
	private String zipCode;
	
	public Address(String street, String number, String city, String state, String country) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}



}
