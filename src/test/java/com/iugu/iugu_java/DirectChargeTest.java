package com.iugu.iugu_java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.iugu.Iugu;
import com.iugu.model.Address;
import com.iugu.model.BankSlipDirectCharge;
import com.iugu.model.CustomerPaymentDirectCharge;
import com.iugu.model.Data;
import com.iugu.model.Invoice;
import com.iugu.model.InvoiceDirectCharge;
import com.iugu.model.Item;
import com.iugu.model.PayableWith;
import com.iugu.model.Payer;
import com.iugu.model.PaymentToken;
import com.iugu.model.TokenDirectCharge;
import com.iugu.responses.ChargeResponse;
import com.iugu.responses.InvoiceResponse;
import com.iugu.responses.PaymentTokenResponse;
import com.iugu.services.InvoiceService;
import com.iugu.services.PaymentService;

/**
 * Unit test for simple App.
 */
public class DirectChargeTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DirectChargeTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DirectChargeTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testPaymentTokenGenerate()
    {
    	
    	Data data = new Data("4242424242424242","123","Joao","Silva","12","2013");
    	PaymentTokenResponse response = new PaymentService().createToken(
    			new PaymentToken("96461997-b6a0-48fb-808b-4f16ad88c718", PayableWith.CREDIT_CARD, true,data));
    	
    	assertTrue(response != null);
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testSimpleInvoiceChargeWithEmail()
    {

		//Funfa cria fatura e envia boleto com invoice
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		InvoiceResponse response = new InvoiceService().create(new Invoice("marcelghisi@gmail.com", new Date(), new Item("teste", 1, 100)));
        assertTrue( response != null );
    }
    
    

    
    /**
     * Rigourous Test :-)
     */
    public void testDirectChargeWithCustomerPayment()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		
		String token = "82EFB8FB193049E69161D958749E470F";
		
		String email = "marcel.ghisi@gmail.com";

		Item item = new Item("Refeição",1,100);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090",email,address);
		
		CustomerPaymentDirectCharge cP = new CustomerPaymentDirectCharge.Builder(token,email,items).payer(payer).build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue(responseDirectCharge  != null);
		
		System.out.println(responseDirectCharge.getMessage());
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testDirectChargeWithCustomerPaymentAndDiscount()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		
		String token = "82EFB8FB193049E69161D958749E470F";
		
		String email = "marcel.ghisi@gmail.com";

		Item item = new Item("Refeição",1,1000);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090",email,address);
		
		CustomerPaymentDirectCharge cP = new CustomerPaymentDirectCharge.Builder(token,email,items).payer(payer).discount(100).build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue(responseDirectCharge  != null);
		
		System.out.println(responseDirectCharge.getMessage());
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testDirectChargeWithCustomerPaymentAndParcelas()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		
		String token = "82EFB8FB193049E69161D958749E470F";
		
		String email = "marcel.ghisi@gmail.com";

		Item item = new Item("Refeição",1,2000);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090",email,address);
		
		CustomerPaymentDirectCharge cP = new CustomerPaymentDirectCharge.Builder(token,email,items).payer(payer).months(10).build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue(responseDirectCharge.getInvoiceId()  != null);
		
		System.out.println(responseDirectCharge.getMessage());
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testDirectChargeWithSimpleTokenAndEmail()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		Data data = new Data("4242424242424242","123","Joao","Silva","12","2013");
		PaymentTokenResponse response = new PaymentService().createToken(
				new PaymentToken("96461997-b6a0-48fb-808b-4f16ad88c718", PayableWith.CREDIT_CARD, true,data));

		assertTrue(response != null);
		
		String token = response.getId();
		
		
		String email = "marcel.ghisi@gmail.com";

		Item item = new Item("Refeição",1,300);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090",email,address);
		
		TokenDirectCharge cP = new TokenDirectCharge.Builder(token,email,items).payer(payer).build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue(responseDirectCharge.getInvoiceId()  != null);
		
		System.out.println(responseDirectCharge.getMessage());
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testDirectChargeWithBankSlip()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		Data data = new Data("4242424242424242","123","Joao","Silva","12","2013");
		PaymentTokenResponse response = new PaymentService().createToken(
				new PaymentToken("96461997-b6a0-48fb-808b-4f16ad88c718", PayableWith.CREDIT_CARD, true,data));

		assertTrue(response != null);
		
		String token = response.getId();
		
		
		String email = "marcel.ghisi@gmail.com";

		Item item = new Item("Refeição",1,300);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090",email,address);
		
		BankSlipDirectCharge cP = new BankSlipDirectCharge.Builder(email,items).payer(payer).build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue(responseDirectCharge.getInvoiceId()  != null);
		
		System.out.println(responseDirectCharge.getMessage());
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testDirectChargeWithSimpleTokenAndInvoice()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		Data data = new Data("4242424242424242","123","Joao","Silva","12","2013");
		PaymentTokenResponse response = new PaymentService().createToken(
				new PaymentToken("96461997-b6a0-48fb-808b-4f16ad88c718", PayableWith.CREDIT_CARD, true,data));

		assertTrue(response != null);
		
		String token = response.getId();
		
		
		String email = "marcel.ghisi@gmail.com";

		Item item = new Item("Refeição",1,300);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090",email,address);
		
		InvoiceDirectCharge cP = new InvoiceDirectCharge.Builder(token,"52B2A928B23140239490D76EA14D884A").payer(payer).build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue(responseDirectCharge.getInvoiceId()  != null);
		
		System.out.println(responseDirectCharge.getMessage());
    }
    
    //CABA3ACDA4A3490FAD1C737D29AEB719
}
