package com.iugu.iugu_java;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.iugu.Iugu;
import com.iugu.model.Address;
import com.iugu.model.BankSlipConfiguration;
import com.iugu.model.CreditCardConfiguration;
import com.iugu.model.Customer;
import com.iugu.model.Data;
import com.iugu.model.DuplicateInvoiceRequest;
import com.iugu.model.DuplicateItemsInvoiceRequest;
import com.iugu.model.Invoice;
import com.iugu.model.Item;
import com.iugu.model.ListInvoiceCriteria;
import com.iugu.model.MainSettingsConfiguration;
import com.iugu.model.PayableWith;
import com.iugu.model.Payer;
import com.iugu.model.PaymentToken;
import com.iugu.model.SubAccount;
import com.iugu.model.SubAccountConfiguration;
import com.iugu.model.Subscription;
import com.iugu.model.TokenDirectCharge;
import com.iugu.responses.ChargeResponse;
import com.iugu.responses.CustomerResponse;
import com.iugu.responses.InvoiceResponse;
import com.iugu.responses.ListInvoiceResponse;
import com.iugu.responses.PaymentTokenResponse;
import com.iugu.responses.SubAccountInformationResponse;
import com.iugu.responses.SubAccountResponse;
import com.iugu.responses.SubscriptionResponse;
import com.iugu.services.CustomerService;
import com.iugu.services.InvoiceService;
import com.iugu.services.MarketPlaceService;
import com.iugu.services.PaymentService;
import com.iugu.services.SubscriptionService;

