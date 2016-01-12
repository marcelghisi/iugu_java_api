package com.iugu.iugu_java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.iugu.Iugu;
import com.iugu.model.Address;
import com.iugu.model.Data;
import com.iugu.model.MailDirectCharge;
import com.iugu.model.Invoice;
import com.iugu.model.Item;
import com.iugu.model.PayableWith;
import com.iugu.model.Payer;
import com.iugu.model.PaymentToken;
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
    public void testDirectChargeForTokenSimpleConstructor()
    {
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
    	Data data = new Data("4242424242424242","123","Joao","Silva","12","2013");
    	PaymentTokenResponse response = new PaymentService().createToken(
    			new PaymentToken("96461997-b6a0-48fb-808b-4f16ad88c718", PayableWith.CREDIT_CARD, false,data));
    	
    	assertTrue(response != null);
    	
    	String token = response.getId();
    	
    	Item item = new Item("Refeição",1,100);
    	List<Item> items = new ArrayList<Item>(0);
    	items.add(item);
    	
    	//Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR"); A80303DF00BE40459DD0109B0E1DB392
    	
    	//Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090","teste@teste.com",address);
    	
    	ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(
    			new MailDirectCharge(token,"marcel.ghisi@gmail.com",items));//payer));
    	assertTrue(responseDirectCharge  != null);
    	System.out.println(responseDirectCharge.getMessage());
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
    public void testDirectChargeForTokenWithPayerConstructor()
    {

		Data data = new Data("4242424242424242","123","Joao","Silva","12","2013");
		PaymentTokenResponse response = new PaymentService().createToken(
				new PaymentToken("96461997-b6a0-48fb-808b-4f16ad88c718", PayableWith.CREDIT_CARD, true,data));

		assertTrue(response != null);
		
		String token = response.getId();

		Item item = new Item("Refeição",1,100);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090","teste@teste.com",address);
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(
				new MailDirectCharge(token,"teste@teste.com",items,payer));
		assertTrue(responseDirectCharge  != null);
		System.out.println(responseDirectCharge.getMessage());
    }
}
