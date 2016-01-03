package com.iugu.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class SubAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4705750175852628545L;

	public SubAccount(String name,String marketPlaceCommissionPercent) {
		this.name = name;
		this.comissionPercent = marketPlaceCommissionPercent;
	}

	/**
	 * Nome do cliente
	 */
	private String name;
	
	/**
	 * Percentual de comissão pago para o marketplace
	 */
	@JsonProperty("commission_percent")
	private String comissionPercent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComissionPercent() {
		return comissionPercent;
	}

	public void setComissionPercent(String comissionPercent) {
		this.comissionPercent = comissionPercent;
	}

}