/**
 * Testa CRUD de métodos de pagamento.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InvoicesTest extends TestCase{
	
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
    	
		Iugu.init(integratedTest.getApiToken());
		
		//Cria cliente
		Customer customer = new Customer("ARTHUR GHISI","arthur.ghisi@gmail.com","02479484971");
		CustomerResponse responseCustomer = new CustomerService().create(customer);
		assertTrue( responseCustomer.getId() != null);
		
		integratedTest.setCustomerId(responseCustomer.getId());
		
		//Cria subscription
		Subscription subs = new Subscription.Builder().customerId(responseCustomer.getId()).planIdentifier("plano_basico").build();
		
		SubscriptionResponse subsResponse = new SubscriptionService().create(subs);
		assertTrue( subsResponse.getId() != null);
		integratedTest.setSubscriptionId(subsResponse.getId());

		//Cria uma subconta para tester captura de invoice 2 tempos
		SubAccountResponse responseSubAccount = new MarketPlaceService().createSubAccount(new SubAccount("Marcel Ghisi",1));
		integratedTest.setLiveApiToken(responseSubAccount.getLiveApiToken());
		integratedTest.setTestApiToken(responseSubAccount.getTestApiToken());
		integratedTest.setUserToken(responseSubAccount.getUserToken());
		integratedTest.setSubAccountId(responseSubAccount.getId());
		
		//Configura a subconta para criar invoices em 2 tempos
		Iugu.init(responseSubAccount.getUserToken());

		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration(null, null, null, null, null, null, null, null);
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration(null, null, null);
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration(Boolean.TRUE,"ATTENDCHANG", Boolean.TRUE,Boolean.TRUE,10,6,Boolean.TRUE);
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService().configureSubAccount(subAccountConfiguration);
		
    	assertTrue(responseInformationResp != null);
    }
    
    /**
     * Cria um customer para testar a criação da carteira dele
     */
	@Test
    public void testA()
    {
    	
    	integratedTest = new IntegratedTest();
    	
		Iugu.init(integratedTest.getApiToken());
		
		Customer customer = new Customer("THIAGO HENRIQUE",integratedTest.getEmail(),"02479484971");

		CustomerResponse responseCustomer = new CustomerService().create(customer);
    	
    	//Valida se o tokem foi criado
    	assertTrue(responseCustomer != null);
    	
    	//Valida se não retornou erros
    	assertTrue(responseCustomer.getErrors() == null);
    	
    	//Valida se não ocorreu erro 500
    	assertTrue(responseCustomer.getStatusCode() == null);
    	
    	integratedTest.setCustomerId(responseCustomer.getId());
    }

    /**
     * Cria invoice simples com e-mail data de vencimento e 1 item
     */
	@Test
    public void testB()
    {
		//Funfa cria fatura e envia boleto com invoice
		Iugu.init(integratedTest.getApiToken());
		
		Item item2 = new Item("Cafe",1,1200);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item2);
		
		Invoice inv = new Invoice.Builder(integratedTest.getEmail(), new Date(), items).build();
		
		InvoiceResponse response = new InvoiceService().create(inv);
        
		assertTrue( response != null );
    }
	
    /**
     * Cria invoice simples com e-mail data de vencimento e 1 item
     */
	@Test
    public void testC()
    {
		Iugu.init(integratedTest.getApiToken());
		
		Item item2 = new Item("Cafe Perigina",1,490);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item2);
		
		Calendar data = Calendar.getInstance();
        data.add(Calendar.DAY_OF_MONTH, 1);
		
		Invoice inv = new Invoice.Builder(integratedTest.getEmail(), data.getTime(), items).build();
		
		InvoiceResponse response = new InvoiceService().create(inv);
        
		assertTrue( response != null );
    }
    
    /**
     * Cria invoice para um customer cadastrado na conta master
     */
	@Test
    public void testD()
    {
		Iugu.init(integratedTest.getApiToken());
		
		Item item2 = new Item("Cafe Brazil Cacau",1,110);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item2);
		
		Invoice inv = new Invoice.Builder(integratedTest.getEmail(), new Date(), items).customerId(integratedTest.getApiToken()).build();
		
		InvoiceResponse response = new InvoiceService().create(inv);
        
		assertTrue( response != null );
    }
    
    /**
     * Cria invoice associada a uma asinatura especifica 
     */
	@Test
    public void testE()
    {
		Iugu.init(integratedTest.getApiToken());
		
		Item item2 = new Item("Cafe Nespresso",1,220);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item2);
		
		Invoice inv = new Invoice.Builder(integratedTest.getEmail(), new Date(), items)
		.customerId(integratedTest.getCustomerId())
		.subscriptionId(integratedTest.getSubscriptionId())
		.build();
		
		InvoiceResponse response = new InvoiceService().create(inv);
        
		assertTrue( response != null );
		
    	assertTrue(response != null);
    	
    	assertTrue(response.getErrors() == null);
    	
    	assertTrue(response.getStatusCode() == null);
    	
    	integratedTest.setInvoice(response.getId());
    }
    
    /**
     * Procura por um invoice 
     */
	@Test
    public void testF()
    {

		Iugu.init(integratedTest.getApiToken());

		InvoiceResponse responseCustomer = new InvoiceService().find(integratedTest.getInvoice());
		
		assertTrue( responseCustomer != null );
    	
    	assertTrue(responseCustomer.getErrors() == null);
    	
    	assertTrue(responseCustomer.getStatusCode() == null);
		
    	integratedTest.setInvoice(responseCustomer.getId());
    }
	

