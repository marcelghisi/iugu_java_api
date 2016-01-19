package com.iugu.responses;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageResponse {

	private Boolean success;
	
	private String message;
	
	private Integer statusCode;
	
	private Map<String,Object> errors;



	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//@JsonDeserialize(using=PropertyMapDeserializer.class) 
	public void setErrors(Map<String, Object> errors) {
		this.errors = errors;
	}


	public Map<String, Object> getErrors() {
		return errors;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	
	
}