package com.iugu.model;


public class PersonData {

	public PersonData(String cpf, String name,String phone) {
		this.cpf = cpf;
		this.personType = PersonType.PF;
		this.name = name;
		this.phone = phone;
	}
	
	// Cpf da Pessoa Física
	private String cpf;
	
	private PersonType personType = PersonType.PF;

	// Nome da Pessoa Física
	private String name;
	
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public PersonType getPersonType() {
		return personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	


}
