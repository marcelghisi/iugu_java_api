package com.iugu.model;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

public class Payer {

	// CPF ou CNPJ do Cliente
	
	@JsonProperty("cpf_cnpj")
	@SerializedName("cpf_cnpj")
	private String cpfCNPJ;
	
	// name	Nome (utilizado como sacado no boleto)
	private String name;

	//phone_prefix	Prefixo do Telefone (Ex: 11 para São Paulo)
	@JsonProperty("phone_prefix")
	@SerializedName("phone_prefix")
	private String phonePrefix;
	
	//phone	Telefone
	private String phone;
	
	//email	E-mail do Cliente
	private String email;
	
	
	//address{}	Endereço do Cliente (utilizado no boleto)
	private Address address;

	public Payer(String cpfCNPJ, String name, String phonePrefix, String phone, String email,
			Address address) {
		this.name = name;
		this.cpfCNPJ = cpfCNPJ;
		this.phonePrefix = phonePrefix;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}


	public String getCpfCNPJ() {
		return cpfCNPJ;
	}


	public void setCpfCNPJ(String cpfCNPJ) {
		this.cpfCNPJ = cpfCNPJ;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonePrefix() {
		return phonePrefix;
	}

	public void setPhonePrefix(String phonePrefix) {
		this.phonePrefix = phonePrefix;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}



}
