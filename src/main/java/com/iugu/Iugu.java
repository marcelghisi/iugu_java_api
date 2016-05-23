package com.iugu;

public class Iugu {

	private static Iugu _instance;
	
	public  String  apiUrl;
	public  String  marketPlaceToken = "";
	public  String  marketPlaceTokenTest = "21ab6ca14384901acaea1793b91cdc98";
	public  String  marketPlaceAccountId = "96461997-b6a0-48fb-808b-4f16ad88c718";	
	public  Enviroment enviroment = Enviroment.TEST;
	
	private Iugu() {
		this.setApiUrl("https://api.iugu.com/v1");
		this.setEnviroment(Enviroment.TEST);
		this.setMarketPlaceAccountId("96461997-b6a0-48fb-808b-4f16ad88c718");
		this.setMarketPlaceToken("");
		this.setMarketPlaceTokenTest("21ab6ca14384901acaea1793b91cdc98");
		
	}
	
	private Iugu(String apiUrl,Enviroment enviroment,String marketPlaceAccountId,String marketPlaceToken,String marketPlaceTokenTest) {
		this.setApiUrl(apiUrl);
		this.setEnviroment(enviroment);
		this.setMarketPlaceAccountId(marketPlaceAccountId);
		this.setMarketPlaceToken(marketPlaceToken);
		this.setMarketPlaceTokenTest(marketPlaceTokenTest);
		
	}
	
	public static synchronized Iugu getInstance() {
		if (_instance == null)
			_instance = new Iugu();

		return _instance;
	}
	

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getMarketPlaceToken() {
		return marketPlaceToken;
	}

	public void setMarketPlaceToken(String marketPlaceToken) {
		this.marketPlaceToken = marketPlaceToken;
	}

	public String getMarketPlaceTokenTest() {
		return marketPlaceTokenTest;
	}

	public void setMarketPlaceTokenTest(String marketPlaceTokenTest) {
		this.marketPlaceTokenTest = marketPlaceTokenTest;
	}

	public String getMarketPlaceAccountId() {
		return marketPlaceAccountId;
	}

	public void setMarketPlaceAccountId(String marketPlaceAccountId) {
		this.marketPlaceAccountId = marketPlaceAccountId;
	}

	public Enviroment getEnviroment() {
		return enviroment;
	}

	public void setEnviroment(Enviroment enviroment) {
		this.enviroment = enviroment;
	}
	
}



