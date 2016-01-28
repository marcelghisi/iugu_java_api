package com.iugu.model;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.gson.annotations.SerializedName;
import com.iugu.responses.SubscriptionResponse;
import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription {

	private SubscriptionResponse response;
	
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
	
	@JsonProperty("suspended")
	@SerializedName("suspended")
	public Boolean suspended;

	@JsonProperty("payable_with")
	@SerializedName("payable_with")
	public String payableWith;

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
		private Boolean suspended; 
		private SubscriptionResponse response;
		
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
		
		public Builder suspended (Boolean suspended) {
			  this.suspended = suspended;
			  return this;
		}
		
		public Builder response (SubscriptionResponse response) {
			  this.response = response;
			  return this;
		}
		
	    public Subscription build() {
	        return new Subscription(this);
	      }
	}
	
	private Subscription(Builder builder) {
		
		if (planIdentifier != null && creditsBased != null && creditsBased == Boolean.TRUE) {
			  throw new IllegalStateException("No Identifier for credit based subscriptios"); 
		}
		
		String planIdentifierI = (response == null) ? builder.planIdentifier : response.getPlanIdentifier();
		Integer credCycle = (response == null) ? builder.creditsCycle : response.getCreditsCycle();
		Integer credMin = (response == null) ? builder.creditsMin : response.getCreditsMin();
		Boolean credBased = (response == null) ? builder.creditsBased : response.getCreditsBased();
		Integer price = (response == null) ? builder.priceCents : response.getPriceCents();
		Boolean suspendido = (response == null) ? builder.suspended : response.getSuspended();
		PayableWith payable = (response == null ) ? builder.payableWith : response.getPayableWith();
		
		customerId = builder.customerId;
		planIdentifier = (planIdentifierI == null) ? null : planIdentifierI;
		creditsCycle = (credCycle == null) ? null : credCycle;
		creditsMin = (credMin == null) ? null : credMin;
		creditsBased = (credBased == null) ? null : credBased;
		priceCents = (price == null) ? null : price;
		suspended = (suspendido == null) ? null : suspendido;
		payableWith = (payable == null) ? null : payable.getValue();

		expiresAt = builder.expiresAt;
		onlyOnChargeSucess = builder.onlyOnChargeSuccess;
		customVariables = builder.customVariables == null ? null : builder.customVariables;
		subItems = builder.subItems == null ? null : builder.subItems;

		
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



	public String getPayableWith() {
		return payableWith;
	}

	public void setPayableWith(String payableWith) {
		this.payableWith = payableWith;
	}

	public Boolean isCreditsBased() {
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

	public Boolean getSuspended() {
		return suspended;
	}

	public void setSuspended(Boolean suspended) {
		this.suspended = suspended;
	}
	
	
}
