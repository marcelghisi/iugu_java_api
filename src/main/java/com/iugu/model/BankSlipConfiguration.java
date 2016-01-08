package com.iugu.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BankSlipConfiguration implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1889955253520457088L;

	public BankSlipConfiguration() {
	}
	
	public BankSlipConfiguration(Boolean active, Integer extraDue,Integer reprintExtraDue) {
		this.active = active;
		this.extraDue = extraDue;
		this.reprintExtraDue = reprintExtraDue;
	}
	
	private Boolean active ;
	 
	@JsonProperty("extra_due")
	@SerializedName("extra_due")
	private Integer extraDue;
	
	@JsonProperty("reprint_extra_due")
	@SerializedName("reprint_extra_due")
	private Integer reprintExtraDue;

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getExtraDue() {
		return extraDue;
	}

	public void setExtraDue(Integer extraDue) {
		this.extraDue = extraDue;
	}

	public Integer getReprintExtraDue() {
		return reprintExtraDue;
	}

	public void setReprintExtraDue(Integer reprintExtraDue) {
		this.reprintExtraDue = reprintExtraDue;
	}
	 

	 
}
