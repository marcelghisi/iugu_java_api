package com.iugu.responses;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.iugu.model.Configuration;
import com.iugu.model.SubAccountValidationData;
import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;
import com.iugu.serializers.PropertyMapDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubAccountInformationResponse extends MessageResponse{

	//Codigo da verificacao
	private String id;
	
	private String name;
		
	@JsonProperty("created_at")
	@JsonFormat("dd/MM/yyyy")
	@JsonSerialize(using = DateSerializer.class)
	private Date createdAt;
	
	@JsonProperty("updated_at")
	@JsonFormat("dd/MM/yyyy")
	@JsonSerialize(using = DateSerializer.class)
	private Date updatedAt;
	
	@JsonProperty("can_receive")
	private Boolean canReceive;
	
	/*
	/	    "can_receive?": false,
    "is_verified?": false,
	*/
	//
	@JsonProperty("is_verified")
	private Boolean isVerified;
	
	
	@JsonProperty("last_verification_request_status")
	private String lastVerificationRequestStatus;

	@JsonProperty("last_verification_request_data")
	private SubAccountValidationData lastVerificationRequestData;
	
	@JsonProperty("last_verification_request_feedback")
	private String lastVerificationRequestFeedback;

	@JsonProperty("change_plan_type")
	private Integer changePlanType;
	
	@JsonProperty("subscriptions_trial_period")
	private Integer subscriptionsTrialPeriod;
	
	@JsonProperty("disable_emails")
	private Boolean disableEmails;
	
	//Ultimo saque
	@JsonProperty("last_withdraw")
	private Integer lastWithdraw;//TODO Perguntar Cents?

	@JsonProperty("total_subscriptions")
	private Integer totalSubscriptions;
	
	@JsonProperty("reply_to")
	private String replyTo;
	
	@JsonProperty("webapp_on_test_mode")
	private Boolean webappOnTestMode;
	
	private Boolean marketplace;
	
	//Saque automatico
	@JsonProperty("auto_withdraw")
	private Boolean autoWithdraw;
	
	private String balance;
	
	@JsonProperty("protected_balance")
	private String protectedBalance;	

	@JsonProperty("payable_balance")
	private String payableBalance;
	
	@JsonProperty("commission_balance")
	private String commissionBalance;
	
	@JsonProperty("volume_last_month")
	private String volumeLastMonth;
	
	@JsonProperty("volume_this_month")
	private String volumeThisMonth;
	
	@JsonProperty("taxes_paid_last_month")
	private String taxesPaidLastMonth;
	
	@JsonProperty("taxes_paid_this_month")
	private String taxesPaidThisMonth;
	
	@JsonProperty("volume_this_month")
	private String volume_this_month;
	
	@JsonProperty("custom_logo_url")
	private String customLogoUrl;
	
	@JsonProperty("custom_logo_small_url")
	private String customLogoSmallUrl;
	
    public List<Map<String, String>> informations; 
    
    private Configuration configuration;
    

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getCanReceive() {
		return canReceive;
	}

	public void setCanReceive(Boolean canReceive) {
		this.canReceive = canReceive;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getLastVerificationRequestStatus() {
		return lastVerificationRequestStatus;
	}

	public void setLastVerificationRequestStatus(
			String lastVerificationRequestStatus) {
		this.lastVerificationRequestStatus = lastVerificationRequestStatus;
	}

	public SubAccountValidationData getLastVerificationRequestData() {
		return lastVerificationRequestData;
	}

	public void setLastVerificationRequestData(
			SubAccountValidationData lastVerificationRequestData) {
		this.lastVerificationRequestData = lastVerificationRequestData;
	}

	public String getLastVerificationRequestFeedback() {
		return lastVerificationRequestFeedback;
	}

	public void setLastVerificationRequestFeedback(
			String lastVerificationRequestFeedback) {
		this.lastVerificationRequestFeedback = lastVerificationRequestFeedback;
	}

	public Integer getChangePlanType() {
		return changePlanType;
	}

	public void setChangePlanType(Integer changePlanType) {
		this.changePlanType = changePlanType;
	}

	public Integer getSubscriptionsTrialPeriod() {
		return subscriptionsTrialPeriod;
	}

	public void setSubscriptionsTrialPeriod(Integer subscriptionsTrialPeriod) {
		this.subscriptionsTrialPeriod = subscriptionsTrialPeriod;
	}

	public Boolean getDisableEmails() {
		return disableEmails;
	}

	public void setDisableEmails(Boolean disableEmails) {
		this.disableEmails = disableEmails;
	}

	public Integer getLastWithdraw() {
		return lastWithdraw;
	}

	public void setLastWithdraw(Integer lastWithdraw) {
		this.lastWithdraw = lastWithdraw;
	}

	public Integer getTotalSubscriptions() {
		return totalSubscriptions;
	}

	public void setTotalSubscriptions(Integer totalSubscriptions) {
		this.totalSubscriptions = totalSubscriptions;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public Boolean getWebappOnTestMode() {
		return webappOnTestMode;
	}

	public void setWebappOnTestMode(Boolean webappOnTestMode) {
		this.webappOnTestMode = webappOnTestMode;
	}

	public Boolean getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(Boolean marketplace) {
		this.marketplace = marketplace;
	}

	public Boolean getAutoWithdraw() {
		return autoWithdraw;
	}

	public void setAutoWithdraw(Boolean autoWithdraw) {
		this.autoWithdraw = autoWithdraw;
	}

	
	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getProtectedBalance() {
		return protectedBalance;
	}

	public void setProtectedBalance(String protectedBalance) {
		this.protectedBalance = protectedBalance;
	}

	public String getPayableBalance() {
		return payableBalance;
	}

	public void setPayableBalance(String payableBalance) {
		this.payableBalance = payableBalance;
	}

	public String getCommissionBalance() {
		return commissionBalance;
	}

	public void setCommissionBalance(String commissionBalance) {
		this.commissionBalance = commissionBalance;
	}

	public String getVolumeLastMonth() {
		return volumeLastMonth;
	}

	public void setVolumeLastMonth(String volumeLastMonth) {
		this.volumeLastMonth = volumeLastMonth;
	}

	public String getVolumeThisMonth() {
		return volumeThisMonth;
	}

	public void setVolumeThisMonth(String volumeThisMonth) {
		this.volumeThisMonth = volumeThisMonth;
	}

	public String getTaxesPaidLastMonth() {
		return taxesPaidLastMonth;
	}

	public void setTaxesPaidLastMonth(String taxesPaidLastMonth) {
		this.taxesPaidLastMonth = taxesPaidLastMonth;
	}

	public String getTaxesPaidThisMonth() {
		return taxesPaidThisMonth;
	}

	public void setTaxesPaidThisMonth(String taxesPaidThisMonth) {
		this.taxesPaidThisMonth = taxesPaidThisMonth;
	}

	public String getVolume_this_month() {
		return volume_this_month;
	}

	public void setVolume_this_month(String volume_this_month) {
		this.volume_this_month = volume_this_month;
	}

	public String getCustomLogoUrl() {
		return customLogoUrl;
	}

	public void setCustomLogoUrl(String customLogoUrl) {
		this.customLogoUrl = customLogoUrl;
	}

	public String getCustomLogoSmallUrl() {
		return customLogoSmallUrl;
	}

	public void setCustomLogoSmallUrl(String customLogoSmallUrl) {
		this.customLogoSmallUrl = customLogoSmallUrl;
	}

	
	
	public List<Map<String, String>> getInformations() {
		return informations;
	}

    @JsonDeserialize(using=PropertyMapDeserializer.class) 
	public void setInformations(List<Map<String, String>> informations) {
		this.informations = informations;
	}



	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	
	
}