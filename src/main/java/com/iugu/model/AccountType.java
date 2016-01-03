package com.iugu.model;

import org.codehaus.jackson.annotate.JsonValue;

public enum AccountType {

	Corrente("Corrente"), Poupança("Poupança");

	private String value;

	private AccountType(String value) {
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
