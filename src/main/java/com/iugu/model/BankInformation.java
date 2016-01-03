package com.iugu.model;


public class BankInformation {

	public BankInformation(Bank bank, AccountType accountType,String agencyNumber,String accountNumber) {
		this.bank = bank;
		this.accountType = accountType;
		this.agencyNumber = agencyNumber;
		this.accountNumber = accountNumber;
	}
	
	// Cpf da Pessoa Física
	private Bank bank;
	
	// Tipo da conta
	private AccountType accountType;
	
	// Número da Agência
	private String agencyNumber;
	
	// Número da Agência
	private String accountNumber;

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getAgencyNumber() {
		return agencyNumber;
	}

	public void setAgencyNumber(String agencyNumber) {
		this.agencyNumber = agencyNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



}
