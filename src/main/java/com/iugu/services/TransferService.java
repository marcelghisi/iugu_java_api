package com.iugu.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.iugu.IuguFactory;
import com.iugu.model.ListSubscriptionCriteria;
import com.iugu.model.Transfer;
import com.iugu.responses.ListTransferResponse;
import com.iugu.responses.TransferResponse;

public class TransferService extends BaseService{

	private final String TRANSFER_URL = IuguFactory.generateEndPointUrl("/transfers");
	private final String LIST_TRANSFER_URL = IuguFactory.generateEndPointUrl("/transfers");


	private Client client = null;
	
	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public TransferService(Client client) {
		super();
		this.setClient(client);
	}
	
	public TransferResponse transfer(String receiverAccountId,Integer transferCents) {
		
		Transfer transfer = new Transfer(receiverAccountId,transferCents);
		
		Response response = this.client
				.target(TRANSFER_URL)
				.request()
				.post(Entity.entity(transfer, MediaType.APPLICATION_JSON));
		
		TransferResponse customerResponse = (TransferResponse) readResponse(response, TransferResponse.class);
		
		return customerResponse;
	}
	
	public ListTransferResponse list(ListSubscriptionCriteria criteria) {

		WebTarget target = this.client.target(LIST_TRANSFER_URL);
		Response response = target.request().get();

		ListTransferResponse transferResponse = (ListTransferResponse) readResponse(
				response, ListTransferResponse.class);

		return transferResponse;
	}

	
	
}