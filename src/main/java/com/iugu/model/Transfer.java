package com.iugu.model;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

public class Transfer {

	@JsonProperty("receiver_id")
	@SerializedName("receiver_id")
	private String receiverId;

	@JsonProperty("amount_cents")
	@SerializedName("amount_cents")
	private int amountCents;

	public Transfer(String receiverId, int amountCents) {
		this.receiverId = receiverId;
		this.amountCents = amountCents;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public int getAmountCents() {
		return amountCents;
	}

}
