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
import com.iugu.model.Plan;
import com.iugu.responses.CustomerResponse;
import com.iugu.responses.InvoiceResponse;
import com.iugu.responses.PaymentMethodResponse;
import com.iugu.responses.PlanResponse;

public class PlanService {

	private final String CREATE_URL = Iugu.url("/plans");
	private final String FIND_URL = Iugu.url("/plans/%s");
	private final String FIND_BY_IDENTIFIER_URL = Iugu.url("/plans/identifier/%s");
	private final String CHANGE_URL = Iugu.url("/plans/%s");
	private final String REMOVE_URL = Iugu.url("/plans/%s");
	
	public PlanResponse create(Plan plan) {
		Response response = Iugu.getClient()
				.target(CREATE_URL)
				.request()
				.post(Entity.entity(plan, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				PlanResponse messageResponse = new PlanResponse();
				Map<String,Object> mapa = new HashMap<String,Object>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				messageResponse.setErrors(mapa);
				return messageResponse;
			}
			
			Gson gson = new Gson();

			PlanResponse responseReturn = gson.fromJson(responseEntity, PlanResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			response.close();
			return responseReturn;
		}

		PlanResponse messageResponse = new PlanResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		return messageResponse;
	}
	
	public PlanResponse find(String id) {
		Response response = Iugu.getClient()
				.target(String.format(FIND_URL, id))
				.request()
				.get();
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				PlanResponse messageResponse = new PlanResponse();
				Map<String,Object> mapa = new HashMap<String,Object>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				messageResponse.setErrors(mapa);
				return messageResponse;
			}
			
			Gson gson = new Gson();

			PlanResponse responseReturn = gson.fromJson(responseEntity, PlanResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			response.close();
			return responseReturn;
		}

		PlanResponse messageResponse = new PlanResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		return messageResponse;
	}
	
	public PlanResponse findByIdentifier(String id) {
		Response response = Iugu.getClient()
				.target(String.format(FIND_BY_IDENTIFIER_URL, id))
				.request()
				.get();
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				PlanResponse messageResponse = new PlanResponse();
				Map<String,Object> mapa = new HashMap<String,Object>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				messageResponse.setErrors(mapa);
				return messageResponse;
			}
			
			Gson gson = new Gson();

			PlanResponse responseReturn = gson.fromJson(responseEntity, PlanResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			response.close();
			return responseReturn;
		}

		PlanResponse messageResponse = new PlanResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		return messageResponse;
	}
	
	public PlanResponse change(String id, Plan plan) {
		Response response = Iugu.getClient()
				.target(String.format(CHANGE_URL, id))
				.request()
				.put(Entity.entity(plan, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				PlanResponse messageResponse = new PlanResponse();
				Map<String,Object> mapa = new HashMap<String,Object>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				messageResponse.setErrors(mapa);
				return messageResponse;
			}
			
			Gson gson = new Gson();

			PlanResponse responseReturn = gson.fromJson(responseEntity, PlanResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			response.close();
			return responseReturn;
		}

		PlanResponse messageResponse = new PlanResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		return messageResponse;
	}
	
	public PlanResponse remove(String id) {
		Response response = Iugu.getClient().target(String.format(REMOVE_URL, id))
		 .request()
		 .delete();
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){
				PlanResponse messageResponse = new PlanResponse();
				Map<String,Object> mapa = new HashMap<String,Object>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				messageResponse.setErrors(mapa);
				return messageResponse;
			}
			
			Gson gson = new Gson();

			PlanResponse responseReturn = gson.fromJson(responseEntity, PlanResponse.class);
			
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			response.close();
			return responseReturn;
		}

		PlanResponse messageResponse = new PlanResponse();
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		return messageResponse;
	}
	
	//TODO Listar os planos
}