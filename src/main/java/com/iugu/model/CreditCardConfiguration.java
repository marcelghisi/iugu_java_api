package com.iugu.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCardConfiguration implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5997460074767744638L;

	public CreditCardConfiguration() {
	}
	
	public CreditCardConfiguration(Boolean active,String softDescriptor, Boolean installments, Boolean installmentsPassInterest,Integer maxInstallments, Integer maxInstallmentsWithoutInterest,Boolean twoStepTransaction) {
		this.active = active;
		this.softDescriptor = softDescriptor;
		//Parcelamento ativo
		this.installments = installments;
		//Repassar juros do parcelamento?
		this.installmentsPassInterest = installmentsPassInterest;
		//Maximo de parcelas aceitas
		this.maxInstallments = maxInstallments;
		//Numero de parcelas sem cobranca de juros
		this.maxInstallmentsWithoutInterest = maxInstallmentsWithoutInterest;
		//Habilita fluxo de pagamento em 2 etapas
		//Bloqueia o valor no cartao e coloca o status da fatura em analise
		//Utilizar o metodo captura em analise no maximo em 4 dias para receber definitivamente a grana antes do cancelamento
		this.twoStepTransaction = twoStepTransaction;
	}
	
	//Cartao Ativo 
	@SerializedName("active")
	private Boolean active;

	 
	//Descricao que aparece na fatura do cliente
	@JsonProperty("soft_descriptor")
	@SerializedName("soft_descriptor")
	private String softDescriptor;
	
	//Parcelamento Ativo
	private Boolean installments;
	 
	//Repasse de Juros de Parcelamento ativo? true ou false
	@JsonProperty("installments_pass_interest")
	@SerializedName("installments_pass_interest")
	private Boolean installmentsPassInterest;
	
	//Maxino de parcelas
	@JsonProperty("max_installments")
	@SerializedName("max_installments")
	private Integer maxInstallments;
	
	//Número de parcelas sem cobrança de juros ao cliente (Nr entre 1 a 12)
	@JsonProperty("max_installments_without_interest")
	@SerializedName("max_installments_without_interest")
	private Integer maxInstallmentsWithoutInterest;
	
	// 
	@JsonProperty("two_step_transaction")
	@SerializedName("two_step_transaction")
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
