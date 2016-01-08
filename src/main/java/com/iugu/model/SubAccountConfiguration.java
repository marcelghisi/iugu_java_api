package com.iugu.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

public class SubAccountConfiguration implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1104777635090476555L;

	public SubAccountConfiguration(MainSettingsConfiguration mainConfiguration, BankSlipConfiguration bankSlipConfiguration,CreditCardConfiguration creditCardConfiguration) {
		
		this.commissionPercent = mainConfiguration.getCommissionPercent();
		this.autoWithdraw = mainConfiguration.getAutoWithdraw();
		this.fines = mainConfiguration.getFines();
		this.perDayInterest = mainConfiguration.getPerDayInterest();
		this.latePaymentFine = mainConfiguration.getLatePaymentFine();
		this.autoAdvance = mainConfiguration.getAutoAdvance();
		this.autoAdvanceType = mainConfiguration.getAutoAdvanceType();
		this.autoAdvanceOption = mainConfiguration.getAutoAdvanceOption();
		
		this.bankSlipConfiguration = bankSlipConfiguration;
		this.creditCardConfiguration = creditCardConfiguration;
	}
	
	@JsonProperty("commission_percent")
	@SerializedName("commission_percent")
	private Integer commissionPercent ;

	 
	@JsonProperty("auto_withdraw")
	@SerializedName("auto_withdraw")
	private Boolean autoWithdraw;

	private Boolean fines;
	
	@JsonProperty("per_day_interest")
	@SerializedName("per_day_interest")
	private Boolean perDayInterest;
	 
	@JsonProperty("late_payment_fine")
	@SerializedName("late_payment_fine")
	private Integer latePaymentFine;
	
	 
	@JsonProperty("auto_advance")
	@SerializedName("auto_advance")
	private Boolean autoAdvance;
	
	// 
	@JsonProperty("auto_advance_type")
	@SerializedName("auto_advance_type")
	private AutoAdvanceType autoAdvanceType;
	
	@JsonProperty("auto_advance_option")
	@SerializedName("auto_advance_option")
	private Integer autoAdvanceOption;
	
	@JsonProperty("bank_slip")
	@SerializedName("bank_slip")
	private BankSlipConfiguration bankSlipConfiguration;
	
	@JsonProperty("credit_card")
	@SerializedName("credit_card")
	private CreditCardConfiguration creditCardConfiguration;

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
