package com.iugu.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.iugu.IuguFactory;
import com.iugu.model.DirectCharge;
import com.iugu.model.PaymentToken;
import com.iugu.responses.ChargeResponse;
import com.iugu.responses.PaymentTokenResponse;

public class PaymentService extends BaseService{

	private final String CREATE_TOKEN_URL = IuguFactory.generateEndPointUrl("/payment_token");
	private final String CREATE_DIRECT_CHARGE_URL = IuguFactory.generateEndPointUrl("/charge");
	
	private Client client = null;
	
	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public PaymentService(Client client) {
		super();
		this.setClient(client);
	}
	
	public PaymentTokenResponse createToken(PaymentToken payment) {
		
		Response response = this.client
				.target(CREATE_TOKEN_URL)
				.request()
				.post(Entity.entity(payment, MediaType.APPLICATION_JSON));
		
		PaymentTokenResponse tokenResponse = (PaymentTokenResponse) readResponse(response, PaymentTokenResponse.class);
		
		return tokenResponse;
	}
	
	public ChargeResponse createDirectCharge(DirectCharge payment) {
		Response response = this.client
				.target(CREATE_DIRECT_CHARGE_URL)
				.request()
				.post(Entity.entity(payment, MediaType.APPLICATION_JSON));
		
		ChargeResponse directResponse = (ChargeResponse) readResponse(response, ChargeResponse.class);
		
		return directResponse;
	}
}