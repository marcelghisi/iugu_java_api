package com.iugu.model;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.gson.annotations.SerializedName;
import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DuplicateInvoiceRequest implements Serializable {

	private static final long serialVersionUID = 1719931730355279382L;
	
	
	public DuplicateInvoiceRequest(Date newDueDate,Boolean ignoreDueEmail,Boolean ignoreCanceledMail) {
		this.dueDate = newDueDate;
		this.ignoreDueEmail = ignoreDueEmail;
		this.ignorecanCaledEmail = ignoreCanceledMail;
		
	}
	@JsonProperty("due_date")
	@JsonFormat("dd/MM/yyyy")
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("due_date")
	private Date dueDate;

	/**
	 * Booleano para Ignorar o envio de Email por mudança da data
	 */
	@JsonProperty("ignore_due_email")
	@SerializedName("ignore_due_email")
	private Boolean ignoreDueEmail;
	
	/**
	 * Booleano para Ignorar o envio de Email avisando cancelamento
	 */
	@JsonProperty("ignore_canceled_email")
	@SerializedName("ignore_canceled_email")
	private Boolean ignorecanCaledEmail;

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Boolean getIgnoreDueEmail() {
		return ignoreDueEmail;
	}

	public void setIgnoreDueEmail(Boolean ignoreDueEmail) {
		this.ignoreDueEmail = ignoreDueEmail;
	}

	public Boolean getIgnorecanCaledEmail() {
		return ignorecanCaledEmail;
	}

	public void setIgnorecanCaledEmail(Boolean ignorecanCaledEmail) {
		this.ignorecanCaledEmail = ignorecanCaledEmail;
	}



}