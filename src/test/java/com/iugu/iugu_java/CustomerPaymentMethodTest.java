package com.iugu.iugu_java;

import java.util.List;

import com.iugu.Iugu;
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
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		CustomerResponse responseCustomer = new CustomerService().find("E5A929BD4A364698ABA72568FAD15FE1");

		Data data = new Data("4242424242424242","123","Joao","Silva","12","2013");
		PaymentMethodRequest pData = new PaymentMethodRequest(ItemType.CREDIT_CARD, responseCustomer.getId(), "Cartão Extra", data, Boolean.FALSE);
		
		PaymentMethodResponse responsePayM = new CustomerService().createPaymentMethod(pData);
		
		assertTrue( responsePayM.getId() != null);
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
