package com.iugu.model;


import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.gson.annotations.SerializedName;
import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;

public class Item {

	private String id;
	
	private String description;
	
	private Integer quantity;
	
	@JsonProperty("price_cents")
	@SerializedName("price_cents")
	private Integer priceCents;
	
	@JsonProperty("created_at")
	@JsonFormat("yyyy-MM-dd'T'HH:mm:ssZ") 
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("created_at")
	private Date createdAt;
	
	@JsonProperty("updated_at")
	@JsonFormat("yyyy-MM-dd'T'HH:mm:ssZ") 
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("updated_at")
	private Date updatedAt;
	
	private String price;
	
	
	@JsonProperty("_destroy")
	@SerializedName("_destroy")
	private Boolean destroy;
	

	public Item(String description, Integer quantity, Integer priceCents) {
		this.description = description;
		this.quantity = quantity;
		this.priceCents = priceCents;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPriceCents() {
		return priceCents;
	}

	public void setPriceCents(Integer priceCents) {
		this.priceCents = priceCents;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	public Boolean getDestroy() {
		return destroy;
	}
	
	public void setDestroy(Boolean destroy) {
		this.destroy = destroy;
	}
	

	
}
