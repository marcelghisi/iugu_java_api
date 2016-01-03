package com.iugu.model;

import org.codehaus.jackson.annotate.JsonValue;

public enum PersonType {

	PF("Pessoa Física"), PJ("Pessoa Jurídica");

	private String value;

	private PersonType(String value) {
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
