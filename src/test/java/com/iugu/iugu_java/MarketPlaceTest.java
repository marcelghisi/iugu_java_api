package com.iugu.iugu_java;

import java.io.IOException;

import org.jboss.resteasy.util.Base64;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.iugu.IuguFactory;
import com.iugu.model.AccountType;
import com.iugu.model.Address;
import com.iugu.model.Bank;
import com.iugu.model.BankInformation;
import com.iugu.model.BankNumber;
import com.iugu.model.BankSlipConfiguration;
import com.iugu.model.BankUpdate;
import com.iugu.model.CreditCardConfiguration;
import com.iugu.model.LegalPersonData;
import com.iugu.model.MainSetthingsData;
import com.iugu.model.MainSettingsConfiguration;
import com.iugu.model.PersonData;
import com.iugu.model.SubAccount;
import com.iugu.model.SubAccountConfiguration;
import com.iugu.model.SubAccountPriceRange;
import com.iugu.model.SubAccountValidation;
import com.iugu.model.SubAccountValidationData;
import com.iugu.model.SubAccountValidationFiles;
import com.iugu.responses.MessageResponse;
import com.iugu.responses.RequestWithDrawResponse;
import com.iugu.responses.SubAccountInformationResponse;
import com.iugu.responses.SubAccountResponse;
import com.iugu.responses.SubAccountValidationResponse;
import com.iugu.services.MarketPlaceService;

import junit.framework.TestCase;


