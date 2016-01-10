package com.iugu.services;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
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
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				SubAccountResponse messageResponse = new SubAccountResponse();
				Map<String,String> mapa = new HashMap<String,String>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				return messageResponse;
			}
			
			Gson gson = new Gson();

			SubAccountResponse responseReturn = gson.fromJson(responseEntity, SubAccountResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			return responseReturn;
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
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				SubAccountValidationResponse messageResponse = new SubAccountValidationResponse();
				Map<String,String> mapa = new HashMap<String,String>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				return messageResponse;
			}
			
			Gson gson = new Gson();

			SubAccountValidationResponse responseReturn = gson.fromJson(responseEntity, SubAccountValidationResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			return responseReturn;
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

		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				SubAccountInformationResponse messageResponse = new SubAccountInformationResponse();
				Map<String,String> mapa = new HashMap<String,String>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				return messageResponse;
			}
			
			Gson gson = new Gson();

			SubAccountInformationResponse responseReturn = gson.fromJson(responseEntity, SubAccountInformationResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			return responseReturn;
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
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				SubAccountInformationResponse messageResponse = new SubAccountInformationResponse();
				Map<String,String> mapa = new HashMap<String,String>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				return messageResponse;
			}
			
			Gson gson = new Gson();

			SubAccountInformationResponse responseReturn = gson.fromJson(responseEntity, SubAccountInformationResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			return responseReturn;
		}
		
		SubAccountInformationResponse messageResponse = new SubAccountInformationResponse();
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
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				SubAccountInformationResponse messageResponse = new SubAccountInformationResponse();
				Map<String,String> mapa = new HashMap<String,String>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				return messageResponse;
			}
			
			Gson gson = new Gson();

			SubAccountInformationResponse responseReturn = gson.fromJson(responseEntity, SubAccountInformationResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			return responseReturn;
		}
		
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		response.close();
		
		return messageResponse;
	}
	
	public RequestWithDrawResponse createWithDrawRequest(String subAccountId,Double withDrawValue) {

		DecimalFormat df = new DecimalFormat("#.0");
		
		Form form = new Form();
		form.param("amount", df.format(withDrawValue.doubleValue()));

		Response response = Iugu.getClient().target(String.format(REQUEST_WITHDRAW, subAccountId)).request()
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				RequestWithDrawResponse messageResponse = new RequestWithDrawResponse();
				Map<String,String> mapa = new HashMap<String,String>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				return messageResponse;
			}
			
			Gson gson = new Gson();

			RequestWithDrawResponse responseReturn = gson.fromJson(responseEntity, RequestWithDrawResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			response.close();
			return responseReturn;
		}
		
		RequestWithDrawResponse messageResponse = new RequestWithDrawResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		return messageResponse;
	}
	

	

}