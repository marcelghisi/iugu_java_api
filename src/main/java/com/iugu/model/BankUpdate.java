package com.iugu.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.jboss.resteasy.util.Base64;


public class BankUpdate {

	public BankUpdate(BankNumber bankNumber, AccountType accountType,String agencyNumber,String accountNumber,byte[] document,Boolean automaticValidation) {
		this.bank = bankNumber;
		this.accountType = accountType;
		this.agency = agencyNumber;
		this.account = accountNumber;
		this.document = Base64.encodeBytes( document ); 
		this.automaticValidation = automaticValidation;
	}
	
	public BankUpdate(BankNumber bankNumber, AccountType accountType,String agencyNumber,String accountNumber,String documentBase64,Boolean automaticValidation) {
		this.bank = bankNumber;
		this.accountType = accountType;
		this.agency = agencyNumber;
		this.account = accountNumber;
		this.document = documentBase64; 
		this.automaticValidation = automaticValidation;
	}

	// Número da Agência
	private String agency;
	
	// Número da Agência
	private String account;

	// Cpf da Pessoa Física
	private BankNumber bank;
	
	// Tipo da conta
	@JsonProperty("account_type")
	private AccountType accountType;
	
	//Base64
	private String document;	
	
	@JsonProperty("automatic_validation")
	private Boolean automaticValidation;

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public BankNumber getBank() {
		return bank;
	}

	public void setBank(BankNumber bank) {
		this.bank = bank;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Boolean getAutomaticValidation() {
		return automaticValidation;
	}

	public void setAutomaticValidation(Boolean automaticValidation) {
		this.automaticValidation = automaticValidation;
	}


}
