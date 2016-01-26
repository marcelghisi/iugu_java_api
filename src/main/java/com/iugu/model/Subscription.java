package com.iugu.model;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.gson.annotations.SerializedName;
import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription {

	@JsonProperty("customer_id")
	@SerializedName("customer_id")
	private String customerId;

	@JsonProperty("plan_identifier")
	@SerializedName("plan_identifier")
	public String planIdentifier;

	@JsonFormat("yyyy-MM-dd") 
	@JsonSerialize(using = DateSerializer.class)
	@JsonProperty("expires_at")
	@SerializedName("expires_at")
	public Date expiresAt;

	@JsonProperty("only_on_charge_sucess")
	@SerializedName("only_on_charge_sucess")
	public String onlyOnChargeSucess;

	@JsonProperty("payable_with")
	@SerializedName("payable_with")
	public PayableWith payableWith;

	@JsonProperty("credits_based")
	@SerializedName("credits_based")
	public Boolean creditsBased;

	@JsonProperty("price_cents")
	@SerializedName("price_cents")
	public Integer priceCents;

	@JsonProperty("credits_cycle")
	@SerializedName("credits_cycle")
	public Integer creditsCycle;

	@JsonProperty("credits_min")
	@SerializedName("credits_min")
	public Integer creditsMin;

	@JsonProperty("custom_variables")
	@SerializedName("custom_variables")
	public List<CustomVariable> customVariables;

	@JsonProperty("subitems")
	@SerializedName("subitems")
	public List<SubItem> subItems;

	public static class Builder {
		//required
		private String customerId;
		
		//optional
		private String planIdentifier;
		private Date expiresAt;
		private String onlyOnChargeSuccess;
		private PayableWith payableWith;
		private Boolean creditsBased;
		private Integer priceCents;
		private Integer creditsCycle;
		private Integer creditsMin;
		private List<CustomVariable> customVariables;
		private List<SubItem> subItems;
		 
		
		public Builder(String customerId) {
		  this.customerId = customerId;
		}
		
		public Builder planIdentifier(String identifier) {
		  this.planIdentifier = identifier;
		  return this;
		}
		
		public Builder expiresAt(Date date) {
			  this.expiresAt = date;
			  return this;
		}
		
		public Builder initOnlyOnChargeSuccess(String onlyIfCharge) {
			  this.onlyOnChargeSuccess = onlyIfCharge;
			  return this;
		}
		
		public Builder payableWith(PayableWith payableWith) {
			  this.payableWith = payableWith;
			  return this;
		}
		
		public Builder creditsBased(Boolean basedInCredits) {
			  this.creditsBased = basedInCredits;
			  return this;
		}
		
		public Builder priceInCents(Integer priceCents) {
			  this.priceCents = priceCents;
			  return this;
		}
		
		public Builder creditsCycle (Integer numberCreditsByCycle) {
			  this.creditsCycle = numberCreditsByCycle;
			  return this;
		}
		
		public Builder creditsCycleStartAt (Integer creditsMinToStart) {
			  this.creditsMin = creditsMinToStart;
			  return this;
		}
		
		public Builder items (List<SubItem> items) {
			  this.subItems = items;
			  return this;
		}
		
		public Builder customVariables (List<CustomVariable> customVariables) {
			  this.customVariables = customVariables;
			  return this;
		}
		
	    public Subscription build() {
	        return new Subscription(this);
	      }
	}
	
	private Subscription(Builder builder) {
		customerId = builder.customerId;
		planIdentifier = builder.planIdentifier;
		expiresAt = builder.expiresAt;
		onlyOnChargeSucess = builder.onlyOnChargeSuccess;
		payableWith = builder.payableWith;
		creditsBased = (builder.creditsBased == null) ? Boolean.FALSE : builder.creditsBased;
		priceCents = builder.priceCents == null ? null : builder.priceCents;
		creditsCycle = builder.creditsCycle == null ? null : builder.creditsCycle;
		creditsMin = builder.creditsMin == null ? null : builder.creditsMin;
		customVariables = builder.customVariables == null ? null : builder.customVariables;
		subItems = builder.subItems == null ? null : builder.subItems;
		
		if (planIdentifier != null && creditsBased != null && creditsBased == Boolean.TRUE) {
			  throw new IllegalStateException("No Identifier for credit based subscriptios"); 
		}
		
	}
	
	public String getPlanIdentifier() {
		return planIdentifier;
	}

	public void setPlanIdentifier(String planIdentifier) {
		this.planIdentifier = planIdentifier;
	}

	public String getCustomerId() {
		return customerId;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public String getOnlyOnChargeSucess() {
		return onlyOnChargeSucess;
	}

	public void setOnlyOnChargeSucess(String onlyOnChargeSucess) {
		this.onlyOnChargeSucess = onlyOnChargeSucess;
	}

	public PayableWith getPayableWith() {
		return payableWith;
	}

	public void setPayableWith(PayableWith payableWith) {
		this.payableWith = payableWith;
	}

	public boolean isCreditsBased() {
		return creditsBased;
	}

	public void setCreditsBased(boolean creditsBased) {
		this.creditsBased = creditsBased;
	}

	public Integer getPriceCents() {
		return priceCents;
	}

	public void setPriceCents(Integer priceCents) {
		this.priceCents = priceCents;
	}

	public Integer getCreditsCycle() {
		return creditsCycle;
	}

	public void setCreditsCycle(Integer creditsCycle) {
		this.creditsCycle = creditsCycle;
	}

	public Integer getCreditsMin() {
		return creditsMin;
	}

	public void setCreditsMin(Integer creditsMin) {
		this.creditsMin = creditsMin;
	}

	public List<CustomVariable> getCustomVariables() {
		return customVariables;
	}

	public void setCustomVariables(List<CustomVariable> customVariables) {
		this.customVariables = customVariables;
	}

	public List<SubItem> getSubItems() {
		return subItems;
	}

	public void setSubItems(List<SubItem> subItems) {
		this.subItems = subItems;
	}
}
