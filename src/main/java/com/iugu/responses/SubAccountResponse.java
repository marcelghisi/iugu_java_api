package com.iugu.responses;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubAccountResponse extends MessageResponse{

	@JsonProperty("account_id")
	private String id;
	
	private String name;
	
	@JsonProperty("live_api_token")
	private String liveApiToken;
	
	@JsonProperty("test_api_token")
	private String testApiToken;
	
	@JsonProperty("user_token")
	private String userToken;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLiveApiToken() {
		return liveApiToken;
	}

	public void setLiveApiToken(String liveApiToken) {
		this.liveApiToken = liveApiToken;
	}

	public String getTestApiToken() {
		return testApiToken;
	}

	public void setTestApiToken(String testApiToken) {
		this.testApiToken = testApiToken;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}


	
}