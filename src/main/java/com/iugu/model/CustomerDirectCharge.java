package com.iugu.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

public class CustomerDirectCharge extends DirectCharge{

	
	//Constroi um objeto para pagamento direto usando um customer payment id
	public CustomerDirectCharge(String customerPaymentMethodId,Customer customer,String email,List<Item> items,Payer payer,Integer months,Integer discountValueInCents) {
		this.customerPaymentMethodId = customerPaymentMethodId;
		this.customerId = customer.getId();
		this.email = email;
		this.items = items;
		this.payer = payer;
		this.months = months;
		this.discountCents = discountValueInCents;
	}
	
	public CustomerDirectCharge(String customerPaymentMethodId,Customer customer,Invoice invoice,Payer payer,Integer months,Integer discountValueInCents) {
		this.customerPaymentMethodId = customerPaymentMethodId;
		this.customerId = customer.getId();
		this.invoiceId = invoice.getId();
		this.payer = payer;
		this.months = months;
		this.discountCents = discountValueInCents;
	}
	
	//customer_payment_method_id (não é preenchido caso method seja bank_slip ou utilize token)	ID da Forma de Pagamento do Cliente. 
	//Em caso de Marketplace, é possível enviar um customer_payment_method_id de um Cliente criado pela conta mestre
	//TODO Perguntar Se eu guardar os tokens comigo eu uso se seu guardar os tokens com a iugu uso lá?
	@JsonProperty("customer_payment_method_id")
	@SerializedName("customer_payment_method_id")
	private String customerPaymentMethodId;
	
	//method (não é preenchido se enviar token)	Método de Pagamento (Atualmente só suporta bank_slip, que é o boleto)
	//perguntar pq method so bank slip para direct charge
	//private String method;
	
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
	
	//public String getMethod() {
	//	return method;
	//}

	//public void setMethod(String method) {
	//	this.method = method;
	//}

	public String getCustomerPaymentMethodId() {
		return customerPaymentMethodId;
	}

	public void setCustomerPaymentMethodId(String customerPaymentMethodId) {
		this.customerPaymentMethodId = customerPaymentMethodId;
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
