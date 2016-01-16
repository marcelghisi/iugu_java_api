package com.iugu.iugu_java;

import java.util.Date;

import com.iugu.Iugu;
import com.iugu.model.Customer;
import com.iugu.model.Invoice;
import com.iugu.model.Item;
import com.iugu.responses.CustomerResponse;
import com.iugu.responses.InvoiceResponse;
import com.iugu.services.CustomerService;
import com.iugu.services.InvoiceService;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class InvoicesTest 
    extends TestCase
{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public InvoicesTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( InvoicesTest.class );
    }

    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testCreateInvoiceWithEmail()
    {
		//Funfa cria fatura e envia boleto com invoice
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		InvoiceResponse response = new InvoiceService().create(new Invoice("marcelghisi@gmail.com", new Date(), new Item("Manicure", 1, 100)));
        
		assertTrue( response != null );
    }
    
    /*
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testFindInvoice()
    {

    	//{"id":"C9D0758BB74641CABCF4436E15A98C7E","email":"marcel.ghisi@gmail.com","name":"MARCEL JOSE DA SILVA GHISI","notes":null,"created_at":"2016-01-09T17:58:05-02:00","updated_at":"2016-01-09T17:58:05-02:00","cc_emails":null,"cpf_cnpj":"02479484971","default_payment_method_id":null,"proxy_payments_from_customer_id":null,"custom_variables":[]}
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		InvoiceResponse responseCustomer = new InvoiceService().find("ADD8246A1F61417C818DF428BE41FDDB");
		
		assertTrue( responseCustomer != null);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testDuplicateInvoice()
    {

    	//{"id":"C9D0758BB74641CABCF4436E15A98C7E","email":"marcel.ghisi@gmail.com","name":"MARCEL JOSE DA SILVA GHISI","notes":null,"created_at":"2016-01-09T17:58:05-02:00","updated_at":"2016-01-09T17:58:05-02:00","cc_emails":null,"cpf_cnpj":"02479484971","default_payment_method_id":null,"proxy_payments_from_customer_id":null,"custom_variables":[]}
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		InvoiceResponse responseCustomer = new InvoiceService().find("ADD8246A1F61417C818DF428BE41FDDB");
		
		InvoiceResponse responseInvoice = new InvoiceService().duplicate("C9D0758BB74641CABCF4436E15A98C7E",new Date());
		
		assertTrue( responseInvoice.getId() != null);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testRemoveMasterCustomer()
    {

    	//{"id":"C9D0758BB74641CABCF4436E15A98C7E","email":"marcel.ghisi@gmail.com","name":"MARCEL JOSE DA SILVA GHISI","notes":null,"created_at":"2016-01-09T17:58:05-02:00","updated_at":"2016-01-09T17:58:05-02:00","cc_emails":null,"cpf_cnpj":"02479484971","default_payment_method_id":null,"proxy_payments_from_customer_id":null,"custom_variables":[]}
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		CustomerResponse responseCustomer = new CustomerService().remove("4038F6126FE74DDBB265CC5334560AC8");
		
		assertTrue( responseCustomer.getId() != null);
		
		CustomerResponse responseFind = new CustomerService().find("4038F6126FE74DDBB265CC5334560AC8");
		
		assertTrue(responseFind.getErrors().get("errors").toString().contains("Customer Not Found"));
    }


    


}
