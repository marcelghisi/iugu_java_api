package com.iugu.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class MainSettingsConfiguration implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4573329162336483984L;

	public MainSettingsConfiguration(Integer commissionPercent, Boolean autoWithdraw,Boolean fines,Boolean perDayInterest,Integer latePaymentFine,Boolean autoAdvance,AutoAdvanceType autoAdvanceType,Integer autoAdvanceOption) {
		this.commissionPercent = commissionPercent;
		this.autoWithdraw = autoWithdraw;
		this.fines = fines;
		this.perDayInterest = perDayInterest;
		this.latePaymentFine = latePaymentFine;
		this.autoAdvance = autoAdvance;
		this.autoAdvanceType = autoAdvanceType;
		this.autoAdvanceOption = autoAdvanceOption;	
	}
	
	private Integer commissionPercent ;

	private Boolean autoWithdraw;

	private Boolean fines;
	
	private Boolean perDayInterest;
	 
	private Integer latePaymentFine ;
	
	private Boolean autoAdvance;
	
	private AutoAdvanceType autoAdvanceType;
	
	private Integer autoAdvanceOption;

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
