package com.iugu.responses;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.gson.annotations.SerializedName;
import com.iugu.model.Receiver;
import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferResponse extends MessageResponse{
	
	private String id;
	
	@JsonProperty("created_at")
	@JsonFormat("yyyy-MM-dd'T'HH:mm:ssZ") 
	@JsonSerialize(using = DateSerializer.class)
	@SerializedName("created_at")
	private Date createdAt;
	
	@JsonProperty("amount_cents")
	@SerializedName("amount_cents")
	private Integer amountCents;
	
	@JsonProperty("amount_localized")
	@SerializedName("amount_localized")
	private String amountLocalized;
	
	private Receiver receiver;
	
	private Receiver sender;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getAmountCents() {
		return amountCents;
	}

	public void setAmountCents(Integer amountCents) {
		this.amountCents = amountCents;
	}

	public String getAmountLocalized() {
		return amountLocalized;
	}

	public void setAmountLocalized(String amountLocalized) {
		this.amountLocalized = amountLocalized;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public Receiver getSender() {
		return sender;
	}

	public void setSender(Receiver sender) {
		this.sender = sender;
	}



}