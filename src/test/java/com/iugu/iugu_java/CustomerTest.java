package com.iugu.iugu_java;

import java.io.IOException;

import org.jboss.resteasy.util.Base64;

import com.iugu.Iugu;
import com.iugu.model.AccountType;
import com.iugu.model.Address;
import com.iugu.model.Bank;
import com.iugu.model.BankInformation;
import com.iugu.model.BankNumber;
import com.iugu.model.BankSlipConfiguration;
import com.iugu.model.BankUpdate;
import com.iugu.model.CreditCardConfiguration;
import com.iugu.model.Customer;
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
import com.iugu.responses.CustomerResponse;
import com.iugu.responses.MessageResponse;
import com.iugu.responses.RequestWithDrawResponse;
import com.iugu.responses.SubAccountInformationResponse;
import com.iugu.responses.SubAccountResponse;
import com.iugu.responses.SubAccountValidationResponse;
import com.iugu.services.CustomerService;
import com.iugu.services.MarketPlaceService;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CustomerTest 
    extends TestCase
{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CustomerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CustomerTest.class );
    }

    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testCreateNewMasterCustomer()
    {

    	//{"id":"E5A929BD4A364698ABA72568FAD15FE1","email":"marcel.ghisi@gmail.com","name":"MARCEL JOSE DA SILVA GHISI","notes":null,"created_at":"2016-01-09T18:14:08-02:00,"updated_at":"2016-01-09T17:58:05-02:00","cc_emails":null,"cpf_cnpj":"02479484971","default_payment_method_id":null,"proxy_payments_from_customer_id":null,"custom_variables":[]}
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		Customer customer = new Customer("MARCEL JOSE DA SILVA GHISI","marcel.ghisi@gmail.com","02479484971");

		CustomerResponse responseCustomer = new CustomerService().create(customer);
		
		assertTrue( responseCustomer.getId() != null);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testFindMasterCustomer()
    {

    	//{"id":"C9D0758BB74641CABCF4436E15A98C7E","email":"marcel.ghisi@gmail.com","name":"MARCEL JOSE DA SILVA GHISI","notes":null,"created_at":"2016-01-09T17:58:05-02:00","updated_at":"2016-01-09T17:58:05-02:00","cc_emails":null,"cpf_cnpj":"02479484971","default_payment_method_id":null,"proxy_payments_from_customer_id":null,"custom_variables":[]}
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		Customer customer = new Customer("MARCEL JOSE DA SILVA GHISI","marcel.ghisi@gmail.com","02479484971");

		CustomerResponse responseCustomer = new CustomerService().find("C9D0758BB74641CABCF4436E15A98C7E");
		
		assertTrue( responseCustomer.getId() != null);
		assertEquals(customer.getEmail(),responseCustomer.getEmail());
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testChangeMasterCustomer()
    {

    	//{"id":"C9D0758BB74641CABCF4436E15A98C7E","email":"marcel.ghisi@gmail.com","name":"MARCEL JOSE DA SILVA GHISI","notes":null,"created_at":"2016-01-09T17:58:05-02:00","updated_at":"2016-01-09T17:58:05-02:00","cc_emails":null,"cpf_cnpj":"02479484971","default_payment_method_id":null,"proxy_payments_from_customer_id":null,"custom_variables":[]}
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		Customer customer = new Customer("MARCEL GHISI","marcel.ghisi@gmail.com","02479484971");

		CustomerResponse responseCustomer = new CustomerService().change("C9D0758BB74641CABCF4436E15A98C7E",customer);
		
		assertTrue( responseCustomer.getId() != null);
		assertEquals(customer.getName(),responseCustomer.getName());
		
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
