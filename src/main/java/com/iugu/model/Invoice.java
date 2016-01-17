package com.iugu.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.gson.annotations.SerializedName;
import com.iugu.responses.InvoiceResponse;
import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;

public class Invoice implements Serializable {

	private static final long serialVersionUID = 1719931730355279382L;
	
	public Invoice(InvoiceResponse response) {
		fillFromResponse(response);
	}
	
	private void fillFromResponse(InvoiceResponse invoice){
		id = invoice.getId();
		email = invoice.getEmail();
		dueDate = convertDate(invoice.getDueDate());
		items = invoice.getItems();
		returnUrl = invoice.getReturnUrl();
		expiredUrl = invoice.getExpiredUrl();
		notificationUrl = invoice.getNotificationUrl();
		customerId = invoice.getCustomerId();
		taxCents = invoice.getTaxCents();
		discountCents = invoice.getDiscountCents();
	}
	
	private Date convertDate(String date){
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Invoice(String email, Date dueDate, Item... items) {
		this.email = email;
		this.dueDate = dueDate;
		this.items.addAll(Arrays.asList(items)); // FIXME Tratar null pointer
	}
	
	private String id;

	/**
	 * E-Mail do cliente
	 */
	private String email;

	/**
	 * Data de Expiração (DD/MM/AAAA)
	 */
	@JsonProperty("due_date")
	@JsonFormat("dd/MM/yyyy")
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("due_date")
	private Date dueDate;
	
	@JsonProperty("created_at")
	@SerializedName("created_at")
	private String createdAt;
	
	@JsonProperty("paid_at")
	@SerializedName("paid_at")
	private String paidAt;
	
	@JsonProperty("updated_at")
	@JsonFormat("yyyy-MM-dd'T'HH:mm:ssZ") 
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("updated_at")
	private Date updatedAt;

	/**
	 * Itens da Fatura
	 */
	private List<Item> items = new ArrayList<>();

	private String status;
	
	/**
	 * Emails de cópia
	 */
	@JsonProperty("cc_emails")
	@SerializedName("cc_emails")
	private String ccEmails;

	/**
	 * Cliente é redirecionado para essa URL após efetuar o pagamento da Fatura
	 * pela página de Fatura da Iugu
	 */
	@JsonProperty("return_url")
	@SerializedName("return_url")
	private String returnUrl;
	
	@JsonProperty("secure_url")
	@SerializedName("secure_url")
	private String secureUrl;
	

	/**
	 * Cliente é redirecionado para essa URL se a Fatura que estiver acessando
	 * estiver expirada
	 */
	@JsonProperty("expired_url")
	@SerializedName("expired_url")
	private String expiredUrl;

	/**
	 * ID do cliente
	 */
	@JsonProperty("customer_id")
	@SerializedName("customer_id")
	private String customerId;
	
	@JsonProperty("user_id")
	@SerializedName("user_id")
	private String userId;
	
	
	@JsonProperty("secure_id")
	@SerializedName("secure_id")
	private String secureId;
	
	@JsonProperty("total_on_occurrence_day")
	@SerializedName("total_on_occurrence_day")
	private String totalOnOccurrenceDay;
	

	@JsonProperty("notification_url")
	@SerializedName("notification_url")
	private String notificationUrl;

	@JsonProperty("customer_ref")
	@SerializedName("customer_ref")
	private String customerRef;
	
	@JsonProperty("customer_name")
	@SerializedName("customer_name")
	private String customerName;

	@JsonProperty("taxes_paid")
	@SerializedName("taxes_paid")
	private String taxesPaid;
	
	@JsonProperty("total_paid")
	@SerializedName("total_paid")
	private String totalPaid;
	
	@JsonProperty("total_overpaid")
	@SerializedName("total_overpaid")
	private String totalOverPaid;
	
	@JsonProperty("fines_on_occurrence_day")
	@SerializedName("fines_on_occurrence_day")
	private String finesOnOccurrenceDay;
	
	@JsonProperty("fines_on_occurrence_day_cents")
	@SerializedName("fines_on_occurrence_day_cents")
	private String finesOnOccurrenceDayCents;
	
	@JsonProperty("total_on_occurrence_day_cents")
	@SerializedName("total_on_occurrence_day_cents")
	private String totalOnOccurrenceDayCents;
	
	@JsonProperty("financial_return_date")
	@SerializedName("financial_return_date")
	private String financialReturnDate;

	@JsonProperty("advance_fee")
	@SerializedName("advance_fee")
	private String advanceFee;
	
	private String paid;

	private String interest;
	
	private String discount;
	
	private String refundable;
	
	private Integer installments;
	
	@JsonProperty("transaction_number")
	@SerializedName("transaction_number")
	private Integer transactionNumber;
	
	@JsonProperty("payment_method")
	@SerializedName("payment_method")
	private String paymentMethod;
	
	@JsonProperty("created_at_iso")
	@JsonFormat("yyyy-MM-dd'T'HH:mm:ssZ") 
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("created_at_iso")
	private Date createdAtIso;
	
	@JsonProperty("updated_at_iso")
	@JsonFormat("yyyy-MM-dd'T'HH:mm:ssZ") 
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("updated_at_iso")
	private Date updatedAtIso;
	
	private String total;
	
	@JsonProperty("financial_return_dates")
	@SerializedName("financial_return_dates")
	private String financialReturnDates;
	
	
	/**
	 * Valor dos Impostos em centavos
	 */
	@JsonProperty("total_cents")
	@SerializedName("total_cents")
	private Integer totalCents;
	
	@JsonProperty("taxes_paid_cents")
	@SerializedName("taxes_paid_cents")
	private Integer taxesPaidCents;
	
	/**
	 * Valor dos Impostos em centavos
	 */
	@JsonProperty("total_paid_cents")
	@SerializedName("total_paid_cents")
	private Integer totalPaidCents;

	@JsonProperty("paid_cents")
	@SerializedName("paid_cents")
	private Integer paidCents;
	
	@JsonProperty("advance_fee_cents")
	@SerializedName("advance_fee_cents")
	private Integer advanceFeeCents;
	
	/**
	 * Booleano para Habilitar ou Desabilitar multa por atraso de pagamento
	 */
	private Boolean fines;
	
	@JsonProperty("ignore_due_email")
	@SerializedName("ignore_due_email")
	private Boolean ignoreDueEmail;
	
	@JsonProperty("ignore_canceled_email")
	@SerializedName("ignore_canceled_email")
	private Boolean ignoreCanceledEmail;
	/**
	 * Determine a multa a ser cobrada para pagamentos efetuados após a data de
	 * vencimento
	 */
	@JsonProperty("late_payment_fine")
	@SerializedName("late_payment_fine")
	private Double latePaymentFine;

	/**
	 * Booleano que determina se cobra ou não juros por dia de atraso. 1% ao mês
	 * pro rata.
	 */
	@JsonProperty("per_day_interest")
	@SerializedName("per_day_interest")
	private Double perDayInterest;

	/**
	 * Valor dos Descontos em centavos
	 */
	@JsonProperty("discount_cents")
	@SerializedName("discount_cents")
	private Integer discountCents;
	
	/**
	 * Valor dos Descontos em centavos
	 */
	@JsonProperty("tax_cents")
	@SerializedName("tax_cents")
	private Integer taxCents;

	@JsonProperty("payable_with")
	@SerializedName("payable_with")
	private PayableWith payableWith;


	@JsonProperty("overpaid_cents")
	@SerializedName("overpaid_cents")
	private Integer overpaidCents;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public List<Item> getItems() {
		return items;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public Invoice withReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
		return this;
	}

	public String getExpiredUrl() {
		return expiredUrl;
	}

	public Invoice withExpiredUrl(String expiredUrl) {
		this.expiredUrl = expiredUrl;
		return this;
	}

	public String getCustomerId() {
		return customerId;
	}

	public Invoice withCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getNotificationUrl() {
		return notificationUrl;
	}

	public Invoice withNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
		return this;
	}

