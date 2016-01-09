package com.iugu.model;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

public class PaymentMethodRequest {

	public PaymentMethodRequest(String token,String customerId, String description,Boolean markAsMethodDefault) {
		this.customerId = customerId;
		this.description = description;
		this.token = token;
		this.defaultMethod = markAsMethodDefault;
	}
	
	public PaymentMethodRequest(ItemType methodType,String customerId, String description,Data data,Boolean markAsMethodDefault) {
		this.customerId = customerId;
		this.description = description;
		this.data = data;
		this.itemType = methodType.getValue();
		this.defaultMethod = markAsMethodDefault;
	}

	@JsonProperty("customer_id")
	@SerializedName("customer_id")
	private String customerId;

	private String description;

	private Data data;

	@JsonProperty("item_type")
	@SerializedName("item_type")
	private String itemType;

	private String token;

	@JsonProperty("set_as_default")
	@SerializedName("set_as_default")
	private Boolean defaultMethod;

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}



	public Boolean getDefaultMethod() {
		return defaultMethod;
	}

	public void setDefaultMethod(Boolean defaultMethod) {
		this.defaultMethod = defaultMethod;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getDescription() {
		return description;
	}

	
	public void setData(Data data) {
		this.data = data;
	}

	public Data getData() {
		return data;
	}

}
