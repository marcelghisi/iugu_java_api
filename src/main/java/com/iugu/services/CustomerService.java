package com.iugu.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iugu.Iugu;
import com.iugu.IuguFactory;
import com.iugu.model.Customer;
import com.iugu.model.PaymentMethodRequest;
import com.iugu.responses.CustomerResponse;
import com.iugu.responses.PaymentMethodResponse;

public class CustomerService extends BaseService{

	private final String CREATE_URL = IuguFactory.generateEndPointUrl("/customers");
	private final String FIND_URL = IuguFactory.generateEndPointUrl("/customers/%s");
	private final String CHANGE_URL = IuguFactory.generateEndPointUrl("/customers/%s");
	private final String REMOVE_URL = IuguFactory.generateEndPointUrl("/customers/%s");
	private final String ADD_PAYMENT_METHOD_URL = IuguFactory.generateEndPointUrl("/customers/%s/payment_methods");
	private final String FIND_PAYMENT_METHOD_URL = IuguFactory.generateEndPointUrl("/customers/%s/payment_methods/%s");
	private final String CHANGE_PAYMENT_METHOD_URL = IuguFactory.generateEndPointUrl("/customers/%s/payment_methods/%s");
	private final String REMOVE_PAYMENT_METHOD_URL = IuguFactory.generateEndPointUrl("/customers/%s/payment_methods/%s");
	private final String LIST_PAYMENT_METHOD_URL  = IuguFactory.generateEndPointUrl("/customers/%s/payment_methods");
	
	private Client client = null;
	
	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public CustomerService(Client client) {
		super();
		this.setClient(client);
	}
	
	public CustomerResponse create(Customer customer) {
		Response response = this.client
				.target(CREATE_URL)
				.request()
				.post(Entity.entity(customer, MediaType.APPLICATION_JSON));
		
		CustomerResponse customerResponse = (CustomerResponse) readResponse(response, CustomerResponse.class);
		
		return customerResponse;
	}
	
	public CustomerResponse find(String id) {
		Response response = this.client
				.target(String.format(FIND_URL, id))
				.request()
				.get();
		
		CustomerResponse customerResponse = (CustomerResponse) readResponse(response, CustomerResponse.class);
		
		return customerResponse;
	}
	
	public CustomerResponse change(String customerId, Customer customer) {
		Response response = this.client
				.target(String.format(CHANGE_URL, customerId))
				.request()
				.put(Entity.entity(customer, MediaType.APPLICATION_JSON));
		
		CustomerResponse customerResponse = (CustomerResponse) readResponse(response, CustomerResponse.class);
		
		return customerResponse;
	}
	
	public CustomerResponse remove(String id) {
		Response response = this.client.target(String.format(REMOVE_URL, id))
		 .request()
		 .delete();
		
		CustomerResponse customerResponse = (CustomerResponse) readResponse(response, CustomerResponse.class);
		
		return customerResponse;
	}
	
	public PaymentMethodResponse createPaymentMethod(PaymentMethodRequest request) {
		Response response = this.client
				.target(String.format(ADD_PAYMENT_METHOD_URL, request.getCustomerId()))
				.request()
				.post(Entity.entity(request, MediaType.APPLICATION_JSON));
		
		PaymentMethodResponse paymentResponse = (PaymentMethodResponse) readResponse(response, PaymentMethodResponse.class);
		
		return paymentResponse;
	}
	
	public PaymentMethodResponse findPaymentMethod(String customerId,String paymentMethodId) {
		Response response = this.client
				.target(String.format(FIND_PAYMENT_METHOD_URL, customerId,paymentMethodId))
				.request()
				.get();
		
		PaymentMethodResponse paymentResponse = (PaymentMethodResponse) readResponse(response, PaymentMethodResponse.class);
		
		return paymentResponse;
	}
	
	public PaymentMethodResponse changePaymentMethod(String customerId, String paymentMethodId,String newDescription) {
		
		PaymentMethodRequest request = new PaymentMethodRequest(null, null, newDescription, null);
		
		Response response = this.client
				.target(String.format(CHANGE_PAYMENT_METHOD_URL, customerId,paymentMethodId))
				.request()
				.put(Entity.entity(request, MediaType.APPLICATION_JSON));
		
		PaymentMethodResponse paymentResponse = (PaymentMethodResponse) readResponse(response, PaymentMethodResponse.class);
		
		return paymentResponse;
	}
	
	public PaymentMethodResponse removePaymentMethod(String customerId,String paymentId) {
		Response response = this.client.target(String.format(REMOVE_PAYMENT_METHOD_URL, customerId,paymentId))
		 .request()
		 .delete();
		
		PaymentMethodResponse paymentResponse = (PaymentMethodResponse) readResponse(response, PaymentMethodResponse.class);
		
		return paymentResponse;
	}
	
	public List<PaymentMethodResponse> listPaymentMethod(String customerId) {
		Response response = this.client
				.target(String.format(LIST_PAYMENT_METHOD_URL, customerId))
				.request()
				.get();
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			Gson gson = new Gson();

			Type listType = new TypeToken<ArrayList<PaymentMethodResponse>>() {}.getType();

            List<PaymentMethodResponse> responseList = gson.fromJson(responseEntity, listType);
			
			return responseList;
		}

		return null;
	}
	

	
	
}