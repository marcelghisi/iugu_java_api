package com.iugu.iugu_java;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.iugu.Iugu;
import com.iugu.model.Currency;
import com.iugu.model.Feature;
import com.iugu.model.IntervalType;
import com.iugu.model.Plan;
import com.iugu.responses.ListPlanResponse;
import com.iugu.responses.PlanResponse;
import com.iugu.services.PlanService;

/**
 * Testa CRUD de plans.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlanTest extends TestCase{
	
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
    	private static String planIdentifier = "basic_plan_test3";
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
     * CreatePlan
     */
	@Test
    public void testA()
    {

		Iugu.init(integratedTest.getApiToken());
		
		Plan plan = new Plan("ATTENDME P100", integratedTest.getPlanIdenifier(), 1, IntervalType.MONTHS,Currency.BRL,1000);

		PlanResponse planResponse = new PlanService().create(plan);
		
		assertTrue( planResponse.getId() != null);
		
		integratedTest.setPlanId(planResponse.getId());
    }
    
    /**
     * CreatePlan2ComFeatures
     */
	@Test
    public void testB()
    {

		Iugu.init(integratedTest.getApiToken());
		
		List<Feature> lista = new ArrayList<Feature>(0);
		lista.add(new Feature("Funcionalidade 1", "feature1", 100));
		lista.add(new Feature("Funcionalidade 2", "feature2", 100));

		Plan plan = new Plan("ATTENDME P500", integratedTest.getPlanIdenifier() + "_feat", 1, IntervalType.MONTHS,Currency.BRL,300,lista);
		
		
		PlanResponse planResponse = new PlanService().create(plan);
		
		assertTrue( planResponse.getId() != null);
		
		assertTrue( planResponse.getFeatures().size() > 0);
		
    }
    
    /**
     * FindPlan
     */
	@Test
    public void testC()
    {

		Iugu.init(integratedTest.getApiToken());

		PlanResponse responseCustomer = new PlanService().find(integratedTest.getPlanId());
		
		assertTrue( responseCustomer.getId() != null);
		
    }
    
    /**
     * testFindPlanIdentifier
     */
	@Test
    public void testD()
    {

		Iugu.init(integratedTest.getApiToken());

		PlanResponse responseCustomer = new PlanService().findByIdentifier(integratedTest.getPlanIdenifier());
		
		assertTrue( responseCustomer.getId() != null);
		
    }
    
    /**
     * ChangePlan
     */
	@Test
    public void testE()
    {

		Iugu.init(integratedTest.getApiToken());

		PlanResponse responseCustomer = new PlanService().findByIdentifier(integratedTest.getPlanIdenifier());

		Plan plan = new Plan("ATTENDME P250", integratedTest.getPlanIdenifier(), 2, IntervalType.WEEKS,Currency.BRL,10000);
		
		PlanResponse responseChange = new PlanService().change(responseCustomer.getId(),plan);
		assertTrue( responseChange.getId() != null);
		
    }
    
    /**
     * RemovePlan
     */
	@Test
    public void testF()
    {

		Iugu.init(integratedTest.getApiToken());
		
		PlanResponse responsePlan = new PlanService().remove(integratedTest.getPlanId());
		
		assertTrue( responsePlan.getId() != null);
		
		PlanResponse responseFind = new PlanService().find(integratedTest.getPlanId());
		
		assertTrue(responseFind.getErrors().get("errors").toString().contains("Plan Not Found"));
    }
    
    
    /**
     * RemovePlan
     */
	@Test
    public void testG()
    {
    	
		Iugu.init(integratedTest.getApiToken());

		ListPlanResponse responsePlanList = new PlanService().list();
		
		assertTrue( responsePlanList.getItems().size() > 0);
		
    }


    


}
