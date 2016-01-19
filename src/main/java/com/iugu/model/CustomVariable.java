package com.iugu.model;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

public class CustomVariable {

	public CustomVariable(String name, String value) {
		this.name = name;
		this.value = value;
	}

	private String name;

	private String value;
	
	@JsonProperty("_destroy")
	@SerializedName("_destroy")
	private Boolean destroy;

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public Boolean getDestroy() {
		return destroy;
	}

	public void setDestroy(Boolean destroy) {
		this.destroy = destroy;
	}

}
