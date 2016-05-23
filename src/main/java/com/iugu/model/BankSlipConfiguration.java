package com.iugu.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;
import com.iugu.model.MainSettingsConfiguration.Builder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BankSlipConfiguration implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1889955253520457088L;

	public BankSlipConfiguration() {
	}
	
	private Boolean active ;
	
	//Dias de vencimento extra no boleto ex: 2 
	@JsonProperty("extra_due")
	@SerializedName("extra_due")
	private Integer extraDue;

	//Dias de vencimento extra na segunda via do boleto ex: 2
	@JsonProperty("reprint_extra_due")
	@SerializedName("reprint_extra_due")
	private Integer reprintExtraDue;

	public static class Builder {
		
		//optional
		private Boolean active;
		private Integer extraDue;
		private Integer reprintExtraDue;
		
		public Builder() {

		}
		
		public Builder active(Boolean active) {
			  this.active = active;
			  return this;
		}
		
		public Builder extraDue(Integer extraDue) {
			  this.extraDue = extraDue;
			  return this;
		}
		
		public Builder reprintExtraDue(Integer reprintExtraDue) {
			  this.reprintExtraDue = reprintExtraDue;
			  return this;
		}
		
	    public BankSlipConfiguration build() {
	        return new BankSlipConfiguration(this);
	      }
	}
	
	private BankSlipConfiguration(Builder builder) {
		active = builder.active;
		extraDue = builder.extraDue;
		reprintExtraDue = builder.reprintExtraDue;
	}
	
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
