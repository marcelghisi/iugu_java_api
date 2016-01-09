package com.iugu.responses;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChargeResponse extends MessageResponse{

	//Em caso de aprovado retorno o id da fatura gerada
	@JsonProperty("invoice_id")
	@SerializedName("invoice_id")
	private String invoiceId;


	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}


	
}