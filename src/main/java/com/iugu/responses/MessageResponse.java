package com.iugu.responses;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageResponse {

	private Boolean success;
	
	private String message;
	
	private Integer statusCode;
	
	@JsonProperty("errors")
	private Map<String,String> errorsInMap;



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

	public Map<String, String> getErrorsInMap() {
		return errorsInMap;
	}

	public void setErrorsInMap(Map<String, String> errorsInMap) {
		this.errorsInMap = errorsInMap;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	
	
}