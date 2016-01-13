package com.iugu.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

public class CustomerPaymentDirectCharge extends DirectCharge{

	//customer_payment_method_id (não é preenchido caso method seja bank_slip ou utilize token)	ID da Forma de Pagamento do Cliente. 
	//Em caso de Marketplace, é possível enviar um customer_payment_method_id de um Cliente criado pela conta mestre
	//TODO Perguntar Se eu guardar os tokens comigo eu uso se seu guardar os tokens com a iugu uso lá?
	@JsonProperty("customer_payment_method_id")
	@SerializedName("customer_payment_method_id")
	private String customerPaymentMethodId;
	
	private boolean cheese;
	private boolean pepperoni;
	private boolean bacon;
	  
	public static class Builder {
		//required
		private String customerPaymentMethodId;
		
		//optional
		private boolean cheese = false;
		private boolean pepperoni = false;
		private boolean bacon = false;
		
		public Builder(String customerPaymentMethodId) {
		  this.customerPaymentMethodId = customerPaymentMethodId;
		}
		
		public Builder cheese(boolean value) {
		  cheese = value;
		  return this;
		}
		
	    public CustomerPaymentDirectCharge build() {
	        return new CustomerPaymentDirectCharge(this);
	      }
	}
	
	private CustomerPaymentDirectCharge(Builder builder) {
		customerPaymentMethodId = builder.customerPaymentMethodId;

	}
	
	//method (não é preenchido se enviar token)	Método de Pagamento (Atualmente só suporta bank_slip, que é o boleto)
	//perguntar pq method so bank slip para direct charge
	//private String method;
	

	
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



}
