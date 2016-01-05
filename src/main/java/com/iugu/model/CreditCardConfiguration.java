package com.iugu.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCardConfiguration implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5997460074767744638L;

	public CreditCardConfiguration() {
	}
	
	public CreditCardConfiguration(String softDescriptor, Boolean installments, Boolean installmentsPassInterest,Integer maxInstallments, Integer maxInstallmentsWithoutInterest,Boolean twoStepTransaction) {
		this.softDescriptor = softDescriptor;
		this.installments = installments;
		this.installmentsPassInterest = installmentsPassInterest;
		this.maxInstallments = maxInstallments;
		this.maxInstallmentsWithoutInterest = maxInstallmentsWithoutInterest;
		this.twoStepTransaction = twoStepTransaction;
	}
	
	private Boolean active;

	 
	//Descricao que aparece na fatura do cliente
	@JsonProperty("soft_descriptor")
	private String softDescriptor;
	
	//Parcelamento Ativo
	@JsonProperty("installments")
	private Boolean installments;
	 
	//Repasse de Juros de Parcelamento ativo? true ou false
	@JsonProperty("installments_pass_interest")
	private Boolean installmentsPassInterest;
	
	//Maxino de parcelas
	@JsonProperty("max_installments")
	private Integer maxInstallments;
	
	//Número de parcelas sem cobrança de juros ao cliente (Nr entre 1 a 12)
	@JsonProperty("max_installments_without_interest")
	private Integer maxInstallmentsWithoutInterest;
	
	// 
	@JsonProperty("two_step_transaction")
	private Boolean twoStepTransaction;

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getSoftDescriptor() {
		return softDescriptor;
	}

	public void setSoftDescriptor(String softDescriptor) {
		this.softDescriptor = softDescriptor;
	}

	public Boolean getInstallments() {
		return installments;
	}

	public void setInstallments(Boolean installments) {
		this.installments = installments;
	}

	public Boolean getInstallmentsPassInterest() {
		return installmentsPassInterest;
	}

	public void setInstallmentsPassInterest(Boolean installmentsPassInterest) {
		this.installmentsPassInterest = installmentsPassInterest;
	}

	public Integer getMaxInstallments() {
		return maxInstallments;
	}

	public void setMaxInstallments(Integer maxInstallments) {
		this.maxInstallments = maxInstallments;
	}

	public Integer getMaxInstallmentsWithoutInterest() {
		return maxInstallmentsWithoutInterest;
	}

	public void setMaxInstallmentsWithoutInterest(
			Integer maxInstallmentsWithoutInterest) {
		this.maxInstallmentsWithoutInterest = maxInstallmentsWithoutInterest;
	}

	public Boolean getTwoStepTransaction() {
		return twoStepTransaction;
	}

	public void setTwoStepTransaction(Boolean twoStepTransaction) {
		this.twoStepTransaction = twoStepTransaction;
	}

	
}
