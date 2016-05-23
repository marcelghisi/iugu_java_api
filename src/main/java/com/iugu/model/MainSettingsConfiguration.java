package com.iugu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.iugu.model.TokenDirectCharge.Builder;

public class MainSettingsConfiguration implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4573329162336483984L;

	private Integer commissionPercent ;
	
	private Boolean autoWithdraw;
	
	//Cobrar Multas TRUE FALSE
	private Boolean fines;
	
	//Cobrar Juros de Mora? TRUE FALSE
	private Boolean perDayInterest;
	
	//Valor da multa em Percentual inteiro
	private Integer latePaymentFine ;
	
	//Antecipação automatica Precisa habilitar para usar
	private Boolean autoAdvance;
	
	//Periodicidade da antecipacao automatica
	private AutoAdvanceType autoAdvanceType;
	
	//Dependendo da periodicidade o aplicase o melhor dia para pagamento
	private Integer autoAdvanceOption;

	public static class Builder {
		
		//optional
		private Integer commissionPercent;
		private Boolean autoWithdraw;
		private Boolean fines;
		private Boolean perDayInterest;
		private Integer latePaymentFine;
		private Boolean autoAdvance;
		private AutoAdvanceType autoAdvanceType;
		private Integer autoAdvanceOption;
		
		public Builder() {

		}
		
		public Builder commission(Integer percent) {
		  this.commissionPercent = percent;
		  return this;
		}

		public Builder autoWithdraw(Boolean autoWithdraw) {
			  this.autoWithdraw = autoWithdraw;
			  return this;
		}
		
		public Builder fines(Boolean fines) {
			  this.fines = fines;
			  return this;
		}
		
		public Builder perDayInterest(Boolean perDayInterest) {
			  this.perDayInterest = perDayInterest;
			  return this;
		}

		public Builder latePaymentFine(Integer latePaymentFine) {
			  this.latePaymentFine = latePaymentFine;
			  return this;
		}
		
		public Builder autoAdvance(Boolean autoAdvance) {
			  this.autoAdvance = autoAdvance;
			  return this;
		}
		
		public Builder autoAdvanceType(AutoAdvanceType autoAdvanceType) {
			  this.autoAdvanceType = autoAdvanceType;
			  return this;
		}
		
		public Builder autoAdvanceOption(Integer autoAdvanceOption) {
			  this.autoAdvanceOption = autoAdvanceOption;
			  return this;
		}
		
	    public MainSettingsConfiguration build() {
	        return new MainSettingsConfiguration(this);
	      }
	}
	
	private MainSettingsConfiguration(Builder builder) {
		commissionPercent = builder.commissionPercent;
		autoWithdraw = builder.autoWithdraw;
		fines = builder.fines;
		perDayInterest = builder.perDayInterest;
		latePaymentFine = builder.latePaymentFine;
		autoAdvance = builder.autoAdvance;
		autoAdvanceType = builder.autoAdvanceType;
		autoAdvanceOption = builder.autoAdvanceOption;
	}
	
	public Integer getCommissionPercent() {
		return commissionPercent;
	}

	public void setCommissionPercent(Integer commissionPercent) {
		this.commissionPercent = commissionPercent;
	}

	public Boolean getAutoWithdraw() {
		return autoWithdraw;
	}

	public void setAutoWithdraw(Boolean autoWithdraw) {
		this.autoWithdraw = autoWithdraw;
	}

	public Boolean getFines() {
		return fines;
	}

	public void setFines(Boolean fines) {
		this.fines = fines;
	}

	public Boolean getPerDayInterest() {
		return perDayInterest;
	}

	public void setPerDayInterest(Boolean perDayInterest) {
		this.perDayInterest = perDayInterest;
	}

	public Integer getLatePaymentFine() {
		return latePaymentFine;
	}

	public void setLatePaymentFine(Integer latePaymentFine) {
		this.latePaymentFine = latePaymentFine;
	}

	public Boolean getAutoAdvance() {
		return autoAdvance;
	}

	public void setAutoAdvance(Boolean autoAdvance) {
		this.autoAdvance = autoAdvance;
	}

	public AutoAdvanceType getAutoAdvanceType() {
		return autoAdvanceType;
	}

	public void setAutoAdvanceType(AutoAdvanceType autoAdvanceType) {
		this.autoAdvanceType = autoAdvanceType;
	}

	public Integer getAutoAdvanceOption() {
		return autoAdvanceOption;
	}

	public void setAutoAdvanceOption(Integer autoAdvanceOption) {
		this.autoAdvanceOption = autoAdvanceOption;
	}
	
	
	 
}
