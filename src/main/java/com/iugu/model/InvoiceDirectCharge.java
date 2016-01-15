package com.iugu.model;


public class InvoiceDirectCharge extends DirectCharge{

	//Builder for possible scenarios using Token
	// token (não é preenchido caso method seja bank_slip)	ID do Token. Em caso de Marketplace, é possível enviar um token criado pela conta mestre
	// Enviar um Payment Token gerado pelo cliente quando cadastra o cartao dele ou pede sempre os dados fera o token e usa.
	//1Primeira fase gera na hora e usa
	//Segunda fase gera guarda e usa
	private String token;
	
	public static class Builder {
		//required
		private String token;
		private Payer payer;
		private String invoiceId;
		
		//optional
		private Integer months;
		private Integer discountCents;
		
		public Builder(String tokenId,String invoiceId) {
		  this.token = tokenId;
		  this.invoiceId = invoiceId;
		}
		
		public Builder months(Integer months) {
		  this.months = months;
		  return this;
		}
		
		public Builder discount(Integer cents) {
			  this.discountCents = cents;
			  return this;
		}
		
		public Builder payer(Payer payer) {
			  this.payer = payer;
			  return this;
		}
		
	    public InvoiceDirectCharge build() {
	        return new InvoiceDirectCharge(this);
	      }
	}
	
	private InvoiceDirectCharge(Builder builder) {
		token = builder.token;
		invoiceId = builder.invoiceId;
		payer = builder.payer;
		months = builder.months;
		discountCents = builder.discountCents;
	}
	


	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


}
