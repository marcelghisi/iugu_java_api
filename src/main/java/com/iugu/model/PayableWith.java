package com.iugu.model;

import org.codehaus.jackson.annotate.JsonValue;

import com.google.gson.annotations.SerializedName;

public enum PayableWith {

	@SerializedName("credit_card")
	CREDIT_CARD("credit_card"), 
	@SerializedName("all")
	ALL("all"), 
	@SerializedName("bank_slip")
	BANK_SLIP("bank_slip");

	private String value;

	private PayableWith(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
