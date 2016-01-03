package com.iugu.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class PaymentToken {


	//ID de sua Conta na Iugu (O ID de sua conta pode ser encontrado clicando aqui)
	@JsonProperty("account_id")
	private String id;

	//method	Método de Pagamento (atualmente somente credit_card)
	private PayableWith method;

	//test (opcional)	Valor true para criar tokens de teste
	private String test;
	
	/**
	 * data{}	Dados do Método de Pagamento
	 */
	private Data data;

	public PaymentToken(String accountId, PayableWith paymentMethod, Boolean test,Data paymentData) {
		this.id = accountId;
		this.method = paymentMethod;
		this.test = test.toString();
		this.data = paymentData;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public PayableWith getMethod() {
		return method;
	}

	public void setMethod(PayableWith method) {
		this.method = method;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

}
