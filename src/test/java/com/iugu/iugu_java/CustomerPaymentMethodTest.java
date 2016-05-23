package com.iugu.iugu_java;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.iugu.IuguFactory;
import com.iugu.model.Customer;
import com.iugu.model.Data;
import com.iugu.model.ItemType;
import com.iugu.model.PaymentMethodRequest;
import com.iugu.responses.CustomerResponse;
import com.iugu.responses.PaymentMethodResponse;
import com.iugu.services.CustomerService;

import junit.framework.TestCase;


/**
 * Testa CRUD de métodos de pagamento.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerPaymentMethodTest extends TestCase{
	
    public static class IntegratedTest { 
    	
    	private static String tokemTest1;
    	private static String email = "marcelghisi@gmail.com";
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
     * Cria um customer para testar a criação da carteira dele
     */
	@Test
    public void testA()
    {
    	
    	integratedTest = new IntegratedTest();
    	
		Customer customer = new Customer("MARCEL JOSE DA SILVA GHISI","marcel.ghisi@gmail.com","02479484971");

		IuguFactory factory = new IuguFactory();
		CustomerResponse responseCustomer = new CustomerService(factory.getMarketPlaceClient()).create(customer);
    	
    	//Valida se o tokem foi criado
    	assertTrue(responseCustomer != null);
    	
    	//Valida se não retornou erros
    	assertTrue(responseCustomer.getErrors() == null);
    	
    	//Valida se não ocorreu erro 500
    	assertTrue(responseCustomer.getStatusCode() == null);
    	
    	integratedTest.setCustomerId(responseCustomer.getId());
    }
	
	
    /**
     * Cria um payment method
     */
	@Test
    public void testB()
    {

		//CustomerPaymentMethodTest.java#testB
		IuguFactory factory = new IuguFactory();
		CustomerResponse responseCustomer = new CustomerService(factory.getMarketPlaceClient()).find(integratedTest.getCustomerId());

		Data data = new Data("4242424242424242","123","Joao","Silva","12","2013");
		PaymentMethodRequest pData = new PaymentMethodRequest(ItemType.CREDIT_CARD, responseCustomer.getId(), "Cartão Extra", data, Boolean.FALSE);
		
		PaymentMethodResponse responsePayM = new CustomerService(factory.getMarketPlaceClient()).createPaymentMethod(pData);
		
		assertTrue( responsePayM.getId() != null);
		
    	integratedTest.setCustomerPaymentId(responsePayM.getId());
    }
    
    
    /**
     * Cria um payment method
     */
	@Test
    public void testC()
    {
		IuguFactory factory = new IuguFactory();		
		CustomerResponse responseCustomer = new CustomerService(factory.getMarketPlaceClient()).find(integratedTest.getCustomerId());

		Data data = new Data("4111111111111111","123","Joao","Silva","12","2013");
		PaymentMethodRequest pData = new PaymentMethodRequest(ItemType.CREDIT_CARD, responseCustomer.getId(), "Cartão Submarino", data, Boolean.FALSE);
		
		PaymentMethodResponse responsePayM = new CustomerService(factory.getMarketPlaceClient()).createPaymentMethod(pData);
		
		assertTrue( responsePayM.getId() != null);
		
		integratedTest.setCustomerPaymentIdB(responsePayM.getId());
		
    }
    
    /**
     * Encontra um payment method
     */
	@Test
    public void testD()
    {
    	
		IuguFactory factory = new IuguFactory();
		PaymentMethodResponse responseCustomer = new CustomerService(factory.getMarketPlaceClient()).findPaymentMethod(integratedTest.getCustomerId(), integratedTest.getCustomerPaymentId());
		
		assertTrue( responseCustomer.getId() != null);
		
    }
    
    /**
     * Altera um metodo de pagamento
     */
	@Test
    public void testE()
    {

		IuguFactory factory = new IuguFactory();
		String novoCardName = "Cartao Neteller";
		PaymentMethodResponse responseChange = new CustomerService(factory.getMarketPlaceClient()).changePaymentMethod(integratedTest.getCustomerId(),integratedTest.getCustomerPaymentId(),novoCardName);
		
		assertTrue( responseChange.getId() != null);
		assertEquals(novoCardName, responseChange.getDescription());
		
    }
    
    /**
     * Exclui um metodo de pagamento
     */
	@Test
    public void testF()
    {

    	String customerId = integratedTest.getCustomerId();
    	String paymentId = integratedTest.getCustomerPaymentId();
    	
		IuguFactory factory = new IuguFactory();
		PaymentMethodResponse responseCustomerP = new CustomerService(factory.getMarketPlaceClient()).removePaymentMethod(customerId,paymentId);
		
		assertTrue( responseCustomerP.getId() != null);
		
		PaymentMethodResponse responseFindCustomerP = new CustomerService(factory.getMarketPlaceClient()).findPaymentMethod(customerId, paymentId);
		
		assertTrue(responseFindCustomerP.getErrors().get("errors").toString().contains("Customer payment method Not Found"));
    }
    
    /**
     * Exclui um metodo de pagamento
     */
	@Test
    public void testG()
    {
    	String customerId = integratedTest.getCustomerId();
    	
		IuguFactory factory = new IuguFactory();
		List<PaymentMethodResponse> responseCustomerList = new CustomerService(factory.getMarketPlaceClient()).listPaymentMethod(customerId);
		
		assertTrue( responseCustomerList.size() > 0);
		
    }
	
    /**
     * Exclui um metodo de pagamento
     */
	@Test
    public void testH()
    {

    	String customerId = integratedTest.getCustomerId();
    	String paymentId = integratedTest.getCustomerPaymentIdB();
    	
		IuguFactory factory = new IuguFactory();

		PaymentMethodResponse responseCustomerP = new CustomerService(factory.getMarketPlaceClient()).removePaymentMethod(customerId,paymentId);
		
		assertTrue( responseCustomerP.getId() != null);
		
		PaymentMethodResponse responseFindCustomerP = new CustomerService(factory.getMarketPlaceClient()).findPaymentMethod(customerId, paymentId);
		
		assertTrue(responseFindCustomerP.getErrors().get("errors").toString().contains("Customer payment method Not Found"));
    }


    


}
