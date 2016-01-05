package com.iugu.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Configuration implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3354806240436811908L;

	/**
	 * Percentual de comissão pago para o marketplace
	 */
	@JsonProperty("commission_percent")
	private Integer comissionPercent;
	
	@JsonProperty("bank_slip")
	private BankSlipConfiguration bankSlipConfiguration;
	
	@JsonProperty("credit_card")
	private CreditCardConfiguration creditCardConfiguration;

	public Integer getComissionPercent() {
		return comissionPercent;
	}

	public void setComissionPercent(Integer comissionPercent) {
		this.comissionPercent = comissionPercent;
	}

	public BankSlipConfiguration getBankSlipConfiguration() {
		return bankSlipConfiguration;
	}

	public void setBankSlipConfiguration(BankSlipConfiguration bankSlipConfiguration) {
		this.bankSlipConfiguration = bankSlipConfiguration;
	}

	public CreditCardConfiguration getCreditCardConfiguration() {
		return creditCardConfiguration;
	}

	public void setCreditCardConfiguration(
			CreditCardConfiguration creditCardConfiguration) {
		this.creditCardConfiguration = creditCardConfiguration;
	}

	

}
