package com.iugu.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class SubAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4705750175852628545L;

	public SubAccount(String name,Integer marketPlaceCommissionPercent) {
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
	private Integer comissionPercent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getComissionPercent() {
		return comissionPercent;
	}

	public void setComissionPercent(Integer comissionPercent) {
		this.comissionPercent = comissionPercent;
	}



}
