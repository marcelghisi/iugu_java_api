package com.iugu.responses;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.iugu.model.SubAccountValidationData;
import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubAccountValidationResponse extends MessageResponse{

	//Codigo da verificacao
	private String id;
	
	@JsonProperty("account_id")
	private String accountId;
	
	/**
	 * Data de Expiração (DD/MM/AAAA)
	 */
	@JsonProperty("created_at")
	@JsonFormat("dd/MM/yyyy")
	@JsonSerialize(using = DateSerializer.class)
	private Date createdAt;
	
	private SubAccountValidationData data;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public SubAccountValidationData getData() {
		return data;
	}

	public void setData(SubAccountValidationData data) {
		this.data = data;
	}

	
}