	public Integer getTaxCents() {
		return taxCents;
	}

	public Invoice withTaxCents(Integer taxCents) {
		this.taxCents = taxCents;
		return this;
	}

	public Boolean getFines() {
		return fines;
	}

	public Invoice withFines(Boolean fines) {
		this.fines = fines;
		return this;
	}

	public Double getLatePaymentFine() {
		return latePaymentFine;
	}

	public void setLatePaymentFine(Double latePaymentFine) {
		this.latePaymentFine = latePaymentFine;
	}

	public Double getPerDayInterest() {
		return perDayInterest;
	}

	public void setPerDayInterest(Double perDayInterest) {
		this.perDayInterest = perDayInterest;
	}

	public Integer getDiscountCents() {
		return discountCents;
	}

	public void setDiscountCents(Integer discountCents) {
		this.discountCents = discountCents;
	}

	public PayableWith getPayableWith() {
		return payableWith;
	}

	public void setPayableWith(PayableWith payableWith) {
		this.payableWith = payableWith;
	}

	public String getCcEmails() {
		return ccEmails;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Invoice withCcEmails(String ccEmails) {
		this.ccEmails = ccEmails;
		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
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

	public Integer getTotalPaidCents() {
		return totalPaidCents;
	}

	public void setTotalPaidCents(Integer totalPaidCents) {
		this.totalPaidCents = totalPaidCents;
	}

	public String getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(String paidAt) {
		this.paidAt = paidAt;
	}

	public Integer getTaxesPaidCents() {
		return taxesPaidCents;
	}

	public void setTaxesPaidCents(Integer taxesPaidCents) {
		this.taxesPaidCents = taxesPaidCents;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void setCcEmails(String ccEmails) {
		this.ccEmails = ccEmails;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public void setExpiredUrl(String expiredUrl) {
		this.expiredUrl = expiredUrl;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}

	public void setFines(Boolean fines) {
		this.fines = fines;
	}

	public void setTaxCents(Integer taxCents) {
		this.taxCents = taxCents;
	}

	public Integer getPaidCents() {
		return paidCents;
	}

	public void setPaidCents(Integer paidCents) {
		this.paidCents = paidCents;
	}

	public Integer getOverpaidCents() {
		return overpaidCents;
	}

	public void setOverpaidCents(Integer overpaidCents) {
		this.overpaidCents = overpaidCents;
	}

	public Boolean getIgnoreDueEmail() {
		return ignoreDueEmail;
	}

	public void setIgnoreDueEmail(Boolean ignoreDueEmail) {
		this.ignoreDueEmail = ignoreDueEmail;
	}

	public Boolean getIgnoreCanceledEmail() {
		return ignoreCanceledEmail;
	}

	public void setIgnoreCanceledEmail(Boolean ignoreCanceledEmail) {
		this.ignoreCanceledEmail = ignoreCanceledEmail;
	}

	public Integer getAdvanceFeeCents() {
		return advanceFeeCents;
	}

	public void setAdvanceFeeCents(Integer advanceFeeCents) {
		this.advanceFeeCents = advanceFeeCents;
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

	public String getCustomerRef() {
		return customerRef;
	}

	public void setCustomerRef(String customerRef) {
		this.customerRef = customerRef;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	public String getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(String totalPaid) {
		this.totalPaid = totalPaid;
	}

	public String getTotalOverPaid() {
		return totalOverPaid;
	}

	public void setTotalOverPaid(String totalOverPaid) {
		this.totalOverPaid = totalOverPaid;
	}

	public String getFinesOnOccurrenceDay() {
		return finesOnOccurrenceDay;
	}

	public void setFinesOnOccurrenceDay(String finesOnOccurrenceDay) {
		this.finesOnOccurrenceDay = finesOnOccurrenceDay;
	}

	public String getTotalOnOccurrenceDay() {
		return totalOnOccurrenceDay;
	}

	public void setTotalOnOccurrenceDay(String totalOnOccurrenceDay) {
		this.totalOnOccurrenceDay = totalOnOccurrenceDay;
	}

	public String getFinesOnOccurrenceDayCents() {
		return finesOnOccurrenceDayCents;
	}

	public void setFinesOnOccurrenceDayCents(String finesOnOccurrenceDayCents) {
		this.finesOnOccurrenceDayCents = finesOnOccurrenceDayCents;
	}

	public String getTotalOnOccurrenceDayCents() {
		return totalOnOccurrenceDayCents;
	}

	public void setTotalOnOccurrenceDayCents(String totalOnOccurrenceDayCents) {
		this.totalOnOccurrenceDayCents = totalOnOccurrenceDayCents;
	}

	public String getFinancialReturnDate() {
		return financialReturnDate;
	}

	public void setFinancialReturnDate(String financialReturnDate) {
		this.financialReturnDate = financialReturnDate;
	}

	public String getAdvanceFee() {
		return advanceFee;
	}

	public void setAdvanceFee(String advanceFee) {
		this.advanceFee = advanceFee;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
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

	public String getRefundable() {
		return refundable;
	}

	public void setRefundable(String refundable) {
		this.refundable = refundable;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}

	public Integer getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(Integer transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getCreatedAtIso() {
		return createdAtIso;
	}

	public void setCreatedAtIso(Date createdAtIso) {
		this.createdAtIso = createdAtIso;
	}

	public Date getUpdatedAtIso() {
		return updatedAtIso;
	}

	public void setUpdatedAtIso(Date updatedAtIso) {
		this.updatedAtIso = updatedAtIso;
	}

	public String getFinancialReturnDates() {
		return financialReturnDates;
	}

	public void setFinancialReturnDates(String financialReturnDates) {
		this.financialReturnDates = financialReturnDates;
	}
	
	
	
}