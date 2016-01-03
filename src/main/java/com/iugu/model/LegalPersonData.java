package com.iugu.model;


public class LegalPersonData {

	public LegalPersonData(String cnpj, String companyName, String nomeDoResponsavel, String cpfDoResponsavel, String phone) {
		this.cnpj = cnpj;
		this.personType = PersonType.PJ;
		this.companyName = companyName;
		this.nomeDoResponsavel = nomeDoResponsavel;
		this.cpfDoResponsavel = cpfDoResponsavel;
		this.phone = phone;
	}
	
	// number	Número
	private String cnpj;
	
	private PersonType personType = PersonType.PJ;

	// Nome da empresa
	private String companyName;
	
	// Nome do Responsavel pela empresa
	private String nomeDoResponsavel;

	//state	Estado (Ex: SP)
	private String cpfDoResponsavel;
	
	//Phone
	private String phone;



	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public PersonType getPersonType() {
		return personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getNomeDoResponsavel() {
		return nomeDoResponsavel;
	}

	public void setNomeDoResponsavel(String nomeDoResponsavel) {
		this.nomeDoResponsavel = nomeDoResponsavel;
	}

	public String getCpfDoResponsavel() {
		return cpfDoResponsavel;
	}

	public void setCpfDoResponsavel(String cpfDoResponsavel) {
		this.cpfDoResponsavel = cpfDoResponsavel;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
