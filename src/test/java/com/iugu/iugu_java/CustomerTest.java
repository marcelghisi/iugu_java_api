package com.iugu.iugu_java;

import junit.framework.TestCase;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.iugu.Iugu;
import com.iugu.model.Customer;
import com.iugu.responses.CustomerResponse;
import com.iugu.services.CustomerService;

/**
 * Testa CRUD de métodos de pagamento.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerTest extends TestCase{
	
    public static class IntegratedTest { 
    	
    	private static String tokemTest1;
    	private static String email = "marcel.ghisi@gmail.com";
    	private static String invoiceId;
    	private static String customerId;
    	private static String customerPaymentId;
    	private static String customerPaymentIdB;
    	private static String masterApiTokemTeste = "21ab6ca14384901acaea1793b91cdc98";
    	private static String masterAccountId = "96461997-b6a0-48fb-808b-4f16ad88c718";
    	
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
     * Cria um customer 
     */
	@Test
    public void testA()
    {

		Iugu.init(integratedTest.getApiToken());
		
		Customer customer = new Customer("MARCEL JOSE DA SILVA GHISI","marcel.ghisi@gmail.com","02479484971");

		CustomerResponse responseCustomer = new CustomerService().create(customer);
		
		assertTrue( responseCustomer.getId() != null);
		
		integratedTest.setCustomerId(responseCustomer.getId());
		
    }
    
    /**
     * Encontra um customer
     */
	@Test
    public void testB()
    {

		Iugu.init(integratedTest.getApiToken());
		
		CustomerResponse responseCustomer = new CustomerService().find(integratedTest.getCustomerId());
		
		assertTrue( responseCustomer.getId() != null);
		
		assertEquals(integratedTest.getEmail(),responseCustomer.getEmail());
		
    }
    
    /**
     * Altera um customer
     */
	@Test
    public void testC()
    {

		Iugu.init(integratedTest.getApiToken());
		
		Customer customer = new Customer("MARCEL GHISI","marcel.ghisi@gmail.com","02479484971");

		CustomerResponse responseCustomer = new CustomerService().change(integratedTest.getCustomerId(),customer);
		
		assertTrue( responseCustomer.getId() != null);
		
		assertEquals(customer.getName(),responseCustomer.getName());
		
    }
    
    /**
     * Remove um customer
     */
	@Test
    public void testD()
    {

		Iugu.init(integratedTest.getApiToken());
		
		CustomerResponse responseCustomer = new CustomerService().remove(integratedTest.getCustomerId());
		
		assertTrue( responseCustomer.getId() != null);
		
		CustomerResponse responseFind = new CustomerService().find(integratedTest.getCustomerId());
		
		assertTrue(responseFind.getErrors().get("errors").toString().contains("Customer Not Found"));
    }


    


}
