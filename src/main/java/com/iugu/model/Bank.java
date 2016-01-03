package com.iugu.model;

import org.codehaus.jackson.annotate.JsonValue;

public enum Bank {

	ITAU("Itaú"), BRADESCO("Bradesco"),CAIXA("Caixa Econômica"),BB("Banco do Brasil"),SANTANDER("Santander");

	private String value;

	private Bank(String value) {
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
