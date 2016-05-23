package com.iugu;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import com.iugu.filter.LoggingFilter;

public class IuguFactory {

	public Client getMarketPlaceClient() {
		
		String marketPlaceToken = null;
		
		if (Iugu.getInstance().getEnviroment() == Enviroment.TEST){
			marketPlaceToken = Iugu.getInstance().getMarketPlaceTokenTest();
		} else if (Iugu.getInstance().getEnviroment() == Enviroment.PRODUCTION){
			marketPlaceToken = Iugu.getInstance().getMarketPlaceToken();			
		} else {
			try {
				throw new Exception("Token not defined");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Client client = ClientBuilder.newClient()
                .register(new Authenticator(marketPlaceToken, ""));
		client.register(new LoggingFilter());
		
		return client;
	}
	
	public Client getClientWithToken(String userToken) {
		Client client = ClientBuilder.newClient()
                .register(new Authenticator(userToken, ""));
		client.register(new LoggingFilter());
		
		return client;
	}
	
	public static String generateEndPointUrl(String endpoint) {
		return Iugu.getInstance().getApiUrl() + endpoint;
	}
	
}
