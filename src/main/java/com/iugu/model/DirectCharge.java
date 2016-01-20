package com.iugu.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

public class DirectCharge {

	//customer_id (opcional)	ID do Cliente. Utilizado para vincular a Fatura a um Cliente
	//Vincular o cliente a fatura que sera gerada. [[[[client company nosso]]]]
	//Pagamento direto de um atendimento
	@JsonProperty("customer_id")
	@SerializedName("customer_id")
	protected String customerId;
	
	//invoice_id (opcional)	ID da Fatura a ser utilizada para pagamento
	//Vincular a fatura ja gerada que será paga.
	//Utilizar no caso de controle de faturas
	@JsonProperty("invoice_id")
	@SerializedName("invoice_id")
	protected String invoiceId;
	
	//email (não é preenchido caso seja enviado um invoice_id)	E-mail do Cliente
	//Enviar o e-mail do cliente que esta pagando a conta avulsa.
	//TODO Criar excecao no metodo build em caso de invoice
	@JsonProperty("email")
	protected String email;
	
	//items[] (não é preenchido caso seja enviado um invoice_id)	Itens da Fatura direta que será gerada
	//Para cobranca direta
	//TODO Validar Builder Não preencher se tem invoice ID
	/**
	 * Itens da Fatura de cobranca direta
	 */
	protected List<Item> items = new ArrayList<>();
	
	protected Payer payer;
	
	//months (optional)	Número de Parcelas (2 até 12), não é necessário passar 1
	//TODO Perguntar Para boleto também gera 12 parcelas
	//TODO Validar Builder 2 a 12
	@JsonProperty("months")
	protected Integer months;
	
	//discount_cents (opcional)	Valor dos Descontos em centavos. Funciona apenas para Cobranças Diretas criadas com Itens.
	//TODO Perguntar Para boleto também gera 12 parcelas
	//TODO Validar existencia de Items no Builder
	@JsonProperty("discount_cents")
	@SerializedName("discount_cents")
	protected Integer discountCents;

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
	
	
	
}
