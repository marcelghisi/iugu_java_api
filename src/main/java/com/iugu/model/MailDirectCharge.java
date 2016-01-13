package com.iugu.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

public class MailDirectCharge extends DirectCharge{

	//Constructor for possible scenarios using Token
	
	//#1 Realiza uma cobranca Direta para usando um tokem criado na hora para um cartao de credito especifico e para um e-mail aleatorio
	public MailDirectCharge(String token, String email,List<Item> items) {
		this(token,email,items,null,null,null,null);
	}
	
	//#1 Realiza uma cobranca Direta para usando um tokem criado na hora para um cartao de credito especifico e para um e-mail aleatorio
	//# Possivel passar o numero de parcelas ou o desconto
	public MailDirectCharge(String token, String email,List<Item> items,Integer months,Integer discountValueInCents) {
		this(token,email,items,null,null,months,discountValueInCents);
	}
	
	//#1 Realiza uma cobranca Direta para usando um tokem criado na hora para um cartao de credito especifico e para um e-mail aleatorio
	//Passa os dados do pagador para verificação de fraldes
	public MailDirectCharge(String token, String email,List<Item> items,Payer payer) {
		this(token,email,items,payer,null,null,null);
	}
	
	//#1 Realiza uma cobranca Direta para usando um tokem criado na hora para um cartao de credito especifico e para um invoice(fatura) já criado anteriormente
	//Perguntar scenario iugu
	public MailDirectCharge(String token, Invoice invoice,List<Item> items) {
		this(token,invoice,items,null,null,null,null);
	}
	
	//#1 Realiza uma cobranca Direta para usando um tokem criado na hora para um cartao de credito especifico e para um invoice(fatura) já criado anteriormente
	//Alternativamente pode-se passar o numero de parcelas ou desconto
	public MailDirectCharge(String token, Invoice invoice,List<Item> items,Integer months,Integer discountValueInCents) {
		this(token,invoice,items,null,null,months,discountValueInCents);
	}
	
	//#1 Realiza uma cobranca Direta para usando um tokem criado na hora para um cartao de credito especifico e para um invoice(fatura) já criado anteriormente
	//Passando o Payer para verificação do AntiFraude
	public MailDirectCharge(String token, Invoice invoice,List<Item> items,Payer payer) {
		this(token,invoice,items,payer,null,null,null);
	}
	
	public MailDirectCharge(String token, String email,List<Item> items,Payer payer,Customer customer,Integer months,Integer discountValueInCents) {
		this.token = token;
		this.email = email;
		this.items = items;
		this.payer = payer;
		this.customerId = customer.getId();
		this.months = months;
		this.discountCents = discountValueInCents;
	}
	
	public MailDirectCharge(String paymentToken, Invoice invoice,List<Item> items,Payer payer,Customer customer,Integer months,Integer discountValueInCents) {
		this.token = paymentToken;
		this.invoiceId = invoice.getId();
		this.items = items;
		this.payer = payer;
		this.customerId = customer.getId();
		this.months = months;
		this.discountCents = discountValueInCents;
	}
	

	// token (não é preenchido caso method seja bank_slip)	ID do Token. Em caso de Marketplace, é possível enviar um token criado pela conta mestre
	// Enviar um Payment Token gerado pelo cliente quando cadastra o cartao dele ou pede sempre os dados fera o token e usa.
	//1Primeira fase gera na hora e usa
	//Segunda fase gera guarda e usa
	private String token;

	//customer_id (opcional)	ID do Cliente. Utilizado para vincular a Fatura a um Cliente
	//Vincular o cliente a fatura que sera gerada. [[[[client company nosso]]]]
	//Pagamento direto de um atendimento
	@JsonProperty("customer_id")
	@SerializedName("customer_id")
	private String customerId;
	
	//invoice_id (opcional)	ID da Fatura a ser utilizada para pagamento
	//Vincular a fatura ja gerada que será paga.
	//Utilizar no caso de controle de faturas
	@JsonProperty("invoice_id")
	@SerializedName("invoice_id")
	private String invoiceId;
	
	//email (não é preenchido caso seja enviado um invoice_id)	E-mail do Cliente
	//Enviar o e-mail do cliente que esta pagando a conta avulsa.
	@JsonProperty("email")
	private String email;
	
	
	//months (optional)	Número de Parcelas (2 até 12), não é necessário passar 1
	//TODO Perguntar Para boleto também gera 12 parcelas
	@JsonProperty("months")
	private Integer months;
	
	//discount_cents (opcional)	Valor dos Descontos em centavos. Funciona apenas para Cobranças Diretas criadas com Itens.
	//TODO Perguntar Para boleto também gera 12 parcelas
	@JsonProperty("discount_cents")
	@SerializedName("discount_cents")
	private Integer discountCents;
	
	//items[] (não é preenchido caso seja enviado um invoice_id)	Itens da Fatura direta que será gerada
	//Para cobranca direta
	/**
	 * Itens da Fatura de cobranca direta
	 */
	private List<Item> items = new ArrayList<>();
	
	//payer{} (necessário caso sua conta necessite de anti fraude ou para informações do boleto)
	private Payer payer;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	

	public Integer getDiscountCents() {
		return discountCents;
	}

	public void setDiscountCents(Integer discountCents) {
		this.discountCents = discountCents;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Payer getPayer() {
		return payer;
	}

	public void setPayer(Payer payer) {
		this.payer = payer;
	}

}
