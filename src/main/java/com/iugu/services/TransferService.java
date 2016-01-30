package com.iugu.services;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.iugu.Iugu;
import com.iugu.model.ListSubscriptionCriteria;
import com.iugu.model.Transfer;
import com.iugu.responses.ListTransferResponse;
import com.iugu.responses.TransferResponse;

public class TransferService extends BaseService{

	private final String TRANSFER_URL = Iugu.url("/transfers");
	private final String LIST_TRANSFER_URL = Iugu.url("/transfers");

	
	public TransferResponse transfer(String receiverAccountId,Integer transferCents) {
		
		Transfer transfer = new Transfer(receiverAccountId,transferCents);
		
		Response response = Iugu.getClient()
				.target(TRANSFER_URL)
				.request()
				.post(Entity.entity(transfer, MediaType.APPLICATION_JSON));
		
		TransferResponse customerResponse = (TransferResponse) readResponse(response, TransferResponse.class);
		
		return customerResponse;
	}
	
	public ListTransferResponse list(ListSubscriptionCriteria criteria) {

		WebTarget target = Iugu.getClient().target(LIST_TRANSFER_URL);
		Response response = target.request().get();

		ListTransferResponse transferResponse = (ListTransferResponse) readResponse(
				response, ListTransferResponse.class);

		return transferResponse;
	}

	
	
}