/**
 * Testa SubAccounts Creation , configutations and validations.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MarketPlaceTest extends TestCase{
	
    public static class IntegratedTest { 
    	
    	private static String tokemTest1;
    	private static String email = "thiagohcortez@gmail.com";
    	private static String invoiceId;
    	private static String customerId;
    	private static String customerPaymentId;
    	private static String subscriptionId;
    	private static String customerPaymentIdB;
    	private static String masterApiTokemTeste = "21ab6ca14384901acaea1793b91cdc98";
    	private static String masterAccountId = "96461997-b6a0-48fb-808b-4f16ad88c718";
    	private static String subAccountId;
    	private static String liveApiToken;
    	private static String testApiToken;
    	private static String userToken;    	
    	
        public void setUserToken(String s) {
        	userToken = s;
        }
        
        public String getUserToken() {
            return userToken;
        }
        
        public void setTestApiToken(String s) {
        	testApiToken = s;
        }
        
        public String getTestApiToken() {
            return testApiToken;
        }
        
        public void setLiveApiToken(String s) {
        	liveApiToken = s;
        }
        
        public String getLiveApiToken() {
            return liveApiToken;
        }
        
        public void setSubAccountId(String s) {
        	subAccountId = s;
        }               
        public String getSubAccountId() {
            return subAccountId;
        }
        
        public void setToken(String s) {
            tokemTest1 = s;
        }               
        public String getToken() {
            return tokemTest1;
        }
        
        public void setCustomerId(String s) {
            customerId = s;
        }               
        public String getCustomerId() {
            return customerId;
        }
        
        public void setSubscriptionId(String s) {
            subscriptionId = s;
        }               
        public String getSubscriptionId() {
            return subscriptionId;
        }
        
        public void setCustomerPaymentId(String s) {
            customerPaymentId = s;
        }               
        public String getCustomerPaymentId() {
            return customerPaymentId;
        }
        
        public void setCustomerPaymentIdB(String s) {
            customerPaymentIdB = s;
        }               
        public String getCustomerPaymentIdB() {
            return customerPaymentIdB;
        }

        public void setApiToken(String s) {
            masterApiTokemTeste = s;
        }               
        public String getApiToken() {
            return masterApiTokemTeste;
        }
        
        public void setMasterAccountId(String s) {
            masterAccountId = s;
        }               
        public String getMasterAccountId() {
            return masterAccountId;
        }
        
        public void setInvoice(String s) {
            invoiceId = s;
        }               
        public String getInvoice() {
            return invoiceId;
        }
        
        public String getEmail() {
            return email;
        }
        
        
    }

    private IntegratedTest integratedTest;

    
    /**
     * Set Up
     * 
     */
    @Override
    protected void setUp() throws Exception {
    	integratedTest = new IntegratedTest();
    }

    /**
     * Cria uma sub conta
     */
	@Test
    public void testA()
    {
		//MarketPlacetest.java#testA
    	//Cria uma sub conta no marketplace
		IuguFactory factory = new IuguFactory();
		SubAccountResponse responseSubAccount = new MarketPlaceService(factory.getMarketPlaceClient()).createSubAccount(new SubAccount("Salão da Meire",0));
		
		assertTrue( responseSubAccount.getId() != null);
		
		integratedTest.setLiveApiToken(responseSubAccount.getLiveApiToken());
		integratedTest.setTestApiToken(responseSubAccount.getTestApiToken());
		integratedTest.setUserToken(responseSubAccount.getUserToken());
		integratedTest.setSubAccountId(responseSubAccount.getId());
    }
    
    /**
     * Encontra uma sub conta
     */
	@Test
    public void testB()
    {
		IuguFactory factory = new IuguFactory();
		SubAccountInformationResponse responseInformation = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).find(integratedTest.getSubAccountId());
		assertTrue( responseInformation.getId() != null);
    }
    
    /**
     * Valida CNPJ invalido
     */
	@Test
    public void testC()
    {

		IuguFactory factory = new IuguFactory();
		
		MainSetthingsData mainSetthingsData = new MainSetthingsData("Serviços de Informática",SubAccountPriceRange.ENTRE_100_500,Boolean.FALSE,Boolean.TRUE);
		LegalPersonData pJ = new LegalPersonData("03125011000171", "GHISI TECNOLOGIA EM SISTEMAS", "Marcel Ghisi", "02479484971", "11-96766-1709");
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		BankInformation bankInfo = new BankInformation(Bank.ITAU, AccountType.Corrente, "0036", "07722-0");
		
		SubAccountValidationData data = new SubAccountValidationData(mainSetthingsData,bankInfo,address,pJ);
		
		SubAccountValidation subAccountValidation = new SubAccountValidation(data, null, Boolean.FALSE);
		
		SubAccountValidationResponse responseSubAccountValidation = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).createSubAccountValidation(integratedTest.getSubAccountId(), subAccountValidation);
		
		assertFalse( responseSubAccountValidation.getSuccess());
		
    }
    
    /**
     * Valida CNPJ valido
     */
	@Test
    public void testD()
    {

		//MarketPlaceTest.java#testD
		IuguFactory factory = new IuguFactory();
		String accountId = integratedTest.getSubAccountId();

		MainSetthingsData mainSetthingsData = new MainSetthingsData("Serviços de Informática",SubAccountPriceRange.ENTRE_100_500,Boolean.FALSE,Boolean.TRUE);
		LegalPersonData pJ = new LegalPersonData("03487102000171", "GHISI TECNOLOGIA EM SISTEMAS", "Marcel Ghisi", "02479484971", "11-96766-1709");
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		BankInformation bankInfo = new BankInformation(Bank.ITAU, AccountType.Corrente, "0036", "07722-0");
		
		String b64 = null; 
		try {
			b64 = Base64.encodeFromFile("//Users//marcel//Desktop/CNH.png");
		} catch (IOException e) {}
		
		//Precisa de um documento PNG  para fazer o teste
		assertNotNull(b64);
		//Dados do SubAccount para validar
		SubAccountValidationData data = new SubAccountValidationData(mainSetthingsData,bankInfo,address,pJ);
		
		//Arquivos com o base 64 das imagens para validar
		SubAccountValidationFiles files = new SubAccountValidationFiles(b64,b64,b64);
		
		SubAccountValidation subAccountValidation = new SubAccountValidation(data, files, Boolean.FALSE);
		
		SubAccountValidationResponse responseSubAccountValidation = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).createSubAccountValidation(accountId, subAccountValidation);
		
		assertTrue(responseSubAccountValidation.getErrors() == null);
		
		assertFalse( responseSubAccountValidation.getSuccess());
		
    }
    
    /**
     * Verifica se esta pendente
     */
	@Test
    public void testE()
    {
		//MarketPlaceTest.java#testE
		IuguFactory factory = new IuguFactory();

		SubAccountInformationResponse responseInformation = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).find(integratedTest.getSubAccountId());
		
		assertTrue( responseInformation.getLastVerificationRequestStatus().contains("pending"));
    }
    
    /**
     * Configure sub Account
     */
	@Test
    public void testF()
    {

		IuguFactory factory = new IuguFactory();

		//Main Settings com todos os ítens nulos
		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration.Builder().build();
		
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration.Builder().active(true).build();
		
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration.Builder().softDescriptor("ATTENDME PJ").build();
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		assertEquals("ATTENDME PJ", responseInformationResp.getConfiguration().getCreditCardConfiguration().getSoftDescriptor());
    }
    
    /**
     * ConfigureKeepSoftDescriptionAndChangeComissionPercentCnpjSubAccount
     */
	@Test
    public void testG()
    {

		IuguFactory factory = new IuguFactory();

		
		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration.Builder().commission(2).build();
		
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration.Builder().active(true).build();

		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration.Builder().build();
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		//Verifica se manteve o SoftDescription
		assertEquals("ATTENDME PJ", responseInformationResp.getConfiguration().getCreditCardConfiguration().getSoftDescriptor());
		//Verifica se alterou o Percentual de comissão da conta
		assertEquals(new Integer(2), responseInformationResp.getConfiguration().getComissionPercent());
    }
    
    /**
     * ConfigureKeepComissionPercentAndChangeAutoWithDraw
     */
	@Test
    public void testH()
    {

		IuguFactory factory = new IuguFactory();


		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration.Builder().autoWithdraw(Boolean.TRUE).build();
		
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration.Builder().active(Boolean.TRUE).build();
		
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration.Builder().build();
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		//Verifica se manteve o SoftDescription
		assertEquals("ATTENDME PJ", responseInformationResp.getConfiguration().getCreditCardConfiguration().getSoftDescriptor());
		//Mantem Percentual do teste acima
		assertEquals(new Integer(2), responseInformationResp.getConfiguration().getComissionPercent());
		//Verifica se alterou o WithDraw para True
		assertEquals(Boolean.TRUE, responseInformationResp.getAutoWithdraw());
    }
    
    /**
     * ConfigureBankSlip
     */
	@Test
    public void testI()
    {

		IuguFactory factory = new IuguFactory();

		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration.Builder().build();
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration.Builder().active(Boolean.TRUE).extraDue(2).reprintExtraDue(2).build();
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration.Builder().build();
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		assertEquals(Boolean.TRUE, responseInformationResp.getConfiguration().getBankSlipConfiguration().getActive());
		assertEquals(new Integer(2), responseInformationResp.getConfiguration().getBankSlipConfiguration().getExtraDue());
		assertEquals(new Integer(2), responseInformationResp.getConfiguration().getBankSlipConfiguration().getReprintExtraDue());
    }
    
    /**
     * ReConfigureBankSlip(
     */
	@Test
    public void testJ()
    {
		
		IuguFactory factory = new IuguFactory();


		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration.Builder().build();
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration.Builder().active(Boolean.FALSE).extraDue(1).reprintExtraDue(1).build();
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration.Builder().build();
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		assertEquals(Boolean.FALSE, responseInformationResp.getConfiguration().getBankSlipConfiguration().getActive());
		assertEquals(new Integer(1), responseInformationResp.getConfiguration().getBankSlipConfiguration().getExtraDue());
		assertEquals(new Integer(1), responseInformationResp.getConfiguration().getBankSlipConfiguration().getReprintExtraDue());
    }
    
    /**
     * ConfigureCreditCard
     */
	@Test
    public void testK()
    {

		IuguFactory factory = new IuguFactory();


		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration.Builder().build();
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration.Builder().build();
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration.Builder().active(Boolean.TRUE)
																							   .softDescriptor("ATTENDCHANG")
																							   .installments(Boolean.TRUE)
																							   .installmentsPassInterest(Boolean.TRUE)
																							   .maxInstallments(10)
																							   .maxInstallmentsWithoutInterest(6)
																							   .twoStepTransaction(Boolean.TRUE)
																							   .build();
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		//Verifica se manteve o SoftDescription
		
		//Mantem Percentual do teste acima
		assertEquals(new Integer(2), responseInformationResp.getConfiguration().getComissionPercent());
		//Verifica se alterou o WithDraw para True
		//assertEquals(Boolean.TRUE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getActive());
		//Descrição na fatura do cartao do cliente
		assertEquals("ATTENDCHANG", responseInformationResp.getConfiguration().getCreditCardConfiguration().getSoftDescriptor());
		//Aceita parcelado
		assertEquals(Boolean.TRUE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getInstallments());
		//Se aceita sem juros
		assertEquals(Boolean.TRUE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getInstallmentsPassInterest());
		//Maximo de parcelas
		assertEquals(new Integer(10), responseInformationResp.getConfiguration().getCreditCardConfiguration().getMaxInstallments());
		//Parcelas sem juros
		assertEquals(new Integer(6), responseInformationResp.getConfiguration().getCreditCardConfiguration().getMaxInstallmentsWithoutInterest());
		//Se bloqueia a transacao em avaliacao para so depois cobrar
		assertEquals(Boolean.TRUE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getTwoStepTransaction());
    }
    
    /**
     * ReConfigureCreditCard
     */
	@Test
    public void testL()
    {

		IuguFactory factory = new IuguFactory();

		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration.Builder().build();
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration.Builder().build();
		
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration.Builder().active(Boolean.TRUE)
				   .softDescriptor("ATTENDCH")
				   .installments(Boolean.FALSE)
				   .installmentsPassInterest(Boolean.FALSE)
				   .maxInstallments(12)
				   .maxInstallmentsWithoutInterest(8)
				   .twoStepTransaction(Boolean.FALSE)
				   .build();
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		//Verifica se alterou o WithDraw para True
		//assertEquals(Boolean.TRUE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getActive());
		//Descrição na fatura do cartao do cliente
		assertEquals("ATTENDCH", responseInformationResp.getConfiguration().getCreditCardConfiguration().getSoftDescriptor());
		//Aceita parcelado
		assertEquals(Boolean.FALSE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getInstallments());
		//Se aceita sem juros
		assertEquals(Boolean.FALSE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getInstallmentsPassInterest());
		//Maximo de parcelas
		assertEquals(new Integer(12), responseInformationResp.getConfiguration().getCreditCardConfiguration().getMaxInstallments());
		//Parcelas sem juros
		assertEquals(new Integer(8), responseInformationResp.getConfiguration().getCreditCardConfiguration().getMaxInstallmentsWithoutInterest());
		//Se bloqueia a transacao em avaliacao para so depois cobrar
		assertEquals(Boolean.FALSE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getTwoStepTransaction());
    }
    
    /**
     * CreatePFTesteSubAccount
     */
	@Test
    public void testM()
    {

		IuguFactory factory = new IuguFactory();
		
		SubAccountResponse responseSubAccount = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).createSubAccount(new SubAccount("Noeli Ghisi",1));
		
		assertTrue( responseSubAccount.getId() != null);
		
		System.out.println("TESTANDO CREATE SUBACCOUNT");
		System.out.println(" ACCOUNT ID: " + responseSubAccount.getId() + ";");
		System.out.println(" LIVE TOKEN: " + responseSubAccount.getLiveApiToken()+ ";");
		System.out.println(" TEST TOKEN: " + responseSubAccount.getTestApiToken()+ ";");
		System.out.println(" USER TOKEN: " + responseSubAccount.getTestApiToken()+ ";");

		
		System.out.println("TESTANDO VALIDATE CNPJ");
		System.out.print(" Message: " + responseSubAccount.getMessage() + ";");
		System.out.print(" Success: " + responseSubAccount.getSuccess()+ ";");
		System.out.print(" Code: " + responseSubAccount.getStatusCode()+ ";");
		
		System.out.println("END CERATION SUB ACCOUNT");
		
    }
    
    /**
     * FindSubAccountPF
     */
	@Test
    public void testN()
    {
	
		IuguFactory factory = new IuguFactory();

		
		SubAccountInformationResponse responseInformation = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).find(integratedTest.getSubAccountId());
		
		System.out.println("TESTANDO FIND SUBACCOUNT");
		System.out.print(" ID: " + responseInformation.getId() + ";");
		System.out.print(" Name: " + responseInformation.getName()+ ";");
		
		assertTrue( responseInformation.getId() != null);
    }
    
    /**
     * ValidateCPFInvalidoSubAccount
     */
	@Test
    public void testO()
    {

		IuguFactory factory = new IuguFactory();
		
		String accountId = integratedTest.getSubAccountId();

		MainSetthingsData mainSetthingsData = new MainSetthingsData("Serviços de Manicure",SubAccountPriceRange.ENTRE_100_500,Boolean.FALSE,Boolean.TRUE);
		PersonData pF = new PersonData("123.123.123-12","NOELI OLIVA XAVIER GHISI","11-3399-5090");
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		BankInformation bankInfo = new BankInformation(Bank.BRADESCO, AccountType.Corrente, "0138-4", "0174016-4");
		
		SubAccountValidationData data = new SubAccountValidationData(mainSetthingsData,bankInfo,address,pF);
		//SubAccountValidationFiles files = new SubAccountValidationFiles(CPF_VOVO_HELIO_BASE64,null,PROVE_ACTIVITY_BASE64);
		//SubAccountValidationFiles files = new SubAccountValidationFiles();
		
		SubAccountValidation subAccountValidation = new SubAccountValidation(data, null, Boolean.FALSE);
		
		SubAccountValidationResponse responseSubAccountValidation = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).createSubAccountValidation(accountId, subAccountValidation);
		
		//assertTrue(responseSubAccountValidation.getErrors().get("cpf") != null);
		
		assertFalse( responseSubAccountValidation.getSuccess());
    }
    
    /**
     * ValidateCPFValidoSubAccount(
     */
	@Test
    public void testP()
    {

		IuguFactory factory = new IuguFactory();
		
		String accountId = integratedTest.getSubAccountId();

		MainSetthingsData mainSetthingsData = new MainSetthingsData("Serviços de Manicure",SubAccountPriceRange.ENTRE_100_500,Boolean.FALSE,Boolean.TRUE);
		PersonData pF = new PersonData("18788209822","NOELI OLIVA XAVIER GHISI","11-3399-5090");
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		BankInformation bankInfo = new BankInformation(Bank.BRADESCO, AccountType.Corrente, "0138-4", "0174016-4");
		
		SubAccountValidationData data = new SubAccountValidationData(mainSetthingsData,bankInfo,address,pF);
		//SubAccountValidationFiles files = new SubAccountValidationFiles(CPF_VOVO_HELIO_BASE64,null,PROVE_ACTIVITY_BASE64);
		//SubAccountValidationFiles files = new SubAccountValidationFiles();
		
		SubAccountValidation subAccountValidation = new SubAccountValidation(data, null, Boolean.FALSE);
		
		SubAccountValidationResponse responseSubAccountValidation = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).createSubAccountValidation(accountId, subAccountValidation);
		
		assertTrue(responseSubAccountValidation.getErrors() == null);
		
		assertFalse( responseSubAccountValidation.getSuccess());
    }
    
    /**
     * VerifyIsPendingVerificationForCPF
     */
	@Test
    public void testQ()
    {

		IuguFactory factory = new IuguFactory();
		
		SubAccountInformationResponse responseInformation = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).find(integratedTest.getSubAccountId());
		
		assertTrue( responseInformation.getLastVerificationRequestStatus().contains("pending"));
    }
    
    /**
     * ConfigureSoftDescriptionSubAccount
     */
	@Test
    public void testR()
    {

		IuguFactory factory = new IuguFactory();

		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration.Builder().build();
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration.Builder().active(Boolean.TRUE).build();
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration.Builder().softDescriptor("ATTENDME PF").build();
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		assertEquals("ATTENDME PF", responseInformationResp.getConfiguration().getCreditCardConfiguration().getSoftDescriptor());
    }
	
    /**
     * UpdateBankDataDocumentBlankPF
     */
	@Test
    public void testS()
    {
		IuguFactory factory = new IuguFactory();
		
		String b64 = null; 
		try {
			b64 = Base64.encodeFromFile("//Users//marcel//Desktop/CNH.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BankUpdate bankUpdate = new BankUpdate(BankNumber.CAIXA, AccountType.Corrente, "0246","12358",b64,Boolean.TRUE);
		
		MessageResponse responseInformationBank = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).updateBankInformation(bankUpdate);
		
		assertTrue(responseInformationBank.getErrors() == null);
    }
    
    /**
     * RequestWithDraw
     */
	@Test
    public void testT()
    {

		IuguFactory factory = new IuguFactory();
		
		String accountId = integratedTest.getSubAccountId();

		RequestWithDrawResponse responseWithDraw = new MarketPlaceService(factory.getClientWithToken(integratedTest.getUserToken())).createWithDrawRequest(accountId, new Double(1));

		assertTrue( responseWithDraw.getAmount() != null);
		

    }
    


}
