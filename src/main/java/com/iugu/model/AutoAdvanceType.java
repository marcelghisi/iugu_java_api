package com.iugu.model;

import org.codehaus.jackson.annotate.JsonValue;

public enum AutoAdvanceType {

	daily("Antecipação diáaria"), weekly("Antecipação semanal"), monthly("Antecipação mensal"),days_after_payment("Antecipação X dias após pagamento");

	private String value;

	private AutoAdvanceType(String value) {
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
