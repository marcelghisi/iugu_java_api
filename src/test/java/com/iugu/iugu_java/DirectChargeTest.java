package com.iugu.iugu_java;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.iugu.Iugu;
import com.iugu.model.Address;
import com.iugu.model.BankSlipDirectCharge;
import com.iugu.model.Customer;
import com.iugu.model.CustomerPaymentDirectCharge;
import com.iugu.model.Data;
import com.iugu.model.Invoice;
import com.iugu.model.InvoiceDirectCharge;
import com.iugu.model.Item;
import com.iugu.model.ItemType;
import com.iugu.model.PayableWith;
import com.iugu.model.Payer;
import com.iugu.model.PaymentMethodRequest;
import com.iugu.model.PaymentToken;
import com.iugu.model.TokenDirectCharge;
import com.iugu.responses.ChargeResponse;
import com.iugu.responses.CustomerResponse;
import com.iugu.responses.InvoiceResponse;
import com.iugu.responses.PaymentMethodResponse;
import com.iugu.responses.PaymentTokenResponse;
import com.iugu.services.CustomerService;
import com.iugu.services.InvoiceService;
import com.iugu.services.PaymentService;

/**
 * Testa pagamentos diretos.
 * 
 * Cearios
 * Tokem
 * PaymentId
 * Customer
 * Invoice
 * Boleto
 * MarketPlace Ativado
 * Parcelamento Desativado
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DirectChargeTest extends TestCase{
	
    public static class IntegratedTest { 
    	
    	private static String tokemTest1;
    	private static String email = "marcelghisi@gmail.com";
    	private static String invoiceId;
    	private static String customerId;
    	private static String customerPaymentId;
    	private static String masterApiTokemTeste = "21ab6ca14384901acaea1793b91cdc98";
    	private static String masterAccountId = "96461997-b6a0-48fb-808b-4f16ad88c718";
    	
        public void setToken(String s) {
            tokemTest1 = s;
        }               
        public String getToken() {
            return tokemTest1;
        }
        
        public void setCustomerId(String s) {
            customerId = s;
        }               
        public String getCustomerId() {
            return customerId;
        }
        
        public void setCustomerPaymentId(String s) {
            customerPaymentId = s;
        }               
        public String getCustomerPaymentId() {
            return customerPaymentId;
        }

        public void setApiToken(String s) {
            masterApiTokemTeste = s;
        }               
        public String getApiToken() {
            return masterApiTokemTeste;
        }
        
        public void setMasterAccountId(String s) {
            masterAccountId = s;
        }               
        public String getMasterAccountId() {
            return masterAccountId;
        }
        
        public void setInvoice(String s) {
            invoiceId = s;
        }               
        public String getInvoice() {
            return invoiceId;
        }
        
        public String getEmail() {
            return email;
        }
        
        
    }

    private IntegratedTest integratedTest;

    /**
     * Token
     * Cria um token de pagamento para pagamento direto, com o Id gerado é possível usálo ao invés de ficar usando os dados do cartão
     */
    @Override
    protected void setUp() throws Exception {
    	integratedTest = new IntegratedTest();
    	
		Iugu.init(integratedTest.getApiToken());
		
    	//Testa a criacao de uma Token de pagamento
		//Usa os dados de um cartao de teste
    	Data data = new Data("4242424242424242","123","Joao","Silva","12","2013");
    	
    	//Constroi o objeto com dados do pagamento
    	PaymentToken pT = new PaymentToken(integratedTest.getMasterAccountId(), PayableWith.CREDIT_CARD,data,Boolean.FALSE);
    	
    	//Cria o tokem
    	PaymentTokenResponse response = new PaymentService().createToken(pT);
    	
    	//Valida se o tokem foi criado
    	assertTrue(response != null);
    	//Valida se não retornou erros
    	assertTrue(response.getErrors() == null);
    	//Valida se não ocorreu erro 500
    	assertTrue(response.getStatusCode() == null);
    	//Seta o id Do Tokem para possível uso
    	integratedTest.setToken(response.getId());
    }
    

    /**
     * Pagamento com Token e opcionalmente um payer
     * Faz um pagamento direto sem possuir o cadastro do cliente apenas usando o e-mail e o tokem contendo os dados do cartão dele @see test1
     * Necessário passar os dados do pagador para antifraude
     */
	@Test
    public void testA()
    {

		Iugu.init(integratedTest.getApiToken());
		
		//Cria o item e valor que será pago
		Item item = new Item("Refeição",1,100);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		//Pega o endereço do pagador
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		//Constroi o objeto do pagador com endereço
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090",integratedTest.getEmail(),address);
		
		//Constroi o objeto Para pagamento Direto usando um token de cartão de crédito e opção payer obrigatorio para market place
		TokenDirectCharge cP = new TokenDirectCharge.Builder(integratedTest.getToken(),integratedTest.getEmail(),items).payer(payer).build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue(responseDirectCharge  != null);
		
		System.out.println(responseDirectCharge.getMessage());
    }
    
    /**
     * Pagamento com Tokem e opcionalmente Payer e Desconto
     * Faz um pagamento direto sem possuir o cadastro do cliente apenas usando o e-mail e o tokem contendo os dados do cartão dele e usando desconto no toal @see test1
     * Necessário passar os dados do pagador para antifraude
     */
	@Test
    public void testB()
    {

		Iugu.init(integratedTest.getApiToken());
		
		Item item = new Item("Refeição",1,1000);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090",integratedTest.getEmail(),address);
		
		TokenDirectCharge cP = new TokenDirectCharge.Builder(integratedTest.getToken(),integratedTest.getEmail(),items).payer(payer).discount(100).build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue(responseDirectCharge  != null);
		
		System.out.println(responseDirectCharge.getMessage());
    }
    
    /**
     * Parcelas
     * Faz um pagamento direto sem possuir o cadastro do cliente apenas usando o e-mail e o tokem contendo os dados do cartão dele e usando parcelas no toal @see test1
     * Necessário passar os dados do pagador para antifraude
     */
    public void testC()
    {
		Iugu.init(integratedTest.getApiToken());
		
		Item item = new Item("Refeição",1,200);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090",integratedTest.getEmail(),address);
		
		TokenDirectCharge cP = new TokenDirectCharge.Builder(integratedTest.getToken(),integratedTest.getEmail(),items).payer(payer).months(10).build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue(responseDirectCharge.getErrors() != null);
		
		assertTrue(responseDirectCharge.getErrors().get("base").toString().contains("o suporta parcelamento"));

    }
    
    /**
     * Pagamento com Boleto
     * Faz um pagamento direto com boleto usando payer
     */
	@Test
    public void testD()
    {
		Iugu.init(integratedTest.getApiToken());
		
		Item item = new Item("Refeição",1,300);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090",integratedTest.getEmail(),address);
		
		BankSlipDirectCharge cP = new BankSlipDirectCharge.Builder(integratedTest.getEmail(),items).payer(payer).build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue(responseDirectCharge.getInvoiceId()  != null);
		
		System.out.println(responseDirectCharge.getMessage());
    }
	
    /**
     * Cria um invoice
     * Cria um invoice com vencimento futuro para testar o direct charge de um invoice ja existente. Ex: Adiantamento de invoice
     */
	@Test
    public void testE()
    {
		Calendar c = Calendar.getInstance();  
		c.add(Calendar.DATE, 1);
		
		//Funfa cria fatura e envia boleto com invoice
		Iugu.init(integratedTest.getApiToken());
		
		Item item2 = new Item("Cafe",1,1200);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item2);
		
		//Cria uma fatura com vencimento amanha = pendente
		Invoice inv = new Invoice.Builder("marcelghisi@gmail.com", c.getTime(), items).build();
		
		InvoiceResponse response = new InvoiceService().create(inv);
        
		assertTrue( response != null );
		assertTrue(response.getErrors() == null);
		assertTrue(response.getStatusCode() == null);
		
		integratedTest.setInvoice(response.getId());

    }
    
    /**
     * Adianta o pagamento de um invoice
     * 
     */
	@Test
    public void testF()
    {

		Iugu.init(integratedTest.getApiToken());

		Item item = new Item("Refeição",1,300);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090",integratedTest.getEmail(),address);
		
		InvoiceDirectCharge cP = new InvoiceDirectCharge.Builder(integratedTest.getToken(),integratedTest.getInvoice()).payer(payer).build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue(responseDirectCharge.getInvoiceId()  != null);
		
		System.out.println(responseDirectCharge.getMessage());
    }
	
    /**
     * Cria um customer para testar direct charge para customer
     * 
     */
	@Test
    public void testG()
    {

		Iugu.init(integratedTest.getApiToken());
		
		Customer customer = new Customer("NOELI OLIVA XAVIER GHISI","noeli.ghisi@gmail.com","18788209822");

		CustomerResponse responseCustomer = new CustomerService().create(customer);
		
		assertTrue( responseCustomer != null);
		
		assertTrue(responseCustomer.getErrors() == null);
		assertTrue(responseCustomer.getStatusCode() == null);
		
		integratedTest.setCustomerId(responseCustomer.getId());
		
    }
	
    /**
     * Cria um pagamento para o customer
     * 
     */
	@Test
    public void testH()
    {
		Iugu.init(integratedTest.getApiToken());

		//Dados do cartao de credito da carteira do cliente
		Data data = new Data("4242424242424242","123","Joao","Silva","12","2013");
		
		PaymentMethodRequest pData = new PaymentMethodRequest(ItemType.CREDIT_CARD, integratedTest.getCustomerId(), "Cartão Passarela", data, Boolean.FALSE);
		
		PaymentMethodResponse responsePayM = new CustomerService().createPaymentMethod(pData);
		
		assertTrue( responsePayM != null);
		assertTrue(responsePayM.getErrors() == null);
		assertTrue(responsePayM.getStatusCode() == null);
		
		integratedTest.setCustomerPaymentId(responsePayM.getId());
    }
	
    /**
     * Pagamento direto Usando um Customer Payment Id sem anexar o Customer ID
     * 
     */
	@Test
    public void testI()
    {

		Iugu.init(integratedTest.getApiToken());

		Item item = new Item("Refeição",1,300);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090",integratedTest.getEmail(),address);
		
		CustomerPaymentDirectCharge cP = new CustomerPaymentDirectCharge.Builder(integratedTest.getCustomerPaymentId(),integratedTest.getEmail(),items).payer(payer).build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue( responseDirectCharge != null);
		assertTrue(responseDirectCharge.getInvoiceId() != null);
		assertTrue(responseDirectCharge.getStatusCode() == null);
    }
	
    /**
     * Pagamento direto Usando um Customer Payment Id e um Customer ID
     * 
     */
	@Test
    public void testJ()
    {

		Iugu.init(integratedTest.getApiToken());

		Item item = new Item("Refeição",1,300);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090",integratedTest.getEmail(),address);
		
		CustomerPaymentDirectCharge cP = new CustomerPaymentDirectCharge.Builder(integratedTest.getCustomerPaymentId(),integratedTest.getEmail(),items)
		.payer(payer)
		.customer(integratedTest.getCustomerId())
		.build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue( responseDirectCharge != null);
		assertTrue(responseDirectCharge.getInvoiceId() != null);
		assertTrue(responseDirectCharge.getStatusCode() == null);
    }
	
    /**
     * Pagamento direto Usando um Customer Payment Id e um Customer ID Com Cartao Invalido
     * 
     */
	@Test
    public void testK()
    {

		Iugu.init(integratedTest.getApiToken());

		Item item = new Item("Refeição",1,300);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090",integratedTest.getEmail(),address);
		
		CustomerPaymentDirectCharge cP = new CustomerPaymentDirectCharge.Builder(integratedTest.getCustomerPaymentId(),integratedTest.getEmail(),items)
		.payer(payer)
		.customer(integratedTest.getCustomerId())
		.build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue( responseDirectCharge != null);
		assertTrue(responseDirectCharge.getInvoiceId() != null);
		assertTrue(responseDirectCharge.getStatusCode() == null);
    }
	
    /**
     * Gera um pagamento Tokem com Cartao Invalido
     * 
     */
	@Test
    public void testL()
    {
		
		Iugu.init(integratedTest.getApiToken());
		
		//Testa a criacao de uma Token de pagamento
		//Usa os dados de um cartao de teste
		Data data = new Data("4012888888881881","123","Joao","Silva","12","2013");
		
		//Constroi o objeto com dados do pagamento
		PaymentToken pT = new PaymentToken(integratedTest.getMasterAccountId(), PayableWith.CREDIT_CARD,data,Boolean.FALSE);
		
		//Cria o tokem
		PaymentTokenResponse response = new PaymentService().createToken(pT);
		
		//Valida se o tokem foi criado
		assertTrue(response != null);
		//Valida se não retornou erros
		assertTrue(response.getErrors() == null);
		//Valida se não ocorreu erro 500
		assertTrue(response.getStatusCode() == null);
		//Seta o id Do Tokem para possível uso
		integratedTest.setToken(response.getId());
    }
	
    /**
     * Pagamento direto Usando Tokem Com Cartao Invalido
     * 
     */
	@Test
    public void testM()
    {

		Iugu.init(integratedTest.getApiToken());
		
		//Cria o item e valor que será pago
		Item item = new Item("Refeição",1,100);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		//Pega o endereço do pagador
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		//Constroi o objeto do pagador com endereço
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090",integratedTest.getEmail(),address);
		
		//Constroi o objeto Para pagamento Direto usando um token de cartão de crédito e opção payer obrigatorio para market place
		TokenDirectCharge cP = new TokenDirectCharge.Builder(integratedTest.getToken(),integratedTest.getEmail(),items).payer(payer).build();
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(cP);
		
		assertTrue(responseDirectCharge  != null);
		
		System.out.println(responseDirectCharge.getMessage());
    }
	

	

	
    
}
