package com.iugu.responses;

import java.util.Date;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.iugu.model.Configuration;
import com.iugu.model.SubAccountValidationData;
import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;

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
	
	//TODO Perguntar Centes?
	private Integer balance;
	
	@JsonProperty("protected_balance")
	private Integer protectedBalance;	

	@JsonProperty("payable_balance")
	private Integer payableBalance;
	
	@JsonProperty("commission_balance")
	private Integer commissionBalance;
	
	@JsonProperty("volume_last_month")
	private Integer volumeLastMonth;
	
	@JsonProperty("volume_this_month")
	private Integer volumeThisMonth;
	
	@JsonProperty("taxes_paid_last_month")
	private Integer taxesPaidLastMonth;
	
	@JsonProperty("taxes_paid_this_month")
	private Integer taxesPaidThisMonth;
	
	@JsonProperty("volume_this_month")
	private Integer volume_this_month;
	
	@JsonProperty("custom_logo_url")
	private String customLogoUrl;
	
	@JsonProperty("custom_logo_small_url")
	private String customLogoSmallUrl;
	
    private Map<String, String> informations;
    
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

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getProtectedBalance() {
		return protectedBalance;
	}

	public void setProtectedBalance(Integer protectedBalance) {
		this.protectedBalance = protectedBalance;
	}

	public Integer getPayableBalance() {
		return payableBalance;
	}

	public void setPayableBalance(Integer payableBalance) {
		this.payableBalance = payableBalance;
	}

	public Integer getCommissionBalance() {
		return commissionBalance;
	}

	public void setCommissionBalance(Integer commissionBalance) {
		this.commissionBalance = commissionBalance;
	}

	public Integer getVolumeLastMonth() {
		return volumeLastMonth;
	}

	public void setVolumeLastMonth(Integer volumeLastMonth) {
		this.volumeLastMonth = volumeLastMonth;
	}

	public Integer getVolumeThisMonth() {
		return volumeThisMonth;
	}

	public void setVolumeThisMonth(Integer volumeThisMonth) {
		this.volumeThisMonth = volumeThisMonth;
	}

	public Integer getTaxesPaidLastMonth() {
		return taxesPaidLastMonth;
	}

	public void setTaxesPaidLastMonth(Integer taxesPaidLastMonth) {
		this.taxesPaidLastMonth = taxesPaidLastMonth;
	}

	public Integer getTaxesPaidThisMonth() {
		return taxesPaidThisMonth;
	}

	public void setTaxesPaidThisMonth(Integer taxesPaidThisMonth) {
		this.taxesPaidThisMonth = taxesPaidThisMonth;
	}

	public Integer getVolume_this_month() {
		return volume_this_month;
	}

	public void setVolume_this_month(Integer volume_this_month) {
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

	public Map<String, String> getInformations() {
		return informations;
	}

	public void setInformations(Map<String, String> informations) {
		this.informations = informations;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	
	
}