package com.iugu.model;

import java.util.ArrayList;
import java.util.List;

public  class BankSlipDirectCharge extends DirectCharge{

	//Builder for possible scenarios using Token

	//So e aceito bankslip
	private String method;
	
	public static class Builder {
		//required
		private String method;
		private String email;
		private List<Item> items = new ArrayList<>();
		private Payer payer;
		
		//optional
		private Integer months;
		private Integer discountCents;
		
		public Builder(String email,List<Item> items) {
		  this.method = PayableWith.BANK_SLIP.getValue();
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
		
	    public BankSlipDirectCharge build() {
	        return new BankSlipDirectCharge(this);
	      }
	}
	
	private BankSlipDirectCharge(Builder builder) {
		method = builder.method;
		email = builder.email;
		items = builder.items;
		payer = builder.payer;
		months = builder.months;
		discountCents = builder.discountCents;
	}
	


	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}


}
