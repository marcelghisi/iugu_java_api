package com.iugu.services;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.iugu.responses.MessageResponse;

public class BaseService {

	protected <T> Object readResponse(Response response,Class<T> clazz){
		
		MessageResponse messageResponse = null;
		
		try {messageResponse = (MessageResponse) clazz.newInstance();} catch (Exception e) {}
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			//TODO Melhorar isso Acontece porque a API Rest devolve Erros em Types diferentes Lista e Texto
			if (responseEntity.startsWith("{\"errors\":\"")){

				Map<String,Object> mapa = new HashMap<String,Object>(0);
				mapa.put("errors", responseEntity);
				messageResponse.setSuccess(Boolean.FALSE);
				messageResponse.setStatusCode(response.getStatus());
				messageResponse.setMessage(response.getStatusInfo().toString());
				messageResponse.setErrors(mapa);
				return messageResponse;
			}
			
			Gson gson = new Gson();

			MessageResponse responseReturn = (MessageResponse) gson.fromJson(responseEntity, clazz);
			
			if (responseReturn.getSuccess() != null && !responseReturn.getSuccess() && responseReturn.getMessage() != null && !responseReturn.getMessage().isEmpty() ){
				Map<String,Object> mapa = new HashMap<String,Object>(0);
				mapa.put("errors", responseReturn.getMessage());
				responseReturn.setStatusCode(response.getStatus());
				responseReturn.setMessage(responseReturn.getMessage());
				responseReturn.setErrors(mapa);
				return responseReturn;
			}
			//TODO A API Rest não envia empre o atributo success. Podia ser melhorado
			if (response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.TRUE);
			} else if(response.getStatus() == 200){
				responseReturn.setSuccess(Boolean.FALSE);
			}
			response.close();
			return responseReturn;
		}
		
		messageResponse.setSuccess(Boolean.FALSE);
		messageResponse.setStatusCode(response.getStatus());
		messageResponse.setMessage(response.getStatusInfo().toString());

		return messageResponse;
	}
	
}
