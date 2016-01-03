package com.iugu.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class SubAccountValidation implements Serializable {

	private static final long serialVersionUID = 5702980872056593546L;
	
	public SubAccountValidation(SubAccountValidationData data, SubAccountValidationFiles files,Boolean automaticBankValidation) {
		this.data = data;
		this.files = files;
		this.automaticValidation = automaticBankValidation;
	}
	
	/**
	 * Dados para validação da conta do cliente do MarketPlace
	 */
	private SubAccountValidationData data;
	
	/**
	 * Arquivos com imagens para RG,CPF e Comprovante de Atividade da Empresa.
	 */
	private SubAccountValidationFiles files;
	
	@JsonProperty("automatic_validation")
	private Boolean automaticValidation;

	public SubAccountValidationData getData() {
		return data;
	}

	public void setData(SubAccountValidationData data) {
		this.data = data;
	}

	public SubAccountValidationFiles getFiles() {
		return files;
	}

	public void setFiles(SubAccountValidationFiles files) {
		this.files = files;
	}

	public Boolean getAutomaticValidation() {
		return automaticValidation;
	}

	public void setAutomaticValidation(Boolean automaticValidation) {
		this.automaticValidation = automaticValidation;
	}

	
}
