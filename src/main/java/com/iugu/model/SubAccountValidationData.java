package com.iugu.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class SubAccountValidationData {


	//Construtor Pessoa Jurídica
	public SubAccountValidationData(MainSetthingsData mainSettingsData,BankInformation bankInformation,Address address,LegalPersonData pessoaJuridica) {
		
		this.businessType = mainSettingsData.getBusinessDescription();
		this.priceRange = mainSettingsData.getPriceRange();
		this.physicalProducts = mainSettingsData.getPhysicalProducts();
		this.automaticTransfer = mainSettingsData.getAutomaticTransfer();
		
		this.accountType = bankInformation.getAccountType();
		this.bank = bankInformation.getBank();
		this.bankAgencyNumber = bankInformation.getAgencyNumber();
		this.bankAccountNumber = bankInformation.getAccountNumber();
		
		this.address = address.getStreet();
		this.cep = address.getZipCode();
		this.city = address.getCity();
		this.state = address.getState();
		
		this.personType = pessoaJuridica.getPersonType();
		this.cnpj = pessoaJuridica.getCnpj();
		this.companyName = pessoaJuridica.getCompanyName();
		this.cpfResponsavel = pessoaJuridica.getCpfDoResponsavel();
		this.nameResponsavel = pessoaJuridica.getNomeDoResponsavel();
		this.telephone = pessoaJuridica.getPhone();
	}
	
	//Construtor Pessoa Física
	public SubAccountValidationData(MainSetthingsData mainSettingsData,BankInformation bankInformation,Address address,PersonData pessoaFisica) {
		
		
		this.businessType = mainSettingsData.getBusinessDescription();
		this.priceRange = mainSettingsData.getPriceRange();
		this.physicalProducts = mainSettingsData.getPhysicalProducts();
		this.automaticTransfer = mainSettingsData.getAutomaticTransfer();
		
		this.accountType = bankInformation.getAccountType();
		this.bank = bankInformation.getBank();
		this.bankAgencyNumber = bankInformation.getAgencyNumber();
		this.bankAccountNumber = bankInformation.getAccountNumber();
		
		this.address = address.getStreet();
		this.cep = address.getZipCode();
		this.city = address.getCity();
		this.state = address.getState();
		
		this.personType = pessoaFisica.getPersonType();
		this.cpf = pessoaFisica.getCpf();
		this.name = pessoaFisica.getName();
		this.telephone = pessoaFisica.getPhone();
	}
	
	//Range de preços que a conta utilizará nas tranzações
	//Ex: Valor máximo da venda ('Até R$ 100,00', 'Entre R$ 100,00 e R$ 500,00', 'Mais que R$ 500,00')
	@JsonProperty("price_range")
	private SubAccountPriceRange priceRange;

	
	@JsonProperty("physical_products")
	private Boolean physicalProducts;

	//Descrição do negócio da conta
	@JsonProperty("business_type")
	private String businessType;
	
	//Descrição do negócio da conta
	@JsonProperty("person_type")
	private PersonType personType;
	
	//Saque automático (Recomendamos que envie 'true')
	@JsonProperty("automatic_transfer")
	private Boolean automaticTransfer;
	
	private String cpf;
	
	
	private String name;
	
	private String cnpj;
	
	@JsonProperty("company_name")
	private String companyName;
	
	@JsonProperty("resp_cpf")
	private String cpfResponsavel;
	
	@JsonProperty("resp_name")
	private String nameResponsavel;

	private String address;
	
	private String cep;
	
	private String city;
	
	private String state;
	
	private String telephone;
	
	private Bank bank;
	
	@JsonProperty("bank_ag")
	private String bankAgencyNumber;
	
	@JsonProperty("account_type")
	private AccountType accountType;
	
	@JsonProperty("bank_cc")
	private String bankAccountNumber;
	
	@JsonProperty("document_id")
	private String rgId;
	
	@JsonProperty("document_cpf")
	private String documentCpfId;
	
	@JsonProperty("document_activity")
	private String documentActivityId;

	public SubAccountPriceRange getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(SubAccountPriceRange priceRange) {
		this.priceRange = priceRange;
	}

	public Boolean getPhysicalProducts() {
		return physicalProducts;
	}

	public void setPhysicalProducts(Boolean physicalProducts) {
		this.physicalProducts = physicalProducts;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public PersonType getPersonType() {
		return personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}

	public Boolean getAutomaticTransfer() {
		return automaticTransfer;
	}

	public void setAutomaticTransfer(Boolean automaticTransfer) {
		this.automaticTransfer = automaticTransfer;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	

	public String getCpfResponsavel() {
		return cpfResponsavel;
	}

	public void setCpfResponsavel(String cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}
	
	

	public String getNameResponsavel() {
		return nameResponsavel;
	}

	public void setNameResponsavel(String nameResponsavel) {
		this.nameResponsavel = nameResponsavel;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getBankAgencyNumber() {
		return bankAgencyNumber;
	}

	public void setBankAgencyNumber(String bankAgencyNumber) {
		this.bankAgencyNumber = bankAgencyNumber;
	}


	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getRgId() {
		return rgId;
	}

	public void setRgId(String rgId) {
		this.rgId = rgId;
	}

	public String getDocumentCpfId() {
		return documentCpfId;
	}

	public void setDocumentCpfId(String documentCpfId) {
		this.documentCpfId = documentCpfId;
	}

	public String getDocumentActivityId() {
		return documentActivityId;
	}

	public void setDocumentActivityId(String documentActivityId) {
		this.documentActivityId = documentActivityId;
	}

	
}
