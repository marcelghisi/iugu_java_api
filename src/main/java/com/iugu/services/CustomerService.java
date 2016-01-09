package com.iugu.services;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.iugu.Iugu;
import com.iugu.model.Customer;
import com.iugu.model.Invoice;
import com.iugu.responses.CustomerResponse;
import com.iugu.responses.InvoiceResponse;
import com.iugu.responses.SubAccountInformationResponse;

public class CustomerService {

	private final String CREATE_URL = Iugu.url("/customers");
	private final String FIND_URL = Iugu.url("/customers/%s");
	private final String CHANGE_URL = Iugu.url("/customers/%s");
	private final String REMOVE_URL = Iugu.url("/customers/%s");
	
	public CustomerResponse create(Customer customer) {
		Response response = Iugu.getClient()
				.target(CREATE_URL)
				.request()
				.post(Entity.entity(customer, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			if (responseEntity.startsWith("{\"errors\":\"")){
				CustomerResponse messageResponse = new CustomerResponse();
				Map<String,String> mapa = new HashMap<String,String>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				return messageResponse;
			}
			
			Gson gson = new Gson();

			CustomerResponse responseReturn = gson.fromJson(responseEntity, CustomerResponse.class);
			
			if (response.getStatus() == 422){
				responseReturn.setSuccess(Boolean.FALSE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			}
			return responseReturn;
		}

		CustomerResponse messageResponse = new CustomerResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		response.close();
		return messageResponse;
	}
	
	public CustomerResponse find(String id) {
		Response response = Iugu.getClient()
				.target(String.format(FIND_URL, id))
				.request()
				.get();
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			if (responseEntity.startsWith("{\"errors\":\"")){
				CustomerResponse messageResponse = new CustomerResponse();
				Map<String,String> mapa = new HashMap<String,String>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				return messageResponse;
			}
			
			Gson gson = new Gson();

			CustomerResponse responseReturn = gson.fromJson(responseEntity, CustomerResponse.class);
			
			if (response.getStatus() == 422){
				responseReturn.setSuccess(Boolean.FALSE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			}
			return responseReturn;
		}

		CustomerResponse messageResponse = new CustomerResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		response.close();
		return messageResponse;
	}
	
	public CustomerResponse change(String id, Customer customer) {
		Response response = Iugu.getClient()
				.target(String.format(CHANGE_URL, id))
				.request()
				.put(Entity.entity(customer, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			if (responseEntity.startsWith("{\"errors\":\"")){
				CustomerResponse messageResponse = new CustomerResponse();
				Map<String,String> mapa = new HashMap<String,String>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				return messageResponse;
			}
			
			Gson gson = new Gson();

			CustomerResponse responseReturn = gson.fromJson(responseEntity, CustomerResponse.class);
			
			if (response.getStatus() == 422){
				responseReturn.setSuccess(Boolean.FALSE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			}
			return responseReturn;
		}

		CustomerResponse messageResponse = new CustomerResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		response.close();
		return messageResponse;
	}
	
	public CustomerResponse remove(String id) {
		Response response = Iugu.getClient().target(String.format(REMOVE_URL, id))
		 .request()
		 .delete();
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			if (responseEntity.startsWith("{\"errors\":\"")){
				CustomerResponse messageResponse = new CustomerResponse();
				Map<String,String> mapa = new HashMap<String,String>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				return messageResponse;
			}
			
			Gson gson = new Gson();

			CustomerResponse responseReturn = gson.fromJson(responseEntity, CustomerResponse.class);
			
			if (response.getStatus() == 422){
				responseReturn.setSuccess(Boolean.FALSE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			}
			return responseReturn;
		}

		CustomerResponse messageResponse = new CustomerResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		response.close();
		return messageResponse;
	}
	
	//TODO Listar os clientes
}