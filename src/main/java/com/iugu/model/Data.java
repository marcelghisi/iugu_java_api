package com.iugu.model;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.annotations.SerializedName;

public class Data {

	public Data(String number, String verificationValue, String firstName, String lastName, String month, String year) {
		this.number = number;
		this.verificationValue = verificationValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.month = month;
		this.year = year;
	}

	String number;

	
	@JsonProperty("verification_value")
	@SerializedName("verification_value")
	String verificationValue;

	
	@JsonProperty("first_name")
	@SerializedName("first_name")
	String firstName;

	
	@JsonProperty("last_name")
	@SerializedName("last_name")
	String lastName;

	
	String month;

	String year;

	public String getNumber() {
		return number;
	}

	public String getVerificationValue() {
		return verificationValue;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

}