//	@Test
//    public void testG()
//    {
//
//		Iugu.init(integratedTest.getApiToken());
//
//		InvoiceResponse responseInvoice = new InvoiceService().find(integratedTest.getInvoice());
//		
//		Invoice invoice = new Invoice(responseInvoice);
//		
//		invoice.setDiscountCents(100);
//		
//		InvoiceResponse responseChange = new InvoiceService().change(invoice);
//
//		
//		assertTrue( responseChange.getDiscountCents() != null);
//		
//    }
    
    

    
    /**
     * Duplica um invoice
     */
	@Test
    public void testG()
    {

		Iugu.init(integratedTest.getApiToken());
		
		//New Expire Date
		Calendar c = Calendar.getInstance();  
		c.set(Calendar.MONTH, Calendar.MARCH); 
		c.set(Calendar.DAY_OF_MONTH, 23);
		
		DuplicateInvoiceRequest duplicateRequestDate = new DuplicateInvoiceRequest(c.getTime(), Boolean.FALSE, Boolean.FALSE);
	
		InvoiceResponse responseInvoice = new InvoiceService().duplicate(integratedTest.getInvoice(),duplicateRequestDate);
		
		assertTrue( responseInvoice.getStatusCode() == null);
		assertTrue( responseInvoice.getId() != null);
		
		integratedTest.setInvoice(responseInvoice.getId());
		
    }
    
    /**
     * Duplica um invoice add Item
     */
	@Test
    public void testH()
    {

		Iugu.init(integratedTest.getApiToken());
		
		InvoiceResponse responseInvoice = new InvoiceService().find(integratedTest.getInvoice());
		
		//New Expire Date
		Calendar c = Calendar.getInstance();  
		c.set(Calendar.MONTH, Calendar.MARCH); 
		c.set(Calendar.DAY_OF_MONTH, 20);
		
		Item item = new Item("Almoço",1,1200);
		Item item2 = new Item("Cafe",1,1200);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		items.add(item2);
		
		DuplicateItemsInvoiceRequest duplicateRequestDate = new DuplicateItemsInvoiceRequest(c.getTime(), items, Boolean.FALSE, Boolean.FALSE);

		//Leia mais em: Trabalhando com as classes Date, Calendar e SimpleDateFormat em Java http://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401#ixzz3xUzipLgA
			
		InvoiceResponse responseInvoiceD = new InvoiceService().duplicate(responseInvoice.getId(),duplicateRequestDate);
		
		assertTrue( responseInvoiceD.getId() != null);
		
		integratedTest.setInvoice(responseInvoiceD.getId());
		
    }
    
    /**
     * Duplica um invoice Eliminando Item
     */
	@Test
    public void testI()
    {

		Iugu.init(integratedTest.getApiToken());
		
		InvoiceResponse responseInvoice = new InvoiceService().find(integratedTest.getInvoice());
		
		//New Expire Date
		Calendar c = Calendar.getInstance();  
		c.set(Calendar.MONTH, Calendar.MARCH); 
		c.set(Calendar.DAY_OF_MONTH, 25);
		
		List<Item> items = responseInvoice.getItems();
		items.get(0).setDestroy(Boolean.TRUE);
		items.get(1).setDestroy(Boolean.TRUE);
		//items.get(0).setDestroy(Boolean.TRUE);
		
		DuplicateItemsInvoiceRequest duplicateRequestDate = new DuplicateItemsInvoiceRequest(c.getTime(), items, Boolean.FALSE, Boolean.FALSE);

		//Leia mais em: Trabalhando com as classes Date, Calendar e SimpleDateFormat em Java http://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401#ixzz3xUzipLgA
			
		InvoiceResponse responseInvoiceD = new InvoiceService().duplicate(responseInvoice.getId(),duplicateRequestDate);
		
		assertTrue( responseInvoiceD.getId() != null);
		
		integratedTest.setInvoice(responseInvoiceD.getId());
		
    }
	
    /**
     * Cancela um invoice
     */
	@Test
    public void testJ()
    {

		Iugu.init(integratedTest.getApiToken());
			
		InvoiceResponse responseInvoice = new InvoiceService().cancel(integratedTest.getInvoice());
		
		assertTrue( responseInvoice.getId() != null);
		
		integratedTest.setInvoice(responseInvoice.getId());
    }
    
    /**
     * Remove um invoice
     */
	@Test
    public void testK()
    {

		Iugu.init(integratedTest.getApiToken());
	
		InvoiceResponse responseInvoice = new InvoiceService().remove(integratedTest.getInvoice());
		
		assertTrue( responseInvoice.getId() != null);
		
    }
    

    /**
     * Pagamento com Tokem e opcionalmente Payer e Desconto
     */
	@Test
    public void testL()
    {

		Iugu.init(integratedTest.getApiToken());

		//Testa a criacao de uma Token de pagamento
		//Usa os dados de um cartao de teste
    	Data data = new Data("4242424242424242","123","Joao","Silva","12","2013");
    	
    	//Constroi o objeto com dados do pagamento
    	PaymentToken pT = new PaymentToken(integratedTest.getMasterAccountId(), PayableWith.CREDIT_CARD,data,Boolean.FALSE);
    	
    	//Cria o tokem
    	PaymentTokenResponse responseToken = new PaymentService().createToken(pT);
    	
		
		Iugu.init(integratedTest.getApiToken());
		
		Item item = new Item("Refeição",1,1000);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090","marcel.ghisi@gmail.com",address);
		
		TokenDirectCharge cP = new TokenDirectCharge.Builder(responseToken.getId(),"marcel.ghisi@gmail.com",items).payer(payer).build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue(responseDirectCharge  != null);
		
		integratedTest.setInvoice(responseDirectCharge.getInvoiceId());
    }
	
    /**
     * Captura um invoice 
     */
	@Test
    public void testM()
    {
		Iugu.init(integratedTest.getApiToken());
		InvoiceResponse responseInvoice = new InvoiceService().capture(integratedTest.getInvoice());
		assertTrue( responseInvoice.getId() != null);	
    }
	
    /**
     * Refund um invoice
     */
	@Test
    public void testN()
    {

		Iugu.init(integratedTest.getApiToken());
			
		InvoiceResponse responseInvoice = new InvoiceService().refund(integratedTest.getInvoice());
		
		assertTrue( responseInvoice.getId() != null);
		
    }
    
    /**
     * Lista invoices
     */
	@Test
    public void testO()
    {

		Iugu.init(integratedTest.getApiToken());
			
		Calendar c = Calendar.getInstance();  
		c.set(Calendar.MONTH, Calendar.MARCH); 
		c.set(Calendar.DAY_OF_MONTH, 20);
		
		ListInvoiceCriteria crit = new ListInvoiceCriteria.Builder().dueDate(c.getTime()).build();
		ListInvoiceResponse responseInvoice = new InvoiceService().list(crit);
		
		assertTrue( responseInvoice.getItems().size() >0);
		
    }
    
    /**
     * Lista invoices por cliente
     */
	@Test
    public void testP()
    {

		Iugu.init(integratedTest.getApiToken());
		
		ListInvoiceCriteria crit = new ListInvoiceCriteria.Builder().customerId(integratedTest.getCustomerId()).build();
		ListInvoiceResponse responseInvoice = new InvoiceService().list(crit);
		
		assertTrue( responseInvoice.getItems().size() > 0);
		
    }
    
    /**
     * Lista invoices por limit
     */
	@Test
    public void testQ()
    {

		Iugu.init(integratedTest.getApiToken());
		
		ListInvoiceCriteria crit = new ListInvoiceCriteria.Builder().customerId(integratedTest.getCustomerId()).limit(2).build();
		ListInvoiceResponse responseInvoice = new InvoiceService().list(crit);
		
		assertTrue( responseInvoice.getItems().size() > 0);
		
    }
    
    /**
     * Lista invoices por limit e indice inicial
     */
	@Test
    public void testR()
    {

		Iugu.init(integratedTest.getApiToken());
		
		ListInvoiceCriteria crit = new ListInvoiceCriteria.Builder().limit(10).start(0).build();
		ListInvoiceResponse responseInvoice = new InvoiceService().list(crit);
		
		assertTrue(responseInvoice.getItems().size() > 0);
		
    }
    
    /**
     * Lista invoices por limit e indice inicial page 2
     */
	@Test
    public void testS()
    {

		Iugu.init(integratedTest.getApiToken());
		
		ListInvoiceCriteria crit = new ListInvoiceCriteria.Builder().limit(10).start(9).build();
		ListInvoiceResponse responseInvoice = new InvoiceService().list(crit);
		
		assertTrue(responseInvoice.getItems().size() > 0);
		
    }
    
    /**
     * Lista invoices updated desde 
     */
	@Test
    public void testT()
    {

		Iugu.init(integratedTest.getApiToken());
			
		Calendar c = Calendar.getInstance();  
		c.set(Calendar.MONTH, Calendar.JANUARY); 
		c.set(Calendar.DAY_OF_MONTH, 10);
		
		ListInvoiceCriteria crit = new ListInvoiceCriteria.Builder().updatedSince(c.getTime()).build();
		ListInvoiceResponse responseInvoice = new InvoiceService().list(crit);
		
		assertTrue( responseInvoice.getItems().size() > 0);
		
    }


    


}
