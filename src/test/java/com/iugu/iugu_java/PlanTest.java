package com.iugu.iugu_java;

import com.iugu.Iugu;
import com.iugu.model.Currency;
import com.iugu.model.Customer;
import com.iugu.model.IntervalType;
import com.iugu.model.Plan;
import com.iugu.responses.CustomerResponse;
import com.iugu.responses.PlanResponse;
import com.iugu.services.CustomerService;
import com.iugu.services.PlanService;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PlanTest 
    extends TestCase
{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PlanTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PlanTest.class );
    }

    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testCreatePlan()
    {

    	//{"id":"3AE8AE3508554F36B0B547F858493DF0","name":"ATTENDME P100","identifier":"plano_basico","interval":1,"interval_type":"months","created_at":"2016-01-10T15:31:03-02:00","updated_at":"2016-01-10T15:31:03-02:00","prices":[{"created_at":"2016-01-10T15:31:03-02:00","currency":"BRL","id":"A8918B620D224C4CAAC6AC7E30E679DE","plan_id":"3AE8AE3508554F36B0B547F858493DF0","updated_at":"2016-01-10T15:31:03-02:00","value_cents":1000}],"features":[],"payable_with":null}
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		Plan plan = new Plan("ATTENDME P100", "plano_basico", 1, IntervalType.MONTHS,Currency.BRL,1000);

		PlanResponse planResponse = new PlanService().create(plan);
		
		assertTrue( planResponse.getId() != null);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testCreatePlan2()
    {

    	//{"id":"04371BD080C2440FA0C913228F1ADCCD","name":"ATTENDME P200","identifier":"plano_premium","interval":1,"interval_type":"months","created_at":"2016-01-10T15:32:49-02:00","updated_at":"2016-01-10T15:32:49-02:00","prices":[{"created_at":"2016-01-10T15:32:49-02:00","currency":"BRL","id":"8D2F866DD85542798B76FBE3C7C341FA","plan_id":"04371BD080C2440FA0C913228F1ADCCD","updated_at":"2016-01-10T15:32:49-02:00","value_cents":30000}],"features":[],"payable_with":null}
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		Plan plan = new Plan("ATTENDME P200", "plano_premium", 1, IntervalType.MONTHS,Currency.BRL,30000);

		PlanResponse planResponse = new PlanService().create(plan);
		
		assertTrue( planResponse.getId() != null);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testFindPlan()
    {

    	//{"id":"04371BD080C2440FA0C913228F1ADCCD","name":"ATTENDME P200","identifier":"plano_premium","interval":1,"interval_type":"months","created_at":"2016-01-10T15:32:49-02:00","updated_at":"2016-01-10T15:32:49-02:00","prices":[{"created_at":"2016-01-10T15:32:49-02:00","currency":"BRL","id":"8D2F866DD85542798B76FBE3C7C341FA","plan_id":"04371BD080C2440FA0C913228F1ADCCD","updated_at":"2016-01-10T15:32:49-02:00","value_cents":30000}],"features":[],"payable_with":null}
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		Customer customer = new Customer("MARCEL JOSE DA SILVA GHISI","marcel.ghisi@gmail.com","02479484971");

		//PlanResponse responseCustomer = new PlanResponse().
		
		//assertTrue( responseCustomer.getId() != null);
		//assertEquals(customer.getEmail(),responseCustomer.getEmail());
		
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
