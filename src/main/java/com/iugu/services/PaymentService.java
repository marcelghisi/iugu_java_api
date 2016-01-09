package com.iugu.services;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.iugu.Iugu;
import com.iugu.model.DirectCharge;
import com.iugu.model.PaymentToken;
import com.iugu.model.SubAccountValidation;
import com.iugu.responses.ChargeResponse;
import com.iugu.responses.PaymentTokenResponse;
import com.iugu.responses.SubAccountValidationResponse;

public class PaymentService {

	private final String CREATE_TOKEN_URL = Iugu.url("/payment_token");
	private final String CREATE_DIRECT_CHARGE_URL = Iugu.url("/charge");
	
	public PaymentTokenResponse createToken(PaymentToken payment) {
		
		Response response = Iugu.getClient()
				.target(CREATE_TOKEN_URL)
				.request()
				.post(Entity.entity(payment, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			if (responseEntity.startsWith("{\"errors\":\"")){
				PaymentTokenResponse messageResponse = new PaymentTokenResponse();
				Map<String,String> mapa = new HashMap<String,String>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				return messageResponse;
			}
			
			Gson gson = new Gson();

			PaymentTokenResponse responseReturn = gson.fromJson(responseEntity, PaymentTokenResponse.class);
			
			if (response.getStatus() == 422){
				responseReturn.setSuccess(Boolean.FALSE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			}
			response.close();
			return responseReturn;
		}
		
		PaymentTokenResponse messageResponse = new PaymentTokenResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		return messageResponse;
	}
	
	public ChargeResponse createDirectCharge(DirectCharge payment) {
		Response response = Iugu.getClient()
				.target(CREATE_DIRECT_CHARGE_URL)
				.request()
				.post(Entity.entity(payment, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			if (responseEntity.startsWith("{\"errors\":\"")){
				ChargeResponse messageResponse = new ChargeResponse();
				Map<String,String> mapa = new HashMap<String,String>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				return messageResponse;
			}
			
			Gson gson = new Gson();

			ChargeResponse responseReturn = gson.fromJson(responseEntity, ChargeResponse.class);
			
			if (response.getStatus() == 422){
				responseReturn.setSuccess(Boolean.FALSE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			}
			response.close();
			return responseReturn;
		}
		
		ChargeResponse messageResponse = new ChargeResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		return messageResponse;
	}
}