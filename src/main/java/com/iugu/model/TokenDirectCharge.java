package com.iugu.model;

import java.util.ArrayList;
import java.util.List;

public class TokenDirectCharge extends DirectCharge{

	//Builder for possible scenarios using Token
	// token (não é preenchido caso method seja bank_slip)	ID do Token. Em caso de Marketplace, é possível enviar um token criado pela conta mestre
	// Enviar um Payment Token gerado pelo cliente quando cadastra o cartao dele ou pede sempre os dados fera o token e usa.
	//1Primeira fase gera na hora e usa
	//Segunda fase gera guarda e usa
	private String token;
	
	public static class Builder {
		//required
		private String token;
		private String email;
		private List<Item> items = new ArrayList<>();
		
		//optional
		private Integer months;
		private Integer discountCents;
		private Payer payer;
		private String invoiceId;
		
		public Builder(String tokenId,String email,List<Item> items) {
		  this.token = tokenId;
		  this.email = email;
		  this.items = items;
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
		
		public Builder invoice(String invoiceId){
			this.invoiceId = invoiceId;
			return this;
		}
		
	    public TokenDirectCharge build() {
	        return new TokenDirectCharge(this);
	      }
	}
	
	private TokenDirectCharge(Builder builder) {
		token = builder.token;
		email = builder.email;
		items = builder.items;
		payer = builder.payer;
		months = builder.months;
		invoiceId = builder.invoiceId;
		discountCents = builder.discountCents;
	}
	


	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


}
