package com.iugu.responses;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;
import com.iugu.model.Data;

public class PaymentMethodResponse extends MessageResponse{

	private String id;

	private String description;

	private Data data;

	@JsonProperty("item_type")
	@SerializedName("item_type")
	private String itemType;

	private String token;

	@JsonProperty("set_as_default")
	@SerializedName("set_as_default")
	private Boolean defaultMethod;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
