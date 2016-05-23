package com.iugu.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.iugu.IuguFactory;
import com.iugu.model.Plan;
import com.iugu.responses.ListPlanResponse;
import com.iugu.responses.PlanResponse;

public class PlanService extends BaseService{

	private final String CREATE_URL = IuguFactory.generateEndPointUrl("/plans");
	private final String FIND_URL = IuguFactory.generateEndPointUrl("/plans/%s");
	private final String FIND_BY_IDENTIFIER_URL = IuguFactory.generateEndPointUrl("/plans/identifier/%s");
	private final String CHANGE_URL = IuguFactory.generateEndPointUrl("/plans/%s");
	private final String REMOVE_URL = IuguFactory.generateEndPointUrl("/plans/%s");
	private final String LIST_URL = IuguFactory.generateEndPointUrl("/plans");
	
	private Client client = null;
	
	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public PlanService(Client client) {
		super();
		this.setClient(client);
	}
	
	public PlanResponse create(Plan plan) {
		Response response = this.client
				.target(CREATE_URL)
				.request()
				.post(Entity.entity(plan, MediaType.APPLICATION_JSON));
		
		PlanResponse subscriptionResponse = (PlanResponse) readResponse(response, PlanResponse.class);

		return subscriptionResponse;
	}
	
	public PlanResponse find(String id) {
		Response response = this.client
				.target(String.format(FIND_URL, id))
				.request()
				.get();
		
		PlanResponse subscriptionResponse = (PlanResponse) readResponse(response, PlanResponse.class);

		return subscriptionResponse;
	}
	
	public PlanResponse findByIdentifier(String id) {
		Response response = this.client
				.target(String.format(FIND_BY_IDENTIFIER_URL, id))
				.request()
				.get();
		
		PlanResponse subscriptionResponse = (PlanResponse) readResponse(response, PlanResponse.class);

		return subscriptionResponse;
	}
	
	public PlanResponse change(String id, Plan plan) {
		Response response = this.client
				.target(String.format(CHANGE_URL, id))
				.request()
				.put(Entity.entity(plan, MediaType.APPLICATION_JSON));
		
		PlanResponse subscriptionResponse = (PlanResponse) readResponse(response, PlanResponse.class);

		return subscriptionResponse;
	}
	
	public PlanResponse remove(String id) {
		Response response = this.client.target(String.format(REMOVE_URL, id))
		 .request()
		 .delete();
		
		PlanResponse subscriptionResponse = (PlanResponse) readResponse(response, PlanResponse.class);

		return subscriptionResponse;
	}
	
	public ListPlanResponse list() {
		Response response = this.client
				.target(LIST_URL)
				.request()
				.get();
		
		ListPlanResponse paymentResponse = (ListPlanResponse) readResponse(
				response, ListPlanResponse.class);

		return paymentResponse;
	}
}