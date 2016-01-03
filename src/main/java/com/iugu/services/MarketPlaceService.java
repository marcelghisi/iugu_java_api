package com.iugu.services;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.iugu.Iugu;
import com.iugu.model.BankUpdate;
import com.iugu.model.SubAccount;
import com.iugu.model.SubAccountConfiguration;
import com.iugu.model.SubAccountValidation;
import com.iugu.responses.MessageResponse;
import com.iugu.responses.RequestWithDrawResponse;
import com.iugu.responses.SubAccountInformationResponse;
import com.iugu.responses.SubAccountResponse;
import com.iugu.responses.SubAccountValidationResponse;

public class MarketPlaceService {

	private final String CREATE_SUB_ACCOUNT_URL = Iugu.url("/marketplace/create_account");
	private final String BANK_VERIFICATION = Iugu.url("/bank_verification");
	private final String CREATE_SUB_ACCOUNT_VALIDATION_URL = Iugu.url("/accounts/%s/request_verification");
	private final String FIND_URL = Iugu.url("/accounts/%s");
	private final String CONFIGURE_URL = Iugu.url("/accounts/configuration");
	private final String REQUEST_WITHDRAW = Iugu.url("/accounts/%s/request_withdraw");
	
	public SubAccountResponse createSubAccount(SubAccount account) {
		
		Response response = Iugu.getClient()
				.target(CREATE_SUB_ACCOUNT_URL)
				.request()
				.post(Entity.entity(account, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200) {
			return response.readEntity(SubAccountResponse.class);
		}
		SubAccountResponse messageResponse = new SubAccountResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		response.close();
		
		return messageResponse;
	}
	
	public SubAccountValidationResponse createSubAccountValidation(String subAccountId,SubAccountValidation validation) {
		
		Response response = Iugu.getClient()
				.target(String.format(CREATE_SUB_ACCOUNT_VALIDATION_URL, subAccountId))
				.request()
				.post(Entity.entity(validation, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200) {
			return response.readEntity(SubAccountValidationResponse.class);
		}
		SubAccountValidationResponse messageResponse = new SubAccountValidationResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		response.close();
		return messageResponse;
	}
	
	public SubAccountInformationResponse find(String subAccountId) {
		
		Response response = Iugu.getClient().target(String.format(FIND_URL, subAccountId)).request().get();

		if (response.getStatus() == 200) {
			return response.readEntity(SubAccountInformationResponse.class);
		}

		SubAccountInformationResponse messageResponse = new SubAccountInformationResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		response.close();
		return messageResponse;
	}
	
	public SubAccountInformationResponse configureSubAccount(SubAccountConfiguration account) {
		
		Response response = Iugu.getClient()
				.target(CONFIGURE_URL)
				.request()
				.post(Entity.entity(account, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200) {
			return response.readEntity(SubAccountInformationResponse.class);
		}
		
		SubAccountInformationResponse messageResponse = new SubAccountInformationResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		response.close();
		return messageResponse;
	}
	
	public RequestWithDrawResponse createWithDrawRequest(String subAccountId,Integer centsValue) {

		Form form = new Form();
		form.param("amount", centsValue.toString());

		Response response = Iugu.getClient().target(String.format(REQUEST_WITHDRAW, subAccountId)).request()
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

		if (response.getStatus() == 200) {
			return response.readEntity(RequestWithDrawResponse.class);
		}
		
		RequestWithDrawResponse messageResponse = new RequestWithDrawResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		response.close();
		return messageResponse;
	}
	
	public MessageResponse updateBankInformation(BankUpdate bankData) {
		Response response = Iugu.getClient()
				.target(BANK_VERIFICATION)
				.request()
				.post(Entity.entity(bankData, MediaType.APPLICATION_JSON));
		
		
//		System.out.println(Entity.entity(bankData, MediaType.APPLICATION_JSON).getEncoding().toString());
		
// 	   String respContent = "";
//	   
// 	   if (response.hasEntity())
// 	    respContent = response.readEntity(String.class);
// 	  
// 	   System.out.println("Response--> " + respContent);
 	   
		if(response.getStatus() == 200) {
			return response.readEntity(MessageResponse.class);
		}
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		response.close();
		
		return messageResponse;
	}
	

}