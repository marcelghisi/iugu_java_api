package com.iugu.responses;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChargeResponse {

	//Retorna true caso a transacao com cartao de credito tenha sido aprovada e false para recusada
	private String success;
	
	//Mensagem para a transação Ex: Autorizado
	private String message;
	
	//Em caso de aprovado retorno o id da fatura gerada
	@JsonProperty("invoice_id")
	@SerializedName("invoice_id")
	private String invoiceId;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}


	
}