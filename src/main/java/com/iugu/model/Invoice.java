package com.iugu.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.gson.annotations.SerializedName;
import com.iugu.responses.InvoiceResponse;
import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1719931730355279382L;
	
	public Invoice() {
		
	}
	
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
	
	
	private List<Item> items = new ArrayList<>();

	@JsonProperty("return_url")
	@SerializedName("return_url")
	private String returnUrl;
	
	@JsonProperty("expired_url")
	@SerializedName("expired_url")
	private String expiredUrl;
	
	@JsonProperty("notification_url")
	@SerializedName("notification_url")
	private String notificationUrl;
	
	@JsonProperty("tax_cents")
	@SerializedName("tax_cents")
	private Integer taxCents;
	
	private Boolean fines;
	
	@JsonProperty("late_payment_fine")
	@SerializedName("late_payment_fine")
	private Double latePaymentFine;
	
	@JsonProperty("per_day_interest")
	@SerializedName("per_day_interest")
	private Boolean perDayInterest;
	
	@JsonProperty("discount_cents")
	@SerializedName("discount_cents")
	private Integer discountCents;
	
	@JsonProperty("customer_id")
	@SerializedName("customer_id")
	private String customerId;
	
	@JsonProperty("ignore_due_email")
	@SerializedName("ignore_due_email")
	private Boolean ignoreDueEmail;
	
	@JsonProperty("ignore_canceled_email")
	@SerializedName("ignore_canceled_email")
	private Boolean ignoreCanceledEmail;

	@JsonProperty("subscription_id")
	@SerializedName("subscription_id")
	private String subscriptionId;
	
	@JsonProperty("payable_with")
	@SerializedName("payable_with")
	private PayableWith payableWith;
	
	private Integer credits;
	
	public static class Builder {
		//required
		private String email;
		private Date dueDate;
		private List<Item> items;
		
		//optional
		private String returnUrl;
		private String expiredUrl;
		private String notificationUrl;
		private Integer taxCents;
		private Boolean fines;
		private Double latePaymentFine;
		private Boolean perDayInterest; 
		private Integer discountCents; 
		private String customerId;
		private Boolean ignoreDueEmail;
		private String subscriptionId; 
		private PayableWith payableWith;
		private Integer credits; 
		 
		
		public Builder(String email,Date dueDate,List<Item> items) {
		  this.email = email;
		  this.dueDate = dueDate;
		  this.items = items;
		}
		
		public Builder returnUrl(String url) {
		  this.returnUrl = url;
		  return this;
		}
		
		public Builder expiredUrl(String url) {
			  this.expiredUrl = url;
			  return this;
		}
		
		public Builder notification_url(String url) {
			  this.notificationUrl = url;
			  return this;
		}
		
		public Builder taxCents(Integer tax) {
			  this.taxCents = tax;
			  return this;
		}
		
		public Builder fines(Boolean fines) {
			  this.fines = fines;
			  return this;
		}
		
		public Builder latePaymentFine (Double latePaymentFine) {
			  this.latePaymentFine = latePaymentFine;
			  return this;
		}
		
		public Builder perDayInterest (Boolean perDayInterest) {
			  this.perDayInterest = perDayInterest;
			  return this;
		}
		
		public Builder discountCents (Integer discountCents) {
			  this.discountCents = discountCents;
			  return this;
		}
		
		public Builder customerId (String customerId) {
			  this.customerId = customerId;
			  return this;
		}
		
		public Builder ignoreDueEmail (Boolean ignoreDueEmail) {
			  this.ignoreDueEmail = ignoreDueEmail;
			  return this;
		}
		
		public Builder subscriptionId (String subscriptionId) {
			  this.subscriptionId = subscriptionId;
			  return this;
		}
		
		public Builder payableWith (PayableWith payableWith) {
			  this.payableWith = payableWith;
			  return this;
		}
		
		public Builder credits (Integer credits) {
			  this.credits = credits;
			  return this;
		}
		
	    public Invoice build() {
	        return new Invoice(this);
	      }
	}
	
	private Invoice(Builder builder) {
		email = builder.email;
		dueDate = builder.dueDate;
		items = builder.items;
		returnUrl = builder.returnUrl;
		expiredUrl = builder.expiredUrl;
		notificationUrl = builder.notificationUrl;
		taxCents = builder.taxCents;
		fines = builder.fines;
		latePaymentFine = builder.latePaymentFine;
		perDayInterest = builder.perDayInterest;
		discountCents = builder.discountCents;
		customerId = builder.customerId;
		ignoreDueEmail = builder.ignoreDueEmail;
		subscriptionId = builder.subscriptionId;
		payableWith = builder.payableWith;
		credits = builder.credits;
		
	}
	
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

	public Boolean getPerDayInterest() {
		return perDayInterest;
	}

	public void setPerDayInterest(Boolean perDayInterest) {
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


	public void setEmail(String email) {
		this.email = email;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void setItems(List<Item> items) {
		this.items = items;
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



	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	
	
}