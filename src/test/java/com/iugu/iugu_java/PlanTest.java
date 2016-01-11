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

		PlanResponse responseCustomer = new PlanService().find("04371BD080C2440FA0C913228F1ADCCD");
		
		assertTrue( responseCustomer.getId() != null);
		//assertEquals(customer.getEmail(),responseCustomer.getEmail());
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testFindPlanIdentifier()
    {

    	//{"id":"04371BD080C2440FA0C913228F1ADCCD","name":"ATTENDME P200","identifier":"plano_premium","interval":1,"interval_type":"months","created_at":"2016-01-10T15:32:49-02:00","updated_at":"2016-01-10T15:32:49-02:00","prices":[{"created_at":"2016-01-10T15:32:49-02:00","currency":"BRL","id":"8D2F866DD85542798B76FBE3C7C341FA","plan_id":"04371BD080C2440FA0C913228F1ADCCD","updated_at":"2016-01-10T15:32:49-02:00","value_cents":30000}],"features":[],"payable_with":null}
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		PlanResponse responseCustomer = new PlanService().findByIdentifier("plano_basico");
		
		assertTrue( responseCustomer.getId() != null);
		//assertEquals(customer.getEmail(),responseCustomer.getEmail());
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testChangePlan()
    {

    	//{"id":"04371BD080C2440FA0C913228F1ADCCD","name":"ATTENDME P200","identifier":"plano_premium","interval":1,"interval_type":"months","created_at":"2016-01-10T15:32:49-02:00","updated_at":"2016-01-10T15:32:49-02:00","prices":[{"created_at":"2016-01-10T15:32:49-02:00","currency":"BRL","id":"8D2F866DD85542798B76FBE3C7C341FA","plan_id":"04371BD080C2440FA0C913228F1ADCCD","updated_at":"2016-01-10T15:32:49-02:00","value_cents":30000}],"features":[],"payable_with":null}
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		PlanResponse responseCustomer = new PlanService().findByIdentifier("plano_basico");

		Plan plan = new Plan("ATTENDME P250", "plano_basico", 2, IntervalType.WEEKS,Currency.BRL,10000);
		
		PlanResponse responseChange = new PlanService().change(responseCustomer.getId(),plan);
		assertTrue( responseChange.getId() != null);
		//assertEquals(customer.getEmail(),responseCustomer.getEmail());
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testRemovePlan()
    {

 		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		PlanResponse responsePlan = new PlanService().remove("402695DC136A466ABD2F5E3F375C7958");
		
		assertTrue( responsePlan.getId() != null);
		
		PlanResponse responseFind = new PlanService().find("402695DC136A466ABD2F5E3F375C7958");
		
		assertTrue(responseFind.getErrors().get("errors").toString().contains("Plan Not Found"));
    }


    


}
