package com.iugu.iugu_java;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.iugu.Iugu;
import com.iugu.IuguFactory;
import com.iugu.model.Customer;
import com.iugu.model.Data;
import com.iugu.model.ItemType;
import com.iugu.model.ListSubscriptionCriteria;
import com.iugu.model.PayableWith;
import com.iugu.model.PaymentMethodRequest;
import com.iugu.model.SubItem;
import com.iugu.model.Subscription;
import com.iugu.responses.CustomerResponse;
import com.iugu.responses.ListPlanResponse;
import com.iugu.responses.ListSubscriptionResponse;
import com.iugu.responses.PaymentMethodResponse;
import com.iugu.responses.PlanResponse;
import com.iugu.responses.SubscriptionResponse;
import com.iugu.services.CustomerService;
import com.iugu.services.PlanService;
import com.iugu.services.SubscriptionService;

import junit.framework.TestCase;

/**
 * Testa CRUD de plans.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubscriptionTest extends TestCase{
	
    public static class IntegratedTest { 
    	
    	private static String tokemTest1;
    	private static String email = "thiagohcortez@gmail.com";
    	private static String invoiceId;
    	private static String customerId;
    	private static String customerIdB;
    	private static String customerPaymentId;
    	private static String subscriptionCreditBasedId;
    	private static String subscriptionPlanBasedId;
    	private static String customerPaymentIdB;
    	private static String masterApiTokemTeste = "21ab6ca14384901acaea1793b91cdc98";
    	private static String masterAccountId = "96461997-b6a0-48fb-808b-4f16ad88c718";
    	private static String planIdentifier = "basic_plan_testsubs24";
    	private static String subAccountId;
    	private static String liveApiToken;
    	private static String testApiToken;
    	private static String userToken; 
    	private static String planId; 
    	
        public void setPlanIdentifier(String s) {
        	planIdentifier = s;
        }
        
        public String getPlanIdenifier() {
            return planIdentifier;
        }
        
        public void setPlanId(String s) {
        	planId = s;
        }
        
        public String getPlanId() {
            return planId;
        }
        
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
        
        public void setCustomerIdB(String s) {
            customerIdB = s;
        }               
        public String getCustomerIdB() {
            return customerIdB;
        }
        
        public void setSubscriptionPlanBasedId(String s) {
            subscriptionPlanBasedId = s;
        }               
        public String getSubscriptionPlanBasedId() {
            return subscriptionPlanBasedId;
        }
        
        public void setSubscriptionCreditBasedId(String s) {
            subscriptionCreditBasedId = s;
        }               
        public String getSubscriptionCreditBasedId() {
            return subscriptionCreditBasedId;
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
     * Create Subscription
     */
	@Test
    public void testA()
    {
	
		IuguFactory factory = new IuguFactory();

		
		ListPlanResponse planList = new PlanService(factory.getMarketPlaceClient()).list();
		
		for (PlanResponse plan : planList.getItems()) {
			integratedTest.setPlanIdentifier(plan.getIdentifier());
			integratedTest.setPlanId(plan.getId());
			break;
		}
		
    }
    /**
     * Create Subscription
     */
	@Test
    public void testB()
    {
		
		IuguFactory factory = new IuguFactory();

		
		Customer customer = new Customer("MARCEL GHISI","marcel.ghisi@gmail.com","02479484971");

		CustomerResponse responseCustomer = new CustomerService(factory.getMarketPlaceClient()).create(customer);
    	
    	//Valida se o tokem foi criado
    	assertTrue(responseCustomer != null);
    	
    	//Valida se não retornou erros
    	assertTrue(responseCustomer.getErrors() == null);
    	
    	//Valida se não ocorreu erro 500
    	assertTrue(responseCustomer.getStatusCode() == null);
    	
    	integratedTest.setCustomerId(responseCustomer.getId());
    	
		Data data = new Data("4242424242424242","123","Joao","Silva","12","2013");
		PaymentMethodRequest pData = new PaymentMethodRequest(ItemType.CREDIT_CARD, responseCustomer.getId(), "Cartão Teste", data, Boolean.FALSE);
		
		PaymentMethodResponse responsePayM = new CustomerService(factory.getMarketPlaceClient()).createPaymentMethod(pData);
		
		assertTrue( responsePayM.getId() != null);
		
		
		
		
		//Cria customer e Pay B
		
		Customer customerB = new Customer("ARTHUR GHISI","marcel.ghisi@gmail.com","02479484971");

		CustomerResponse responseCustomerB = new CustomerService(factory.getMarketPlaceClient()).create(customerB);
    	
    	//Valida se o tokem foi criado
    	assertTrue(responseCustomerB != null);
    	
    	//Valida se não retornou erros
    	assertTrue(responseCustomerB.getErrors() == null);
    	
    	//Valida se não ocorreu erro 500
    	assertTrue(responseCustomerB.getStatusCode() == null);
    	
    	integratedTest.setCustomerIdB(responseCustomerB.getId());
    	
		Data dataB = new Data("4012888888881881","123","Joao","Silva","12","2013");
		PaymentMethodRequest pDataB = new PaymentMethodRequest(ItemType.CREDIT_CARD, responseCustomerB.getId(), "Cartão Teste", dataB, Boolean.FALSE);
		
		PaymentMethodResponse responsePayMB = new CustomerService(factory.getMarketPlaceClient()).createPaymentMethod(pDataB);
		
		assertTrue( responsePayMB.getId() != null);
    }

    /**
     * Create Subscription
     */
	@Test
    public void testC()
    {

		IuguFactory factory = new IuguFactory();

		
		Subscription subs = new Subscription
								.Builder()
								.customerId(integratedTest.getCustomerId())
								.planIdentifier(integratedTest.getPlanIdenifier())
								.build();

		SubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).create(subs);
		
		assertTrue( subsResponse.getId() != null);
		
    }
	
    /**
     * Create Subscription com data de expiração
     */
	@Test
    public void testD()
    {

		IuguFactory factory = new IuguFactory();

		
		//Primeira data dia 20 do mes atual
		Calendar data = Calendar.getInstance();
        data.add(Calendar.DAY_OF_MONTH, 20);
        data.add(Calendar.YEAR, 1);
        
		Subscription subs = new Subscription
								.Builder()
								.customerId(integratedTest.getCustomerId())
								.planIdentifier(integratedTest.getPlanIdenifier())
								.expiresAt(data.getTime())
								.build();

		SubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).create(subs);
		
		assertTrue( subsResponse.getId() != null);
		
    }
	
    /**
     * Create Subscription com data de expiração se realizar o charge da primeira cobranca
     */
	@Test
    public void testE()
    {

		IuguFactory factory = new IuguFactory();
		
		//Primeira data dia 20 do mes atual
		Calendar data = Calendar.getInstance();
        data.add(Calendar.DAY_OF_MONTH, 20);
        data.add(Calendar.YEAR, 1);
        
		Subscription subs = new Subscription
								.Builder()
								.customerId(integratedTest.getCustomerId())
								.planIdentifier(integratedTest.getPlanIdenifier())
								.expiresAt(data.getTime())
								.initOnlyOnChargeSuccess("true")
								.build();

		SubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).create(subs);
		
		assertTrue( subsResponse.getId() != null);
		
		integratedTest.setSubscriptionPlanBasedId(subsResponse.getId());
    }
	
    /**
     * Create Subscription com data de expiração se realizar o charge da primeira cobranca
     */
	@Test
    public void testF()
    {

		IuguFactory factory = new IuguFactory();

		//Primeira data dia 20 do mes atual
		Calendar data = Calendar.getInstance();
        data.add(Calendar.DAY_OF_MONTH, 1);
        data.add(Calendar.YEAR, 1);
        
		Subscription subs = new Subscription
								.Builder()
								.customerId(integratedTest.getCustomerId())
								.expiresAt(data.getTime())
								.payableWith(PayableWith.BANK_SLIP)
								.initOnlyOnChargeSuccess("true")
								.creditsBased(Boolean.TRUE)
								.creditsCycle(4)
								.creditsCycleStartAt(0)
								.priceInCents(10000)
								.build();

		SubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).create(subs);
		
		assertTrue( subsResponse.getId() != null);
		assertEquals(0, subsResponse.getCredits().intValue());
    }
	
    /**
     * Create Subscription com data de expiração se realizar o charge da primeira cobranca
     */
	@Test
    public void testG()
    {

		IuguFactory factory = new IuguFactory();

		
		//Primeira data dia 20 do mes atual
		Calendar data = Calendar.getInstance();
        data.set(Calendar.YEAR, data.get(Calendar.YEAR) + 1);
        data.set(Calendar.DAY_OF_MONTH, data.get(Calendar.DAY_OF_MONTH) + 1);
       
        
		Subscription subs = new Subscription
								.Builder()
								.customerId(integratedTest.getCustomerId())
								.expiresAt(data.getTime())
								.payableWith(PayableWith.CREDIT_CARD)
								.creditsBased(Boolean.TRUE)
								.creditsCycle(4)
								.creditsCycleStartAt(0)
								.priceInCents(10000)
								.build();

		SubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).create(subs);
		
		assertTrue( subsResponse.getId() != null);
		assertEquals(4,subsResponse.getCredits().intValue());
		
    }
	
    /**
     * Create Subscription com data de expiração se realizar o charge da primeira cobranca
     */
	@Test
    public void testH()
    {

		IuguFactory factory = new IuguFactory();

		
		//Primeira data dia 20 do mes atual
		Calendar data = Calendar.getInstance();
        data.set(Calendar.YEAR, data.get(Calendar.YEAR) + 1);
        data.set(Calendar.DAY_OF_MONTH, data.get(Calendar.DAY_OF_MONTH) + 1);
        
        SubItem sI = new SubItem("Corte de cabelo", 1, 23);
        List<SubItem> lista = new ArrayList<SubItem>(0);
        lista.add(sI);
        
		Subscription subs = new Subscription
								.Builder()
								.customerId(integratedTest.getCustomerId())
								.expiresAt(data.getTime())
								.payableWith(PayableWith.CREDIT_CARD)
								.creditsBased(Boolean.TRUE)
								.initOnlyOnChargeSuccess("true")
								.creditsCycle(4)
								.creditsCycleStartAt(0)
								.priceInCents(10000)
								.items(lista)
								.build();

		SubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).create(subs);
		
		assertTrue( subsResponse.getId() != null);
		assertEquals(4,subsResponse.getCredits().intValue());
		assertEquals(Boolean.FALSE,subsResponse.getSuspended());
		
		integratedTest.setSubscriptionCreditBasedId(subsResponse.getId());
    }
	
    /**
     * Find Subscription
     */
	@Test
    public void testI()
    {

		IuguFactory factory = new IuguFactory();

		
		SubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).find(integratedTest.getSubscriptionCreditBasedId());
		
		assertTrue( subsResponse.getId() != null);

		assertTrue( subsResponse.getErrors() == null);
		
		
    }
    

    /**
     * Change Suspended based credit subscription
     */
	@Test
    public void testJ()
    {

		IuguFactory factory = new IuguFactory();

		
		Subscription subs = new Subscription
				.Builder()
				.subscriptionId(integratedTest.getSubscriptionCreditBasedId())
				.suspended(Boolean.TRUE)
				.build();


		SubscriptionResponse subsResponseC = new SubscriptionService(factory.getMarketPlaceClient()).change(integratedTest.getSubscriptionCreditBasedId(), subs);
		
		assertTrue( subsResponseC.getId() != null);
		assertTrue(subsResponseC.getSuspended());
		
		
    }
	

    /**
     * Change Suspended for based plan Subscription
     */
	@Test
    public void testK()
    {

		IuguFactory factory = new IuguFactory();


		Subscription subs = new Subscription
				.Builder()
				.subscriptionId(integratedTest.getSubscriptionPlanBasedId())
				.suspended(Boolean.TRUE)
				.build();


		SubscriptionResponse subsResponseC = new SubscriptionService(factory.getMarketPlaceClient()).change(integratedTest.getSubscriptionPlanBasedId(), subs);
		
		assertTrue( subsResponseC.getId() != null);
		assertTrue(subsResponseC.getSuspended());
		
		
    }
	
    /**
     * Create Subscription plan based with items to test delete
     */
	@Test
    public void testL()
    {

		IuguFactory factory = new IuguFactory();

		
		//Primeira data dia 20 do mes atual
		Calendar data = Calendar.getInstance();
        data.add(Calendar.DAY_OF_MONTH, 20);
        data.add(Calendar.YEAR, 1);
        
        SubItem sI = new SubItem("Corte de cabelo", 1, 23);
        List<SubItem> lista = new ArrayList<SubItem>(0);
        lista.add(sI);
        
		Subscription subs = new Subscription
								.Builder()
								.customerId(integratedTest.getCustomerId())
								.planIdentifier(integratedTest.getPlanIdenifier())
								.expiresAt(data.getTime())
								.initOnlyOnChargeSuccess("true")
								.items(lista)
								.build();

		SubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).create(subs);
		
		assertTrue( subsResponse.getId() != null);
		assertTrue( subsResponse.getSubitems().size() == 1);
		
		integratedTest.setSubscriptionPlanBasedId(subsResponse.getId());
    }
	
    /**
     * Suspend Subscription
     */
	@Test
    public void testM()
    {

		IuguFactory factory = new IuguFactory();

		SubscriptionResponse subsResponseC = new SubscriptionService(factory.getMarketPlaceClient()).suspend(integratedTest.getSubscriptionPlanBasedId());
		
		assertTrue( subsResponseC.getId() != null);
		assertTrue(subsResponseC.getSuspended());
		
		
    }
	
    /**
     * Activate Subscription
     */
	@Test
    public void testN()
    {

		IuguFactory factory = new IuguFactory();

		SubscriptionResponse subsResponseC = new SubscriptionService(factory.getMarketPlaceClient()).activate(integratedTest.getSubscriptionPlanBasedId());
		
		assertTrue( subsResponseC.getId() != null);
		assertFalse(subsResponseC.getSuspended());
		
		
    }
	
    /**
     * Change Plan for Subscription
     */
	@Test
    public void testO()
    {

		IuguFactory factory = new IuguFactory();

		SubscriptionResponse subsResponseC = new SubscriptionService(factory.getMarketPlaceClient()).changePlan(integratedTest.getSubscriptionPlanBasedId(), "plano_basico");
		
		assertTrue( subsResponseC.getId() != null);
		assertEquals("plano_basico",subsResponseC.getPlanIdentifier());
		
		
    }
	
    /**
     * Adiciona Créditos Subscription
     */
	@Test
    public void testP()
    {

		IuguFactory factory = new IuguFactory();

		
		SubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).find(integratedTest.getSubscriptionCreditBasedId());
		
		Integer cred = subsResponse.getCredits();
		
		SubscriptionResponse subsResponseC = new SubscriptionService(factory.getMarketPlaceClient()).addCredits(integratedTest.getSubscriptionCreditBasedId(), 10);
		
		assertTrue( subsResponseC.getId() != null);
		assertEquals(cred+10,subsResponseC.getCredits().intValue());
			
    }
	
    /**
     * Remove Créditos Subscription
     */
	@Test
    public void testQ()
    {

		IuguFactory factory = new IuguFactory();

		
		SubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).find(integratedTest.getSubscriptionCreditBasedId());
		
		Integer cred = subsResponse.getCredits();
		
		SubscriptionResponse subsResponseC = new SubscriptionService(factory.getMarketPlaceClient()).removeCredits(integratedTest.getSubscriptionCreditBasedId(), 10);
		
		assertTrue( subsResponseC.getId() != null);
		assertEquals(cred-10,subsResponseC.getCredits().intValue());
			
    }
	
    /**
     * Remove Créditos Subscription
     */
	@Test
    public void testR()
    {

		IuguFactory factory = new IuguFactory();

		
		SubscriptionResponse subsResponseD = new SubscriptionService(factory.getMarketPlaceClient()).remove(integratedTest.getSubscriptionCreditBasedId());
		
		SubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).remove(integratedTest.getSubscriptionCreditBasedId());
		
		
		assertTrue( subsResponse.getErrors().get("errors").toString().contains("Subscription Not Found"));
			
    }
	
    /**
     * Lista subscription por cliente
     */
	@Test
    public void testS()
    {

		IuguFactory factory = new IuguFactory();

		
		ListSubscriptionCriteria crit = new ListSubscriptionCriteria.Builder().customerId(integratedTest.getCustomerId()).build();
		ListSubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).list(crit);
		
		assertTrue( subsResponse.getItems().size() > 0);
		
    }
    
    /**
     * Lista invoices por limit
     */
	@Test
    public void testT()
    {

		IuguFactory factory = new IuguFactory();

		
		ListSubscriptionCriteria crit = new ListSubscriptionCriteria.Builder().customerId(integratedTest.getCustomerId()).limit(2).build();
		ListSubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).list(crit);
		
		assertTrue( subsResponse.getItems().size() > 0);
		
    }
    
    /**
     * Lista invoices por limit e indice inicial
     */
	@Test
    public void testU()
    {

		IuguFactory factory = new IuguFactory();

		
		ListSubscriptionCriteria crit = new ListSubscriptionCriteria.Builder().limit(10).start(0).build();
		ListSubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).list(crit);
		
		assertTrue(subsResponse.getItems().size() > 0);
		
    }
    
    /**
     * Lista invoices por limit e indice inicial page 2
     */
	@Test
    public void testV()
    {

		IuguFactory factory = new IuguFactory();

		
		ListSubscriptionCriteria crit = new ListSubscriptionCriteria.Builder().limit(10).start(9).build();
		ListSubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).list(crit);
		
		assertTrue(subsResponse.getItems().size() == 0);
		
    }
    
    /**
     * Lista subscription updated desde 
     */
	@Test
    public void testX()
    {

		IuguFactory factory = new IuguFactory();

			
		Calendar c = Calendar.getInstance();  
		c.set(Calendar.MONTH, Calendar.JANUARY); 
		c.set(Calendar.DAY_OF_MONTH, 10);
		
		ListSubscriptionCriteria crit = new ListSubscriptionCriteria.Builder().updatedSince(c.getTime()).build();
		ListSubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).list(crit);
		
		assertTrue( subsResponse.getItems().size() > 0);
		
    }
	
    /**
     * Lista subscriptios updated desde 
     */
	@Test
    public void testZ()
    {

		IuguFactory factory = new IuguFactory();

			
		Calendar c = Calendar.getInstance();  
		c.set(Calendar.MONTH, Calendar.DECEMBER); 
		c.set(Calendar.YEAR, 2015);
		
		ListSubscriptionCriteria crit = new ListSubscriptionCriteria.Builder().updatedSince(c.getTime()).build();
		ListSubscriptionResponse responseInvoice = new SubscriptionService(factory.getMarketPlaceClient()).list(crit);
		
		assertTrue( responseInvoice.getItems().size() > 0);
		
		for (SubscriptionResponse response : responseInvoice.getItems()) {
			SubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).remove(response.getId());
		}
    }
	
    /**
     * Lista subscription updated desde 
     */
	@Test
    public void testZA()
    {

		IuguFactory factory = new IuguFactory();

			
		Calendar c = Calendar.getInstance();  
		c.set(Calendar.MONTH, Calendar.DECEMBER); 
		c.set(Calendar.YEAR, 2015);
		
		ListSubscriptionCriteria crit = new ListSubscriptionCriteria.Builder().updatedSince(c.getTime()).build();
		ListSubscriptionResponse subsResponse = new SubscriptionService(factory.getMarketPlaceClient()).list(crit);
		
		assertTrue( subsResponse.getItems().size() == 0);
		
    }

}
