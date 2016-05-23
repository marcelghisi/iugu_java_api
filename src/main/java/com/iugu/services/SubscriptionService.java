package com.iugu.services;

import java.text.SimpleDateFormat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.iugu.IuguFactory;
import com.iugu.model.Credit;
import com.iugu.model.ListSubscriptionCriteria;
import com.iugu.model.Subscription;
import com.iugu.responses.ListSubscriptionResponse;
import com.iugu.responses.SubscriptionResponse;

public class SubscriptionService extends BaseService{

	private final String CREATE_URL = IuguFactory.generateEndPointUrl("/subscriptions");
	private final String LIST_URL = IuguFactory.generateEndPointUrl("/subscriptions");
	private final String FIND_URL = IuguFactory.generateEndPointUrl("/subscriptions/%s");
	private final String CHANGE_URL = IuguFactory.generateEndPointUrl("/subscriptions/%s");
	private final String REMOVE_URL = IuguFactory.generateEndPointUrl("/subscriptions/%s");
	private final String SUSPEND_URL = IuguFactory.generateEndPointUrl("/subscriptions/%s/suspend");
	private final String ACTIVATE_URL = IuguFactory.generateEndPointUrl("/subscriptions/%s/activate");
	private final String CHANGE_SUBSCRIPTION_PLAN_URL = IuguFactory.generateEndPointUrl("/subscriptions/%s/change_plan/%s");
	private final String ADD_CREDITS_URL = IuguFactory.generateEndPointUrl("/subscriptions/%s/add_credits");
	private final String REMOVE_CREDITS_URL = IuguFactory.generateEndPointUrl("/subscriptions/%s/remove_credits");

	
	private Client client = null;
	
	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public SubscriptionService(Client client) {
		super();
		this.setClient(client);
	}
	
	public SubscriptionResponse create(Subscription subscription) {
		
		Gson gson = new Gson();  
		String json = gson.toJson(subscription);

		System.out.println("+++ Prepare Request" + json);
		
		Response response = this.client
				.target(CREATE_URL)
				.request()
				.post(Entity.entity(json, MediaType.APPLICATION_JSON));
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public SubscriptionResponse find(String id) {
		Response response = this.client
				.target(String.format(FIND_URL, id))
				.request()
				.get();
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public SubscriptionResponse change(String id, Subscription subscription) {
		
		Gson gson = new Gson();  
		String json = gson.toJson(subscription);
		System.out.println("+++ Prepare Request" + json);
		
		Response response = this.client
				.target(String.format(CHANGE_URL, id))
				.request()
				.put(Entity.entity(json, MediaType.APPLICATION_JSON));
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public SubscriptionResponse remove(String id) {
		Response response = this.client.target(String.format(REMOVE_URL, id))
		 .request()
		 .delete();
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public SubscriptionResponse suspend(String id) {
		Response response = this.client.target(String.format(SUSPEND_URL, id))
		 .request()
		 .post(null);
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public SubscriptionResponse activate(String id) {
		Response response = this.client.target(String.format(ACTIVATE_URL, id))
		 .request()
		 .post(null);
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public SubscriptionResponse changePlan(String id, String planIdentifier) {
		Response response = this.client.target(String.format(CHANGE_SUBSCRIPTION_PLAN_URL, id, planIdentifier))
		 .request()
		 .post(null);
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public SubscriptionResponse addCredits(String id, Integer newCredits) {
		
		Credit credit = new Credit(newCredits);
		
		Gson gson = new Gson();  
		String json = gson.toJson(credit);
		System.out.println("+++ Prepare Request" + json);
		
		Response response = this.client.target(String.format(ADD_CREDITS_URL, id))
		 .request()
		 .put(Entity.entity(json, MediaType.APPLICATION_JSON));
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public SubscriptionResponse removeCredits(String id, Integer newCredits) {
		
		Credit credit = new Credit(newCredits);
		
		Response response = this.client.target(String.format(REMOVE_CREDITS_URL, id))
		 .request()
		 .put(Entity.entity(credit, MediaType.APPLICATION_JSON));
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public ListSubscriptionResponse list(ListSubscriptionCriteria criteria) {

		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");

		WebTarget target = this.client.target(LIST_URL);
		
		if (criteria.getCustomerId() != null){
			target = target.queryParam("customer_id", criteria.getCustomerId());
		}
		if (criteria.getLimit() != null){
			target = target.queryParam("limit", criteria.getLimit());
		}
		if (criteria.getStart() != null){
			target = target.queryParam("start", criteria.getStart());
		}
		if (criteria.getCreatedAtFrom() != null){
			target = target.queryParam("created_at_from", sm.format(criteria.getCreatedAtFrom()));
		}
		if (criteria.getCreatedAtTo() != null){
			target = target.queryParam("created_at_to", sm.format(criteria.getCreatedAtTo()));
		}
		if (criteria.getUpdatedSince() != null){
			target = target.queryParam("updated_since", sm.format(criteria.getUpdatedSince()));
		}
		if (criteria.getQuery() != null){
			target = target.queryParam("query", criteria.getQuery());
		}
		if (criteria.getSortBy() != null){
			target = target.queryParam("sortBy", criteria.getSortBy());
		}
		
		Response response = target.request().get();

		ListSubscriptionResponse paymentResponse = (ListSubscriptionResponse) readResponse(
				response, ListSubscriptionResponse.class);

		return paymentResponse;
	}

}