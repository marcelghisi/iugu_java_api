package com.iugu.iugu_java;

import java.util.List;

import com.iugu.Iugu;
import com.iugu.model.Customer;
import com.iugu.model.Data;
import com.iugu.model.ItemType;
import com.iugu.model.PaymentMethodRequest;
import com.iugu.responses.CustomerResponse;
import com.iugu.responses.PaymentMethodResponse;
import com.iugu.services.CustomerService;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CustomerPaymentMethodTest 
    extends TestCase
{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CustomerPaymentMethodTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CustomerPaymentMethodTest.class );
    }

    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testCreateCustomerPaymentMethod1()
    {

    	//{"id":"E5A929BD4A364698ABA72568FAD15FE1","email":"marcel.ghisi@gmail.com","name":"MARCEL JOSE DA SILVA GHISI","notes":null,"created_at":"2016-01-09T18:14:08-02:00,"updated_at":"2016-01-09T17:58:05-02:00","cc_emails":null,"cpf_cnpj":"02479484971","default_payment_method_id":null,"proxy_payments_from_customer_id":null,"custom_variables":[]}
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		Customer customer = new Customer("MARCEL JOSE DA SILVA GHISI","marcel.ghisi@gmail.com","02479484971");

		CustomerResponse responseCustomer = new CustomerService().find("E5A929BD4A364698ABA72568FAD15FE1");

		Data data = new Data("4242424242424242","123","Joao","Silva","12","2013");
		PaymentMethodRequest pData = new PaymentMethodRequest(ItemType.CREDIT_CARD, responseCustomer.getId(), "Cartão Extra", data, Boolean.FALSE);
		
		PaymentMethodResponse responsePayM = new CustomerService().createPaymentMethod(pData);
		
		assertTrue( responsePayM.getId() != null);
		
		//{"id":"467B0630B4034A4896DC08D6FCC8B5A9","description":"Cart\u00e3o Extra","item_type":"credit_card","customer_id":"E5A929BD4A364698ABA72568FAD15FE1","data":{"token":"000000000000000000000000000000000000002","display_number":"XXXX-XXXX-XXXX-4242","brand":"VISA"}}
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testCreateCustomerPaymentMethod2()
    {
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		CustomerResponse responseCustomer = new CustomerService().find("E5A929BD4A364698ABA72568FAD15FE1");

		Data data = new Data("4111111111111111","123","Joao","Silva","12","2013");
		PaymentMethodRequest pData = new PaymentMethodRequest(ItemType.CREDIT_CARD, responseCustomer.getId(), "Cartão Submarino", data, Boolean.FALSE);
		
		PaymentMethodResponse responsePayM = new CustomerService().createPaymentMethod(pData);
		
		assertTrue( responsePayM.getId() != null);
		
		//{"id":"74C27C6EC40B40E3B1556DBC5297427D","description":"Cart\u00e3o Extra","item_type":"credit_card","customer_id":"E5A929BD4A364698ABA72568FAD15FE1","data":{"token":"000000000000000000000000000000000000001","display_number":"XXXX-XXXX-XXXX-1111","brand":"VISA"}}
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testFindCustomerPayment()
    {

    	String customerId = "E5A929BD4A364698ABA72568FAD15FE1";
    	String paymentId = "467B0630B4034A4896DC08D6FCC8B5A9";
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		PaymentMethodResponse responseCustomer = new CustomerService().findPaymentMethod(customerId, paymentId);
		
		assertTrue( responseCustomer.getId() != null);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testChangePayment()
    {

    	String customerId = "E5A929BD4A364698ABA72568FAD15FE1";
    	String paymentId = "467B0630B4034A4896DC08D6FCC8B5A9";
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		PaymentMethodResponse responseCustomer = new CustomerService().findPaymentMethod(customerId, paymentId);
		
		//82EFB8FB193049E69161D958749E470F
		PaymentMethodResponse responseChange = new CustomerService().changePaymentMethod("E5A929BD4A364698ABA72568FAD15FE1",responseCustomer.getId(),"Cartao Neteller");
		
		assertTrue( responseChange.getId() != null);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testRemoveCustomerPaymentMethod()
    {

    	String customerId = "E5A929BD4A364698ABA72568FAD15FE1";
    	String paymentId = "601A3300ED6E4324862A8D0B200A78A1";
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");


		PaymentMethodResponse responseCustomerP = new CustomerService().removePaymentMethod(customerId,paymentId);
		
		assertTrue( responseCustomerP.getId() != null);
		
		PaymentMethodResponse responseFindCustomerP = new CustomerService().findPaymentMethod(customerId, paymentId);
		
		assertTrue(responseFindCustomerP.getErrors().get("errors").toString().contains("Customer payment method Not Found"));
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testListCustomerPaymentMethod()
    {
    	String customerId = "E5A929BD4A364698ABA72568FAD15FE1";
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		List<PaymentMethodResponse> responseCustomerList = new CustomerService().listPaymentMethod(customerId);
		
		assertTrue( responseCustomerList.size() > 0);
		
    }


    


}
