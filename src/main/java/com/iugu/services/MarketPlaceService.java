package com.iugu.services;

import java.text.DecimalFormat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.iugu.IuguFactory;
import com.iugu.model.BankUpdate;
import com.iugu.model.SubAccount;
import com.iugu.model.SubAccountConfiguration;
import com.iugu.model.SubAccountValidation;
import com.iugu.responses.MessageResponse;
import com.iugu.responses.RequestWithDrawResponse;
import com.iugu.responses.SubAccountInformationResponse;
import com.iugu.responses.SubAccountResponse;
import com.iugu.responses.SubAccountValidationResponse;

public class MarketPlaceService extends BaseService{

	private final String CREATE_SUB_ACCOUNT_URL = IuguFactory.generateEndPointUrl("/marketplace/create_account");
	private final String BANK_VERIFICATION = IuguFactory.generateEndPointUrl("/bank_verification");
	private final String CREATE_SUB_ACCOUNT_VALIDATION_URL = IuguFactory.generateEndPointUrl("/accounts/%s/request_verification");
	private final String FIND_URL = IuguFactory.generateEndPointUrl("/accounts/%s");
	private final String CONFIGURE_URL = IuguFactory.generateEndPointUrl("/accounts/configuration");
	private final String REQUEST_WITHDRAW = IuguFactory.generateEndPointUrl("/accounts/%s/request_withdraw");
	
	private Client client = null;
	
	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public MarketPlaceService(Client client) {
		super();
		this.setClient(client);
	}

	public SubAccountResponse createSubAccount(SubAccount account) {
		
		Response response = this.client
				.target(CREATE_SUB_ACCOUNT_URL)
				.request()
				.post(Entity.entity(account, MediaType.APPLICATION_JSON));
		
		SubAccountResponse subAccountResponse = (SubAccountResponse) readResponse(response, SubAccountResponse.class);
		
		return subAccountResponse;
	}
	
	public SubAccountValidationResponse createSubAccountValidation(String subAccountId,SubAccountValidation validation) {
		
		Response response = this.client
				.target(String.format(CREATE_SUB_ACCOUNT_VALIDATION_URL, subAccountId))
				.request()
				.post(Entity.entity(validation, MediaType.APPLICATION_JSON));
		
		SubAccountValidationResponse subAccountResponse = (SubAccountValidationResponse) readResponse(response, SubAccountValidationResponse.class);
		
		return subAccountResponse;
	}
	
	public SubAccountInformationResponse find(String subAccountId) {
		
		Response response = this.client.target(String.format(FIND_URL, subAccountId)).request().get();

		SubAccountInformationResponse subAccountResponse = (SubAccountInformationResponse) readResponse(response, SubAccountInformationResponse.class);
		
		return subAccountResponse;
	}
	
	public SubAccountInformationResponse configureSubAccount(SubAccountConfiguration account) {
		
		Response response = this.client
				.target(CONFIGURE_URL)
				.request()
				.post(Entity.entity(account, MediaType.APPLICATION_JSON));
		
		SubAccountInformationResponse subAccountResponse = (SubAccountInformationResponse) readResponse(response, SubAccountInformationResponse.class);
		
		return subAccountResponse;
	}
	
	public MessageResponse updateBankInformation(BankUpdate bankData) {
		Response response = this.client
				.target(BANK_VERIFICATION)
				.request()
				.post(Entity.entity(bankData, MediaType.APPLICATION_JSON));
		
		MessageResponse messageResponse = (MessageResponse) readResponse(response, MessageResponse.class);
		
		return messageResponse;
	}
	
	public RequestWithDrawResponse createWithDrawRequest(String subAccountId,Double withDrawValue) {

		DecimalFormat df = new DecimalFormat("#.0");
		
		Form form = new Form();
		form.param("amount", df.format(withDrawValue.doubleValue()));

		Response response = this.client.target(String.format(REQUEST_WITHDRAW, subAccountId)).request()
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

		RequestWithDrawResponse withResponse = (RequestWithDrawResponse) readResponse(response, RequestWithDrawResponse.class);
		
		return withResponse;
	}
	

	

}