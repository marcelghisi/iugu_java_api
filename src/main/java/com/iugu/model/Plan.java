package com.iugu.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

public class Plan {

	private String name;

	private String identifier;

	private Integer interval;

	@JsonProperty("interval_type")
	@SerializedName("interval_type")
	private IntervalType intervalType;

	private Currency currency;

	@JsonProperty("value_cents")
	@SerializedName("value_cents")
	private int valueCents;

	@JsonProperty("payable_with")
	@SerializedName("payable_with")
	private PayableWith payableWith;

	private List<Price> prices;

	private List<Feature> features;

	public Plan(String name, String identifier, Integer interval, IntervalType intervalType, Currency currency,
			int valueCents) {
		this.name = name;
		this.identifier = identifier;
		this.interval = interval;
		this.intervalType = intervalType;
		this.currency = currency;
		this.valueCents = valueCents;
	}

	public String getName() {
		return name;
	}

	public String getIdentifier() {
		return identifier;
	}

	public Integer getInterval() {
		return interval;
	}

	public IntervalType getIntervalType() {
		return intervalType;
	}

	public Currency getCurrency() {
		return currency;
	}

	public int getValueCents() {
		return valueCents;
	}

	public PayableWith getPayableWith() {
		return payableWith;
	}

	public void setPayableWith(PayableWith payableWith) {
		this.payableWith = payableWith;
	}

	public List<Price> getPrices() {
		return prices;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

}
