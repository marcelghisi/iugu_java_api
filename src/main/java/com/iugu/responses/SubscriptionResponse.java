package com.iugu.responses;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.gson.annotations.SerializedName;
import com.iugu.model.PayableWith;
import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionResponse  extends MessageResponse{

	private String id;
	
	private Boolean suspended;
	
	@JsonProperty("plan_identifier")
	@SerializedName("plan_identifier")
	private String planIdentifier;
	
	@JsonProperty("price_cents")
	@SerializedName("price_cents")
	private Integer priceCents;
	
	private String currency;
	
	//TODO Features
	@JsonProperty("expires_at")
	@JsonFormat("yyyy-MM-dd'T'HH:mm:ssZ") 
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("expires_at")
	private Date expiresAt;
	
	@JsonProperty("customer_name")
	@SerializedName("customer_name")
	private String customerName;
	
	@JsonProperty("customer_email")
	@SerializedName("customer_email")
	private String customerEmail;
	
	@JsonProperty("payable_with")
	@SerializedName("payable_with")
	private PayableWith payableWith;
	
	@JsonProperty("cycled_at")
	@JsonFormat("yyyy-MM-dd'T'HH:mm:ssZ") 
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("cycled_at")
	private Date cycledAt;
	
	@JsonProperty("credits_min")
	@SerializedName("credits_min")
	private Integer creditsMin;
	
	@JsonProperty("credits_cycle")
	@SerializedName("credits_cycle")
	private Integer creditsCycle;
	
	//TODO Credits Cycle
	
	@JsonProperty("customer_id")
	@SerializedName("customer_id")
	private String customerId;
	
	
	
	@JsonProperty("plan_name")
	@SerializedName("plan_name")
	private String planName;
	
	@JsonProperty("customer_ref")
	@SerializedName("customer_ref")
	private String customerRef;
	
	@JsonProperty("plan_ref")
	@SerializedName("plan_ref")
	private String planRef;
	
	private Boolean active;
	
	@JsonProperty("in_trial")
	@SerializedName("in_trial")
	private Boolean inTrial;
	
	private Integer credits;
	
	@JsonProperty("credits_based")
	@SerializedName("credits_based")
	private Boolean creditsBased;
	
	//TODO Recent Invoices
	
	private List<SubItemResponse> subitems;
	
	private List<LogResponse> logs;
	
	@JsonProperty("custom_variables")
	@SerializedName("custom_variables")
	private List<CustomVariableResponse> customVariables;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getSuspended() {
		return suspended;
	}

	public void setSuspended(Boolean suspended) {
		this.suspended = suspended;
	}

	public String getPlanIdentifier() {
		return planIdentifier;
	}

	public void setPlanIdentifier(String planIdentifier) {
		this.planIdentifier = planIdentifier;
	}

	public Integer getPriceCents() {
		return priceCents;
	}

	public void setPriceCents(Integer priceCents) {
		this.priceCents = priceCents;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Date getCycledAt() {
		return cycledAt;
	}

	public void setCycledAt(Date cycledAt) {
		this.cycledAt = cycledAt;
	}

	public Integer getCreditsMin() {
		return creditsMin;
	}

	public void setCreditsMin(Integer creditsMin) {
		this.creditsMin = creditsMin;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getCustomerRef() {
		return customerRef;
	}

	public void setCustomerRef(String customerRef) {
		this.customerRef = customerRef;
	}

	public String getPlanRef() {
		return planRef;
	}

	public void setPlanRef(String planRef) {
		this.planRef = planRef;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getInTrial() {
		return inTrial;
	}

	public void setInTrial(Boolean inTrial) {
		this.inTrial = inTrial;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public Boolean getCreditsBased() {
		return creditsBased;
	}

	public void setCreditsBased(Boolean creditsBased) {
		this.creditsBased = creditsBased;
	}

	public List<SubItemResponse> getSubitems() {
		return subitems;
	}

	public void setSubitems(List<SubItemResponse> subitems) {
		this.subitems = subitems;
	}

	public List<LogResponse> getLogs() {
		return logs;
	}

	public void setLogs(List<LogResponse> logs) {
		this.logs = logs;
	}

	public List<CustomVariableResponse> getCustomVariables() {
		return customVariables;
	}

	public void setCustomVariables(List<CustomVariableResponse> customVariables) {
		this.customVariables = customVariables;
	}

	public Integer getCreditsCycle() {
		return creditsCycle;
	}

	public void setCreditsCycle(Integer creditsCycle) {
		this.creditsCycle = creditsCycle;
	}

	public PayableWith getPayableWith() {
		return payableWith;
	}

	public void setPayableWith(PayableWith payableWith) {
		this.payableWith = payableWith;
	}


}