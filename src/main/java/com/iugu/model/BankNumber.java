package com.iugu.model;

import org.codehaus.jackson.annotate.JsonValue;

public enum BankNumber {

	ITAU("341"), BRADESCO("237"),CAIXA("104"),BB("001"),SANTANDER("033"),HSBC("399");

	private String value;

	private BankNumber(String value) {
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
