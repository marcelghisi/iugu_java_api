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
		
		InvoiceResponse response = new InvoiceService().create(new Invoice("marcelghisi@gmail.com", new Date(), new Item("Manicure", 2, 100)));
        
		assertTrue( response != null );
    }
    
    /*
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testFindInvoice()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");

		InvoiceResponse responseCustomer = new InvoiceService().find("ADD8246A1F61417C818DF428BE41FDDB");
		
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
			
		InvoiceResponse responseInvoice = new InvoiceService().duplicate("ACBB1EE8553E4BC3963DA77E74B4AFA8",duplicateRequestDate);
		
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
		
		//Leia mais em: Trabalhando com as classes Date, Calendar e SimpleDateFormat em Java http://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401#ixzz3xUzipLgA
			
		Calendar c = Calendar.getInstance();  
		c.set(Calendar.MONTH, Calendar.MARCH); 
		c.set(Calendar.DAY_OF_MONTH, 18);
		
		ListInvoiceCriteria crit = new ListInvoiceCriteria.Builder().dueDate(c.getTime()).build();
		List<InvoiceResponse> responseInvoice = new InvoiceService().list(crit);
		
		assertTrue( responseInvoice.size() > 0);
		
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testListInvoiceslistWithParams()
    {

		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		
		//Leia mais em: Trabalhando com as classes Date, Calendar e SimpleDateFormat em Java http://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401#ixzz3xUzipLgA
			
		Calendar c = Calendar.getInstance();  
		c.set(Calendar.MONTH, Calendar.JANUARY); 
		c.set(Calendar.DAY_OF_MONTH, 18);
		
		ListInvoiceCriteria crit = new ListInvoiceCriteria.Builder().dueDate(c.getTime()).build();
		ListInvoiceResponse responseInvoice = new InvoiceService().listWithParams(crit);
		
		assertTrue( responseInvoice != null);
		
    }
    


    


}
