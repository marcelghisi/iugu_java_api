package com.iugu.model;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;
import com.iugu.responses.SubItemResponse;

public class SubItem {

	private String id;
	
	private String description;

	private Integer quantity;
	

	@JsonProperty("price_cents")
	@SerializedName("price_cents")
	private Integer priceCents;

	private boolean recurrent;

	@JsonProperty("_destroy")
	@SerializedName("_destroy")
	private Boolean destroy;
	
	public SubItem(SubItemResponse subItem) {
		this.id = subItem.getId();
		this.description = subItem.getDescription();
		this.quantity = subItem.getQuantity();
		this.priceCents = subItem.getPriceCents();
	}
	
	public SubItem(String description, Integer quantity, Integer priceCents) {
		this.description = description;
		this.quantity = quantity;
		this.priceCents = priceCents;
	}

	public String getDescription() {
		return description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Integer getPriceCents() {
		return priceCents;
	}

	public boolean isRecurrent() {
		return recurrent;
	}

	public void setRecurrent(boolean recurrent) {
		this.recurrent = recurrent;
	}

	public Boolean getDestroy() {
		return destroy;
	}

	public void setDestroy(Boolean destroy) {
		this.destroy = destroy;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setPriceCents(Integer priceCents) {
		this.priceCents = priceCents;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
