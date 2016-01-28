package com.iugu.services;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.iugu.Iugu;
import com.iugu.model.Credit;
import com.iugu.model.Subscription;
import com.iugu.responses.SubscriptionResponse;

public class SubscriptionService extends BaseService{

	private final String CREATE_URL = Iugu.url("/subscriptions");
	private final String FIND_URL = Iugu.url("/subscriptions/%s");
	private final String CHANGE_URL = Iugu.url("/subscriptions/%s");
	private final String REMOVE_URL = Iugu.url("/subscriptions/%s");
	private final String SUSPEND_URL = Iugu.url("/subscriptions/%s/suspend");
	private final String ACTIVATE_URL = Iugu.url("/subscriptions/%s/activate");
	private final String CHANGE_SUBSCRIPTION_PLAN_URL = Iugu.url("/subscriptions/%s/change_plan/%s");
	private final String ADD_CREDITS_URL = Iugu.url("/subscriptions/%s/add_credits");
	private final String REMOVE_CREDITS_URL = Iugu.url("/subscriptions/%s/remove_credits");
	
	public SubscriptionResponse create(Subscription subscription) {
		
		Gson gson = new Gson();  
		String json = gson.toJson(subscription);

		System.out.println("+++ Prepare Request" + json);
		
		Response response = Iugu.getClient()
				.target(CREATE_URL)
				.request()
				.post(Entity.entity(json, MediaType.APPLICATION_JSON));
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public SubscriptionResponse find(String id) {
		Response response = Iugu.getClient()
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
		
		Response response = Iugu.getClient()
				.target(String.format(CHANGE_URL, id))
				.request()
				.put(Entity.entity(json, MediaType.APPLICATION_JSON));
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public SubscriptionResponse remove(String id) {
		Response response = Iugu.getClient().target(String.format(REMOVE_URL, id))
		 .request()
		 .delete();
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public SubscriptionResponse suspend(String id) {
		Response response = Iugu.getClient().target(String.format(SUSPEND_URL, id))
		 .request()
		 .post(null);
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public SubscriptionResponse activate(String id) {
		Response response = Iugu.getClient().target(String.format(ACTIVATE_URL, id))
		 .request()
		 .post(null);
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public SubscriptionResponse changePlan(String id, String planIdentifier) {
		Response response = Iugu.getClient().target(String.format(CHANGE_SUBSCRIPTION_PLAN_URL, id, planIdentifier))
		 .request()
		 .post(null);
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public SubscriptionResponse addCredits(String id, Credit credit) {
		Response response = Iugu.getClient().target(String.format(ADD_CREDITS_URL, id))
		 .request()
		 .post(Entity.entity(credit, MediaType.APPLICATION_JSON));
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	public SubscriptionResponse removeCredits(String id, Credit credit) {
		Response response = Iugu.getClient().target(String.format(REMOVE_CREDITS_URL, id))
		 .request()
		 .post(Entity.entity(credit, MediaType.APPLICATION_JSON));
		
		SubscriptionResponse subscriptionResponse = (SubscriptionResponse) readResponse(response, SubscriptionResponse.class);
		
		return subscriptionResponse;
	}
	
	//TODO Listar as assinaturas

}