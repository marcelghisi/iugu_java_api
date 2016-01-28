package com.iugu.iugu_java;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.iugu.Iugu;
import com.iugu.model.Currency;
import com.iugu.model.Customer;
import com.iugu.model.Data;
import com.iugu.model.IntervalType;
import com.iugu.model.ItemType;
import com.iugu.model.PayableWith;
import com.iugu.model.PaymentMethodRequest;
import com.iugu.model.Plan;
import com.iugu.model.SubItem;
import com.iugu.model.Subscription;
import com.iugu.responses.CustomerResponse;
import com.iugu.responses.ListPlanResponse;
import com.iugu.responses.PaymentMethodResponse;
import com.iugu.responses.PlanResponse;
import com.iugu.responses.SubscriptionResponse;
import com.iugu.services.CustomerService;
import com.iugu.services.PlanService;
import com.iugu.services.SubscriptionService;

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
            subscriptionCreditBasedId = s;
        }               
        public String getSubscriptionPlanBasedId() {
            return subscriptionCreditBasedId;
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
	
		Iugu.init(integratedTest.getApiToken());
		
		ListPlanResponse planList = new PlanService().list();
		
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
		
		//Cria customer e Pay A
		Iugu.init(integratedTest.getApiToken());
		
		Customer customer = new Customer("MARCEL GHISI","marcel.ghisi@gmail.com","02479484971");

		CustomerResponse responseCustomer = new CustomerService().create(customer);
    	
    	//Valida se o tokem foi criado
    	assertTrue(responseCustomer != null);
    	
    	//Valida se não retornou erros
    	assertTrue(responseCustomer.getErrors() == null);
    	
    	//Valida se não ocorreu erro 500
    	assertTrue(responseCustomer.getStatusCode() == null);
    	
    	integratedTest.setCustomerId(responseCustomer.getId());
    	
		Data data = new Data("4242424242424242","123","Joao","Silva","12","2013");
		PaymentMethodRequest pData = new PaymentMethodRequest(ItemType.CREDIT_CARD, responseCustomer.getId(), "Cartão Teste", data, Boolean.FALSE);
		
		PaymentMethodResponse responsePayM = new CustomerService().createPaymentMethod(pData);
		
		assertTrue( responsePayM.getId() != null);
		
		
		
		
		//Cria customer e Pay B
		Iugu.init(integratedTest.getApiToken());
		
		Customer customerB = new Customer("ARTHUR GHISI","marcel.ghisi@gmail.com","02479484971");

		CustomerResponse responseCustomerB = new CustomerService().create(customerB);
    	
    	//Valida se o tokem foi criado
    	assertTrue(responseCustomerB != null);
    	
    	//Valida se não retornou erros
    	assertTrue(responseCustomerB.getErrors() == null);
    	
    	//Valida se não ocorreu erro 500
    	assertTrue(responseCustomerB.getStatusCode() == null);
    	
    	integratedTest.setCustomerIdB(responseCustomerB.getId());
    	
		Data dataB = new Data("4012888888881881","123","Joao","Silva","12","2013");
		PaymentMethodRequest pDataB = new PaymentMethodRequest(ItemType.CREDIT_CARD, responseCustomerB.getId(), "Cartão Teste", dataB, Boolean.FALSE);
		
		PaymentMethodResponse responsePayMB = new CustomerService().createPaymentMethod(pDataB);
		
		assertTrue( responsePayMB.getId() != null);
    }

    /**
     * Create Subscription
     */
	@Test
    public void testC()
    {

		Iugu.init(integratedTest.getApiToken());
		
		Subscription subs = new Subscription
								.Builder(integratedTest.getCustomerId())
								.planIdentifier(integratedTest.getPlanIdenifier())
								.build();

		SubscriptionResponse subsResponse = new SubscriptionService().create(subs);
		
		assertTrue( subsResponse.getId() != null);
		
    }
	
    /**
     * Create Subscription com data de expiração
     */
	@Test
    public void testD()
    {

		Iugu.init(integratedTest.getApiToken());
		
		//Primeira data dia 20 do mes atual
		Calendar data = Calendar.getInstance();
        data.add(Calendar.DAY_OF_MONTH, 20);
        data.add(Calendar.YEAR, 1);
        
		Subscription subs = new Subscription
								.Builder(integratedTest.getCustomerId())
								.planIdentifier(integratedTest.getPlanIdenifier())
								.expiresAt(data.getTime())
								.build();

		SubscriptionResponse subsResponse = new SubscriptionService().create(subs);
		
		assertTrue( subsResponse.getId() != null);
		
    }
	
    /**
     * Create Subscription com data de expiração se realizar o charge da primeira cobranca
     */
	@Test
    public void testE()
    {

		Iugu.init(integratedTest.getApiToken());
		
		//Primeira data dia 20 do mes atual
		Calendar data = Calendar.getInstance();
        data.add(Calendar.DAY_OF_MONTH, 20);
        data.add(Calendar.YEAR, 1);
        
		Subscription subs = new Subscription
								.Builder(integratedTest.getCustomerId())
								.planIdentifier(integratedTest.getPlanIdenifier())
								.expiresAt(data.getTime())
								.initOnlyOnChargeSuccess("true")
								.build();

		SubscriptionResponse subsResponse = new SubscriptionService().create(subs);
		
		assertTrue( subsResponse.getId() != null);
		
		integratedTest.setSubscriptionPlanBasedId(subsResponse.getId());
    }
	
    /**
     * Create Subscription com data de expiração se realizar o charge da primeira cobranca
     */
	@Test
    public void testF()
    {

		Iugu.init(integratedTest.getApiToken());
		
		//Primeira data dia 20 do mes atual
		Calendar data = Calendar.getInstance();
        data.add(Calendar.DAY_OF_MONTH, 1);
        data.add(Calendar.YEAR, 1);
        
		Subscription subs = new Subscription
								.Builder(integratedTest.getCustomerId())
								.expiresAt(data.getTime())
								.payableWith(PayableWith.BANK_SLIP)
								.initOnlyOnChargeSuccess("true")
								.creditsBased(Boolean.TRUE)
								.creditsCycle(4)
								.creditsCycleStartAt(0)
								.priceInCents(10000)
								.build();

		SubscriptionResponse subsResponse = new SubscriptionService().create(subs);
		
		assertTrue( subsResponse.getId() != null);
		assertEquals(0, subsResponse.getCredits().intValue());
    }
	
    /**
     * Create Subscription com data de expiração se realizar o charge da primeira cobranca
     */
	@Test
    public void testG()
    {

		Iugu.init(integratedTest.getApiToken());
		
		//Primeira data dia 20 do mes atual
		Calendar data = Calendar.getInstance();
        data.set(Calendar.YEAR, data.get(Calendar.YEAR) + 1);
        data.set(Calendar.DAY_OF_MONTH, data.get(Calendar.DAY_OF_MONTH) + 1);
       
        
		Subscription subs = new Subscription
								.Builder(integratedTest.getCustomerId())
								.expiresAt(data.getTime())
								.payableWith(PayableWith.CREDIT_CARD)
								.creditsBased(Boolean.TRUE)
								.creditsCycle(4)
								.creditsCycleStartAt(0)
								.priceInCents(10000)
								.build();

		SubscriptionResponse subsResponse = new SubscriptionService().create(subs);
		
		assertTrue( subsResponse.getId() != null);
		assertEquals(4,subsResponse.getCredits().intValue());
		
    }
	
    /**
     * Create Subscription com data de expiração se realizar o charge da primeira cobranca
     */
	@Test
    public void testH()
    {

		Iugu.init(integratedTest.getApiToken());
		
		//Primeira data dia 20 do mes atual
		Calendar data = Calendar.getInstance();
        data.set(Calendar.YEAR, data.get(Calendar.YEAR) + 1);
        data.set(Calendar.DAY_OF_MONTH, data.get(Calendar.DAY_OF_MONTH) + 1);
        
        SubItem sI = new SubItem("Corte de cabelo", 1, 23);
        List<SubItem> lista = new ArrayList<SubItem>(0);
        lista.add(sI);
        
		Subscription subs = new Subscription
								.Builder(integratedTest.getCustomerIdB())
								.expiresAt(data.getTime())
								.payableWith(PayableWith.CREDIT_CARD)
								.creditsBased(Boolean.TRUE)
								.initOnlyOnChargeSuccess("true")
								.creditsCycle(4)
								.creditsCycleStartAt(0)
								.priceInCents(10000)
								.items(lista)
								.build();

		SubscriptionResponse subsResponse = new SubscriptionService().create(subs);
		
		assertTrue( subsResponse.getId() != null);
		assertEquals(0,subsResponse.getCredits().intValue());
		assertEquals(Boolean.FALSE,subsResponse.getSuspended());
		
		integratedTest.setSubscriptionCreditBasedId(subsResponse.getId());
    }
	
    /**
     * Find Subscription
     */
	@Test
    public void testI()
    {

		Iugu.init(integratedTest.getApiToken());
		
		SubscriptionResponse subsResponse = new SubscriptionService().find(integratedTest.getSubscriptionCreditBasedId());
		
		assertTrue( subsResponse.getId() != null);

		assertTrue( subsResponse.getErrors() == null);
		
		
    }
    

    /**
     * Change Suspended Subscription
     */
	@Test
    public void testJ()
    {

		Iugu.init(integratedTest.getApiToken());
		
		SubscriptionResponse subsResponse = new SubscriptionService().find(integratedTest.getSubscriptionCreditBasedId());
		

		Subscription subs = new Subscription
				.Builder(integratedTest.getCustomerIdB())
				.suspended(Boolean.TRUE)
				.response(subsResponse)
				.build();


		SubscriptionResponse subsResponseC = new SubscriptionService().change(integratedTest.getSubscriptionCreditBasedId(), subs);
		
		assertTrue( subsResponseC.getId() != null);
		assertTrue(subsResponseC.getSuspended());
		
		
    }
	

    /**
     * Change Date Subscription
     */
	@Test
    public void testK()
    {

		Iugu.init(integratedTest.getApiToken());
		
		SubscriptionResponse subsResponse = new SubscriptionService().find(integratedTest.getSubscriptionPlanBasedId());
		//Hack para suprir a falta do plan_identifier no find
		subsResponse.setPlanIdentifier(integratedTest.getPlanIdenifier());

		Subscription subs = new Subscription
				.Builder(integratedTest.getCustomerIdB())
				.suspended(Boolean.TRUE)
				.response(subsResponse)
				.build();


		SubscriptionResponse subsResponseC = new SubscriptionService().change(integratedTest.getSubscriptionPlanBasedId(), subs);
		
		assertTrue( subsResponseC.getId() != null);
		assertTrue(subsResponseC.getSuspended());
		
		
    }
	
	
	


}
