package com.iugu.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iugu.Iugu;
import com.iugu.model.Customer;
import com.iugu.model.PaymentMethodRequest;
import com.iugu.responses.CustomerResponse;
import com.iugu.responses.PaymentMethodResponse;

public class CustomerService {

	private final String CREATE_URL = Iugu.url("/customers");
	private final String FIND_URL = Iugu.url("/customers/%s");
	private final String CHANGE_URL = Iugu.url("/customers/%s");
	private final String REMOVE_URL = Iugu.url("/customers/%s");
	private final String ADD_PAYMENT_METHOD_URL = Iugu.url("/customers/%s/payment_methods");
	private final String FIND_PAYMENT_METHOD_URL = Iugu.url("/customers/%s/payment_methods/%s");
	private final String CHANGE_PAYMENT_METHOD_URL = Iugu.url("/customers/%s/payment_methods/%s");
	private final String REMOVE_PAYMENT_METHOD_URL = Iugu.url("/customers/%s/payment_methods/%s");
	private final String LIST_PAYMENT_METHOD_URL  = Iugu.url("/customers/%s/payment_methods");
	
	public CustomerResponse create(Customer customer) {
		Response response = Iugu.getClient()
				.target(CREATE_URL)
				.request()
				.post(Entity.entity(customer, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				CustomerResponse messageResponse = new CustomerResponse();
				Map<String,Object> mapa = new HashMap<String,Object>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				messageResponse.setErrors(mapa);
				return messageResponse;
			}
			
			Gson gson = new Gson();

			CustomerResponse responseReturn = gson.fromJson(responseEntity, CustomerResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
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

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				CustomerResponse messageResponse = new CustomerResponse();
				Map<String,Object> mapa = new HashMap<String,Object>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				messageResponse.setErrors(mapa);
				return messageResponse;
			}
			
			Gson gson = new Gson();

			CustomerResponse responseReturn = gson.fromJson(responseEntity, CustomerResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
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

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				CustomerResponse messageResponse = new CustomerResponse();
				Map<String,Object> mapa = new HashMap<String,Object>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				messageResponse.setErrors(mapa);
				return messageResponse;
			}
			
			Gson gson = new Gson();

			CustomerResponse responseReturn = gson.fromJson(responseEntity, CustomerResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
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

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				CustomerResponse messageResponse = new CustomerResponse();
				Map<String,Object> mapa = new HashMap<String,Object>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				messageResponse.setErrors(mapa);
				return messageResponse;
			}
			
			Gson gson = new Gson();

			CustomerResponse responseReturn = gson.fromJson(responseEntity, CustomerResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
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
	
	public PaymentMethodResponse createPaymentMethod(PaymentMethodRequest request) {
		Response response = Iugu.getClient()
				.target(String.format(ADD_PAYMENT_METHOD_URL, request.getCustomerId()))
				.request()
				.post(Entity.entity(request, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				PaymentMethodResponse messageResponse = new PaymentMethodResponse();
				Map<String,Object> mapa = new HashMap<String,Object>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				messageResponse.setErrors(mapa);
				return messageResponse;
			}
			
			Gson gson = new Gson();

			PaymentMethodResponse responseReturn = gson.fromJson(responseEntity, PaymentMethodResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			return responseReturn;
		}

		PaymentMethodResponse messageResponse = new PaymentMethodResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		response.close();
		return messageResponse;
	}
	
	public PaymentMethodResponse findPaymentMethod(String customerId,String paymentMethodId) {
		Response response = Iugu.getClient()
				.target(String.format(FIND_PAYMENT_METHOD_URL, customerId,paymentMethodId))
				.request()
				.get();
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				PaymentMethodResponse messageResponse = new PaymentMethodResponse();
				Map<String,Object> mapa = new HashMap<String,Object>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				messageResponse.setErrors(mapa);
				return messageResponse;
			}
			
			Gson gson = new Gson();

			PaymentMethodResponse responseReturn = gson.fromJson(responseEntity, PaymentMethodResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			return responseReturn;
		}

		PaymentMethodResponse messageResponse = new PaymentMethodResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		response.close();
		return messageResponse;
	}
	
	public PaymentMethodResponse changePaymentMethod(String id, String paymentMethodId,String newDescription) {
		
		PaymentMethodRequest request = new PaymentMethodRequest(null, null, newDescription, null);
		
		Response response = Iugu.getClient()
				.target(String.format(CHANGE_PAYMENT_METHOD_URL, id,paymentMethodId))
				.request()
				.put(Entity.entity(request, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				PaymentMethodResponse messageResponse = new PaymentMethodResponse();
				Map<String,Object> mapa = new HashMap<String,Object>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				messageResponse.setErrors(mapa);
				return messageResponse;
			}
			
			Gson gson = new Gson();

			PaymentMethodResponse responseReturn = gson.fromJson(responseEntity, PaymentMethodResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			return responseReturn;
		}

		PaymentMethodResponse messageResponse = new PaymentMethodResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		response.close();
		return messageResponse;
	}
	
	public PaymentMethodResponse removePaymentMethod(String customerId,String paymentId) {
		Response response = Iugu.getClient().target(String.format(REMOVE_PAYMENT_METHOD_URL, customerId,paymentId))
		 .request()
		 .delete();
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				PaymentMethodResponse messageResponse = new PaymentMethodResponse();
				Map<String,Object> mapa = new HashMap<String,Object>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				messageResponse.setErrors(mapa);
				return messageResponse;
			}
			
			Gson gson = new Gson();

			PaymentMethodResponse responseReturn = gson.fromJson(responseEntity, PaymentMethodResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			return responseReturn;
		}

		PaymentMethodResponse messageResponse = new PaymentMethodResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		response.close();
		return messageResponse;
	}
	
	public List<PaymentMethodResponse> listPaymentMethod(String customerId) {
		Response response = Iugu.getClient()
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