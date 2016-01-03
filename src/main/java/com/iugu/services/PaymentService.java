package com.iugu.services;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.iugu.Iugu;
import com.iugu.model.DirectCharge;
import com.iugu.model.PaymentToken;
import com.iugu.responses.ChargeResponse;
import com.iugu.responses.PaymentTokenResponse;

public class PaymentService {

	private final String CREATE_TOKEN_URL = Iugu.url("/payment_token");
	private final String CREATE_DIRECT_CHARGE_URL = Iugu.url("/charge");
	
	public PaymentTokenResponse createToken(PaymentToken payment) {
		Response response = Iugu.getClient()
				.target(CREATE_TOKEN_URL)
				.request()
				.post(Entity.entity(payment, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200) {
			return response.readEntity(PaymentTokenResponse.class);
		}

		return null; //FIXME Tratar retornos de erro
	}
	
	public ChargeResponse createDirectCharge(DirectCharge payment) {
		Response response = Iugu.getClient()
				.target(CREATE_DIRECT_CHARGE_URL)
				.request()
				.post(Entity.entity(payment, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200) {
			return response.readEntity(ChargeResponse.class);
		}

		response.close();
		return null; //FIXME Tratar retornos de erro
	}
}