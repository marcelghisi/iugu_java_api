package com.iugu.iugu_java;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.iugu.Iugu;
import com.iugu.model.DuplicateInvoiceRequest;
import com.iugu.model.DuplicateItemsInvoiceRequest;
import com.iugu.model.Invoice;
import com.iugu.model.Item;
import com.iugu.model.ListInvoiceCriteria;
import com.iugu.responses.InvoiceResponse;
import com.iugu.responses.ListInvoiceResponse;
import com.iugu.services.InvoiceService;

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
		
		Item item2 = new Item("Cafe",1,1200);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item2);
		
		Invoice inv = new Invoice.Builder("marcelghisi@gmail.com", new Date(), items).build();
		
		InvoiceResponse response = new InvoiceService().create(inv);
        
		assertTrue( response != null );
    }
    
    public void testCreateInvoiceWithCustomer()
    {
		//Funfa cria fatura e envia boleto com invoice
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		Item item2 = new Item("Cafe",1,1200);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item2);
		
		Invoice inv = new Invoice.Builder("marcelghisi@gmail.com", new Date(), items).customerId("E5A929BD4A364698ABA72568FAD15FE1").build();
		
		InvoiceResponse response = new InvoiceService().create(inv);
        
		assertTrue( response != null );
    }
    
    public void testCreateInvoiceWithCustomerInvoice()
    {
		//Funfa cria fatura e envia boleto com invoice
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		Item item2 = new Item("Cafe",1,1200);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item2);
		
		Invoice inv = new Invoice.Builder("marcelghisi@gmail.com", new Date(), items)
		.customerId("E5A929BD4A364698ABA72568FAD15FE1")
		.subscriptionId("C4AE4B969B6F4B85A64BE83AC1F206D2")
		.build();
		
		InvoiceResponse response = new InvoiceService().create(inv);
        
		assertTrue( response != null );
    }
    
    /*
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testFindInvoice()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		InvoiceResponse responseCustomer = new InvoiceService().find("990FFB91E6FD4FEC892BAF52B8EC2AB7");
		
		assertTrue( responseCustomer != null);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testChangeInvoice()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		InvoiceResponse responseInvoice = new InvoiceService().find("B1540CA6ACDA44F3A42C47748CE43C28");
		
		Invoice invoice = new Invoice(responseInvoice);
		invoice.setDiscountCents(100);
		
		InvoiceResponse responseChange = new InvoiceService().change(invoice);

		
		assertTrue( responseChange.getDiscountCents() != null);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testCaptureInvoice()
    {
    	//TODO Testar com sub conta de avaliacao das faturas

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		InvoiceResponse responseInvoice = new InvoiceService().capture("ADD8246A1F61417C818DF428BE41FDDB");
		
		assertTrue( responseInvoice.getId() != null);
		
    }
    
    /**
     * Rigourous Test : testDuplicateInvoice
     */
    public void testDuplicateInvoiceWithNewDate()
    {

    	//BUG Aberto na iugu
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		//New Expire Date
		Calendar c = Calendar.getInstance();  
		c.set(Calendar.MONTH, Calendar.MARCH); 
		c.set(Calendar.DAY_OF_MONTH, 23);
		
		DuplicateInvoiceRequest duplicateRequestDate = new DuplicateInvoiceRequest(c.getTime(), Boolean.FALSE, Boolean.FALSE);

		//Leia mais em: Trabalhando com as classes Date, Calendar e SimpleDateFormat em Java http://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401#ixzz3xUzipLgA
			
		InvoiceResponse responseInvoice = new InvoiceService().duplicate("990FFB91E6FD4FEC892BAF52B8EC2AB7",duplicateRequestDate);
		
		assertTrue( responseInvoice.getStatusCode() != null);
		assertTrue( responseInvoice.getId() != null);
		
    }
    
    /**
     * Rigourous Test : testDuplicateInvoice
     */
    public void testDuplicateInvoiceAddItem()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		InvoiceResponse responseInvoice = new InvoiceService().find("638FF3F181ED4B27B60536398427AD62");
		
		//New Expire Date
		Calendar c = Calendar.getInstance();  
		c.set(Calendar.MONTH, Calendar.MARCH); 
		c.set(Calendar.DAY_OF_MONTH, 20);
		
		Item item = new Item("Almoço",1,1200);
		Item item2 = new Item("Cafe",1,1200);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		items.add(item2);
		
		DuplicateItemsInvoiceRequest duplicateRequestDate = new DuplicateItemsInvoiceRequest(c.getTime(), items, Boolean.FALSE, Boolean.FALSE);

		//Leia mais em: Trabalhando com as classes Date, Calendar e SimpleDateFormat em Java http://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401#ixzz3xUzipLgA
			
		InvoiceResponse responseInvoiceD = new InvoiceService().duplicate(responseInvoice.getId(),duplicateRequestDate);
		
		assertTrue( responseInvoiceD.getId() != null);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testDuplicateInvoiceEliminandoItem()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		InvoiceResponse responseInvoice = new InvoiceService().find("8A1DB9601D3744D6B40718447C7ECE69");
		
		//New Expire Date
		Calendar c = Calendar.getInstance();  
		c.set(Calendar.MONTH, Calendar.MARCH); 
		c.set(Calendar.DAY_OF_MONTH, 25);
		
		List<Item> items = responseInvoice.getItems();
		items.get(0).setDestroy(Boolean.TRUE);
		items.get(1).setDestroy(Boolean.TRUE);
		//items.get(0).setDestroy(Boolean.TRUE);
		
		DuplicateItemsInvoiceRequest duplicateRequestDate = new DuplicateItemsInvoiceRequest(c.getTime(), items, Boolean.FALSE, Boolean.FALSE);

		//Leia mais em: Trabalhando com as classes Date, Calendar e SimpleDateFormat em Java http://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401#ixzz3xUzipLgA
			
		InvoiceResponse responseInvoiceD = new InvoiceService().duplicate(responseInvoice.getId(),duplicateRequestDate);
		
		assertTrue( responseInvoiceD.getId() != null);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testRemoveInvoice()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		//Leia mais em: Trabalhando com as classes Date, Calendar e SimpleDateFormat em Java http://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401#ixzz3xUzipLgA
			
		InvoiceResponse responseInvoice = new InvoiceService().remove("F425F2C510E7410897E6E6DE20D400D3");
		
		assertTrue( responseInvoice.getId() != null);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testCancelInvoice()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		//Leia mais em: Trabalhando com as classes Date, Calendar e SimpleDateFormat em Java http://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401#ixzz3xUzipLgA
			
		InvoiceResponse responseInvoice = new InvoiceService().cancel("B6E612827DBA4CE6B567524D9EAEA14E");
		
		assertTrue( responseInvoice.getId() != null);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testRefundInvoice()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		//Leia mais em: Trabalhando com as classes Date, Calendar e SimpleDateFormat em Java http://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401#ixzz3xUzipLgA
			
		InvoiceResponse responseInvoice = new InvoiceService().refund("6944C806BA9840F381C24DF8AC7F2D6A");
		
		assertTrue( responseInvoice.getId() != null);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testListInvoices()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
			
		Calendar c = Calendar.getInstance();  
		c.set(Calendar.MONTH, Calendar.MARCH); 
		c.set(Calendar.DAY_OF_MONTH, 20);
		
		ListInvoiceCriteria crit = new ListInvoiceCriteria.Builder().dueDate(c.getTime()).build();
		ListInvoiceResponse responseInvoice = new InvoiceService().list(crit);
		
		assertTrue( responseInvoice.getItems().size() == 6);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testListInvoicesByCustomer()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		ListInvoiceCriteria crit = new ListInvoiceCriteria.Builder().customerId("E5A929BD4A364698ABA72568FAD15FE1").build();
		ListInvoiceResponse responseInvoice = new InvoiceService().list(crit);
		
		assertTrue( responseInvoice.getItems().size() == 3);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testListInvoicesByCustomerWithLimit()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		ListInvoiceCriteria crit = new ListInvoiceCriteria.Builder().customerId("E5A929BD4A364698ABA72568FAD15FE1").limit(2).build();
		ListInvoiceResponse responseInvoice = new InvoiceService().list(crit);
		
		assertTrue( responseInvoice.getItems().size() == 2);
		
    }
    
    public void testListInvoicesByCustomerWithLimitAndStart()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		ListInvoiceCriteria crit = new ListInvoiceCriteria.Builder().limit(10).start(0).build();
		ListInvoiceResponse responseInvoice = new InvoiceService().list(crit);
		
		assertEquals( responseInvoice.getItems().get(9).getId(),"7B09529D23DB47AEAC6AFCE7ACDE0A0E");
		
    }
    
    public void testListInvoicesByCustomerWithLimitAndStart10()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		ListInvoiceCriteria crit = new ListInvoiceCriteria.Builder().limit(10).start(9).build();
		ListInvoiceResponse responseInvoice = new InvoiceService().list(crit);
		
		assertEquals( responseInvoice.getItems().get(0).getId(),"7B09529D23DB47AEAC6AFCE7ACDE0A0E");
		
    }
    
    public void testListInvoicesUpdatedSince()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
			
		Calendar c = Calendar.getInstance();  
		c.set(Calendar.MONTH, Calendar.JANUARY); 
		c.set(Calendar.DAY_OF_MONTH, 10);
		
		ListInvoiceCriteria crit = new ListInvoiceCriteria.Builder().updatedSince(c.getTime()).build();
		ListInvoiceResponse responseInvoice = new InvoiceService().list(crit);
		
		assertTrue( responseInvoice.getItems().size() == 43);
		
    }


    


}
