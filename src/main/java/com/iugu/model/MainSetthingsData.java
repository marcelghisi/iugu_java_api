package com.iugu.model;


public class MainSetthingsData {

	public MainSetthingsData(String businessDescription,SubAccountPriceRange priceRange,Boolean physicalProducts, Boolean automaticTransfer) {
		this.businessDescription = businessDescription;
		this.priceRange = priceRange;
		this.physicalProducts = physicalProducts;
		this.automaticTransfer = automaticTransfer;
	}
	
	// Descrição do Negócio
	private String businessDescription;
	
	//Price Range will be praticed
	private SubAccountPriceRange priceRange;

	// Vende produtos físicos
	private Boolean physicalProducts;
	
	// Faz a transferencia automatica
	private Boolean automaticTransfer;

	public String getBusinessDescription() {
		return businessDescription;
	}

	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}

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

	public Boolean getAutomaticTransfer() {
		return automaticTransfer;
	}

	public void setAutomaticTransfer(Boolean automaticTransfer) {
		this.automaticTransfer = automaticTransfer;
	}


}
