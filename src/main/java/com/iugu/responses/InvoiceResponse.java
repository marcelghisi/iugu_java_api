package com.iugu.responses;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.gson.annotations.SerializedName;
import com.iugu.model.Item;
import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceResponse extends MessageResponse implements Serializable {

	private static final long serialVersionUID = -4229186497940178039L;

	private String id;
	
	@JsonProperty("due_date")
	@JsonFormat("yyyy-MM-dd") 
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("due_date")
	private String dueDate;
	
	private String currency;
	
	@JsonProperty("discount_cents")
	@SerializedName("discount_cents")
	private Integer discountCents;

	private String email;
	
	@JsonProperty("items_total_cents")
	@SerializedName("items_total_cents")
	private Integer itemsTotalCents;
	
	@JsonProperty("notification_url")
	@SerializedName("notification_url")
	private String notificationUrl;
	
	@JsonProperty("return_url")
	@SerializedName("return_url")
	private String returnUrl;
	
	@JsonProperty("expired_url ")
	@SerializedName("expired_url ")
	private String expiredUrl;
	
	private String status;
	
	@JsonProperty("tax_cents")
	@SerializedName("tax_cents")
	private Integer taxCents;
	
	@JsonProperty("updated_at")
	@JsonFormat("yyyy-MM-dd'T'HH:mm:ssZ") 
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("updated_at")
	private Date updatedAt;
	
	@JsonProperty("total_cents")
	@SerializedName("total_cents")
	private Integer totalCents;
	
	@JsonProperty("paid_at")
	@SerializedName("paid_at")
	private Date paidAt;
	
	@JsonProperty("secure_id")
	@SerializedName("secure_id")
	private String secureId;
	
	@JsonProperty("secure_url")
	@SerializedName("secure_url")
	private String secureUrl;
	
	@JsonProperty("customer_id")
	@SerializedName("customer_id")
	private String customerId;
	
	@JsonProperty("user_id")
	@SerializedName("user_id")
	private Long userId;
	
	private String total;
	
	@JsonProperty("taxes_paid")
	@SerializedName("taxes_paid")
	private String taxesPaid;
	
	private String interest;
	
	private String discount;
	
	private Boolean refundable;
	
	private Boolean installments;
	
	@JsonProperty("bank_slip")
	@SerializedName("bank_slip")
	private BankSlipResponse bankSlip;
	
	private List<Item> items;
	
	private List<VariableResponse> variables;
 	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getDiscountCents() {
		return discountCents;
	}

	public void setDiscountCents(Integer discountCents) {
		this.discountCents = discountCents;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getItemsTotalCents() {
		return itemsTotalCents;
	}

	public void setItemsTotalCents(Integer itemsTotalCents) {
		this.itemsTotalCents = itemsTotalCents;
	}

	public String getNotificationUrl() {
		return notificationUrl;
	}

	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}
	
	

	public String getExpiredUrl() {
		return expiredUrl;
	}

	public void setExpiredUrl(String expiredUrl) {
		this.expiredUrl = expiredUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTaxCents() {
		return taxCents;
	}

	public void setTaxCents(Integer taxCents) {
		this.taxCents = taxCents;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getTotalCents() {
		return totalCents;
	}

	public void setTotalCents(Integer totalCents) {
		this.totalCents = totalCents;
	}

	public Date getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(Date paidAt) {
		this.paidAt = paidAt;
	}

	public String getSecureId() {
		return secureId;
	}

	public void setSecureId(String secureId) {
		this.secureId = secureId;
	}

	public String getSecureUrl() {
		return secureUrl;
	}

	public void setSecureUrl(String secureUrl) {
		this.secureUrl = secureUrl;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getTaxesPaid() {
		return taxesPaid;
	}

	public void setTaxesPaid(String taxesPaid) {
		this.taxesPaid = taxesPaid;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public Boolean getRefundable() {
		return refundable;
	}

	public void setRefundable(Boolean refundable) {
		this.refundable = refundable;
	}

	public Boolean getInstallments() {
		return installments;
	}

	public void setInstallments(Boolean installments) {
		this.installments = installments;
	}

	public BankSlipResponse getBankSlip() {
		return bankSlip;
	}

	public void setBankSlip(BankSlipResponse bankSlip) {
		this.bankSlip = bankSlip;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<VariableResponse> getVariables() {
		return variables;
	}

	public void setVariables(List<VariableResponse> variables) {
		this.variables = variables;
	}
	
	
	
}