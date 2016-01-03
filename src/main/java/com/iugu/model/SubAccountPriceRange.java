package com.iugu.model;

import org.codehaus.jackson.annotate.JsonValue;

public enum SubAccountPriceRange {

	ATE_100("Até R$ 100,00"), ENTRE_100_500("Entre R$ 100,00 e R$ 500,00"), MAIOR_500("Mais que R$ 500,00");

	private String value;

	private SubAccountPriceRange(String value) {
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
