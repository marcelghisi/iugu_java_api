package com.iugu.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;
import com.iugu.model.BankSlipConfiguration.Builder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCardConfiguration implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5997460074767744638L;

	public CreditCardConfiguration() {
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
	
	//Habilita fluxo de pagamento em 2 etapas
	//Bloqueia o valor no cartao e coloca o status da fatura em analise
	//Utilizar o metodo captura em analise no maximo em 4 dias para receber definitivamente a grana antes do cancelamento
	@JsonProperty("two_step_transaction")
	@SerializedName("two_step_transaction")
	private Boolean twoStepTransaction;

	public static class Builder {
		
		private Boolean active;
		private String 	softDescriptor;
		private Boolean installments;
		private Boolean installmentsPassInterest;
		private Integer maxInstallments;
		private Integer maxInstallmentsWithoutInterest;
		private Boolean twoStepTransaction;
		
		
		public Builder() {

		}
		
		public Builder active(Boolean active) {
			  this.active = active;
			  return this;
		}
		
		public Builder softDescriptor(String softDescriptor) {
			  this.softDescriptor = softDescriptor;
			  return this;
		}
		
		public Builder installments(Boolean installments) {
			  this.installments = installments;
			  return this;
		}

		public Builder installmentsPassInterest(Boolean installmentsPassInterest) {
			  this.installmentsPassInterest = installmentsPassInterest;
			  return this;
		}
		
		public Builder maxInstallments(Integer maxInstallments) {
			  this.maxInstallments = maxInstallments;
			  return this;
		}

		public Builder maxInstallmentsWithoutInterest(Integer maxInstallmentsWithoutInterest) {
			  this.maxInstallmentsWithoutInterest = maxInstallmentsWithoutInterest;
			  return this;
		}
		
		public Builder twoStepTransaction(Boolean twoStepTransaction) {
			  this.twoStepTransaction = twoStepTransaction;
			  return this;
		}
		
	    public CreditCardConfiguration build() {
	        return new CreditCardConfiguration(this);
	      }
	}
	
	private CreditCardConfiguration(Builder builder) {
		active = builder.active;
		softDescriptor = builder.softDescriptor;
		installments = builder.installments;
		installmentsPassInterest = builder.installmentsPassInterest;
		maxInstallments = builder.maxInstallments;
		maxInstallmentsWithoutInterest = builder.maxInstallmentsWithoutInterest;
		twoStepTransaction = builder.twoStepTransaction;
	}
	
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
