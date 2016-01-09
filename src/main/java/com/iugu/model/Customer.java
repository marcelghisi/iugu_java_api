package com.iugu.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

public class Customer implements Serializable {

	private static final long serialVersionUID = 3266886175287194L;

	public Customer(String name,String email,String cpf) {
		this.name = name;
		this.email = email;
		this.cpfCnpj = cpf;
	}

	/**
	 * E-Mail do cliente
	 */
	private String id;
	
	/**
	 * E-Mail do cliente
	 */
	private String email;

	/**
	 * Nome do cliente
	 */
	private String name;

	/**
	 * cnpj/cpf do cliente
	 */
	@JsonProperty("cpf_cnpj")
	@SerializedName("cpf_cnpj")
	private String cpfCnpj;

	/**
	 * lista de emails que receberão cópias, em formato string separadas por
	 * vírgula
	 */
	@JsonProperty("cc_emails")
	@SerializedName("cc_emails")
	private String ccEmails;

	/**
	 * Anotações gerais do cliente
	 */
	private String notes;

	/**
	 * Variáveis personalizadas do cliente
	 */
	@JsonProperty("custom_variables")
	@SerializedName("custom_variables")
	private List<CustomVariable> customVariables;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public Customer withEmail(String email) {
		this.email = email;
		return this;
	}

	public String getName() {
		return name;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public Customer withCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
		return this;
	}

	public String getCcEmails() {
		return ccEmails;
	}

	public Customer withCcEmails(String ccEmails) {
		this.ccEmails = ccEmails;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public Customer withNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public List<CustomVariable> getCustomVariables() {
		return customVariables;
	}

	public Customer withCustomVariables(List<CustomVariable> customVariables) {
		this.customVariables = customVariables;

		return this;
	}

}
