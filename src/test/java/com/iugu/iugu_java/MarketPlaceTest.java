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
import com.iugu.responses.MessageResponse;
import com.iugu.responses.RequestWithDrawResponse;
import com.iugu.responses.SubAccountInformationResponse;
import com.iugu.responses.SubAccountResponse;
import com.iugu.responses.SubAccountValidationResponse;
import com.iugu.services.MarketPlaceService;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MarketPlaceTest 
    extends TestCase
{
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MarketPlaceTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MarketPlaceTest.class );
    }

    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testCreatePJTesteSubAccount()
    {

    	//{"account_id":"BFE13F587384440BB8A05E63BC74B961","name":"Marcel Ghisi","live_api_token":"56e9b3a30990a8c97260d475bca4f11f","test_api_token":"4485d3d52775dbccccc4b64eb5ccf996","user_token":"e6a1bc0e23f73fa6187c77b889a5d836"}
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		SubAccountResponse responseSubAccount = new MarketPlaceService().createSubAccount(new SubAccount("Marcel Ghisi",1));
		
		assertTrue( responseSubAccount.getId() != null);
		
		System.out.println("TESTANDO CREATE SUBACCOUNT");
		System.out.println(" ACCOUNT ID: " + responseSubAccount.getId() + ";");
		System.out.println(" LIVE TOKEN: " + responseSubAccount.getLiveApiToken()+ ";");
		System.out.println(" TEST TOKEN: " + responseSubAccount.getTestApiToken()+ ";");
		System.out.println(" USER TOKEN: " + responseSubAccount.getTestApiToken()+ ";");

		
		System.out.println("TESTANDO VALIDATE CNPJ");
		System.out.print(" Message: " + responseSubAccount.getMessage() + ";");
		System.out.print(" Success: " + responseSubAccount.getSuccess()+ ";");
		System.out.print(" Code: " + responseSubAccount.getStatusCode()+ ";");
		
		System.out.println("END CERATION SUB ACCOUNT");
		
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testFindSubAccount()
    {

    	//{"account_id":"BFE13F587384440BB8A05E63BC74B961","name":"Marcel Ghisi","live_api_token":"56e9b3a30990a8c97260d475bca4f11f","test_api_token":"4485d3d52775dbccccc4b64eb5ccf996","user_token":"e6a1bc0e23f73fa6187c77b889a5d836"}
		
		Iugu.init("e6a1bc0e23f73fa6187c77b889a5d836");
		SubAccountInformationResponse responseInformation = new MarketPlaceService().find("BFE13F587384440BB8A05E63BC74B961");
		
		System.out.println("TESTANDO FIND SUBACCOUNT");
		System.out.print(" ID: " + responseInformation.getId() + ";");
		System.out.print(" Name: " + responseInformation.getName()+ ";");
		
		//Response
		//{"id":"BFE13F587384440BB8A05E63BC74B961","name":"Marcel Ghisi","created_at":"2016-01-07T19:16:10-02:00","updated_at":"2016-01-07T19:16:12-02:00","can_receive?":false,"is_verified?":false,"last_verification_request_status":null,"last_verification_request_data":null,"last_verification_request_feedback":null,"change_plan_type":1,"subscriptions_trial_period":0,"subscriptions_billing_days":null,"disable_emails":false,"last_withdraw":null,"reply_to":null,"webapp_on_test_mode":false,"marketplace":false,"default_return_url":null,"credit_card_verified":null,"fines":null,"late_payment_fine":null,"per_day_interest":null,"auto_withdraw":false,"payment_email_notification":false,"auto_advance":false,"auto_advance_type":null,"auto_advance_option":null,"balance":"R$ 0,00","protected_balance":"R$ 0,00","payable_balance":"R$ 0,00","receivable_balance":"R$ 0,00","commission_balance":"R$ 0,00","volume_last_month":"R$ 0,00","volume_this_month":"R$ 0,00","total_subscriptions":0,"total_active_subscriptions":0,"taxes_paid_last_month":"R$ 0,00","taxes_paid_this_month":"R$ 0,00","custom_logo_url":null,"custom_logo_small_url":null,"informations":[{"key":"commission_percent","value":"1.0"}],"configuration":{"auto_withdraw":false,"payment_email_notification":false,"auto_advance":null,"auto_advance_type":null,"auto_advance_option":null,"commission_percent":1.0,"fines":null,"late_payment_fine":null,"per_day_interest":null,"bank_slip":{"active":true,"extra_due":"0","reprint_extra_due":"0"},"credit_card":{"active":false,"soft_descriptor":"","installments":false,"installments_pass_interest":false,"max_installments":"0","max_installments_without_interest":"0","two_step_transaction":false}}}
		
		assertTrue( responseInformation.getId() != null);
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testValidateCNPJInvalidoSubAccount()
    {

    	//{"account_id":"BFE13F587384440BB8A05E63BC74B961","name":"Marcel Ghisi","live_api_token":"56e9b3a30990a8c97260d475bca4f11f","test_api_token":"4485d3d52775dbccccc4b64eb5ccf996","user_token":"e6a1bc0e23f73fa6187c77b889a5d836"}
    	
		Iugu.init("e6a1bc0e23f73fa6187c77b889a5d836");
		SubAccountInformationResponse responseInformation = new MarketPlaceService().find("BFE13F587384440BB8A05E63BC74B961");
		
		String accountId = responseInformation.getId().toString();
		
		MainSetthingsData mainSetthingsData = new MainSetthingsData("Serviços de Informática",SubAccountPriceRange.ENTRE_100_500,Boolean.FALSE,Boolean.TRUE);
		LegalPersonData pJ = new LegalPersonData("03125011000171", "GHISI TECNOLOGIA EM SISTEMAS", "Marcel Ghisi", "02479484971", "11-96766-1709");
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		BankInformation bankInfo = new BankInformation(Bank.ITAU, AccountType.Corrente, "0036", "07722-0");
		
		SubAccountValidationData data = new SubAccountValidationData(mainSetthingsData,bankInfo,address,pJ);
		//SubAccountValidationFiles files = new SubAccountValidationFiles("AAA","BBBBB","CCCC");
		
		SubAccountValidation subAccountValidation = new SubAccountValidation(data, null, Boolean.FALSE);
		
		//Iugu.init("849da38aec9bba86b2c2152728b9cd67");
		SubAccountValidationResponse responseSubAccountValidation = new MarketPlaceService().createSubAccountValidation(accountId, subAccountValidation);
		
		//assertTrue(responseSubAccountValidation.getErrors().get("cnpj") != null);
		
		assertFalse( responseSubAccountValidation.getSuccess());
		
		//Response
		//{"errors":{"cnpj":["n\u00e3o \u00e9 v\u00e1lido"]}}
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testValidateCNPJValidoSubAccount()
    {

    	//{"account_id":"BFE13F587384440BB8A05E63BC74B961","name":"Marcel Ghisi","live_api_token":"56e9b3a30990a8c97260d475bca4f11f","test_api_token":"4485d3d52775dbccccc4b64eb5ccf996","user_token":"e6a1bc0e23f73fa6187c77b889a5d836"}
    	
		Iugu.init("e6a1bc0e23f73fa6187c77b889a5d836");
		SubAccountInformationResponse responseInformation = new MarketPlaceService().find("BFE13F587384440BB8A05E63BC74B961");
		
		String accountId = responseInformation.getId().toString();

		MainSetthingsData mainSetthingsData = new MainSetthingsData("Serviços de Informática",SubAccountPriceRange.ENTRE_100_500,Boolean.FALSE,Boolean.TRUE);
		LegalPersonData pJ = new LegalPersonData("03487102000171", "GHISI TECNOLOGIA EM SISTEMAS", "Marcel Ghisi", "02479484971", "11-96766-1709");
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		BankInformation bankInfo = new BankInformation(Bank.ITAU, AccountType.Corrente, "0036", "07722-0");
		
		String b64 = null; 

		try {
			b64 = Base64.encodeFromFile("//Users//marcel//Desktop/CNH.png");
		} catch (IOException e) {

		}
		
		//Precisa de um documento PNG  para fazer o teste
		assertNotNull(b64);
		
		//Dados do SubAccount para validar
		SubAccountValidationData data = new SubAccountValidationData(mainSetthingsData,bankInfo,address,pJ);
		
		//Arquivos com o base 64 das imagens para validar
		SubAccountValidationFiles files = new SubAccountValidationFiles(b64,b64,b64);
		
		SubAccountValidation subAccountValidation = new SubAccountValidation(data, files, Boolean.FALSE);
		
		SubAccountValidationResponse responseSubAccountValidation = new MarketPlaceService().createSubAccountValidation(accountId, subAccountValidation);
		
		assertTrue(responseSubAccountValidation.getErrors() == null);
		
		assertFalse( responseSubAccountValidation.getSuccess());
		
		//Response
		//{"errors":{"cnpj":["n\u00e3o \u00e9 v\u00e1lido"]}}
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testVerifyIsPendingVerificationCNPJ()
    {
    	//{"account_id":"BFE13F587384440BB8A05E63BC74B961","name":"Marcel Ghisi","live_api_token":"56e9b3a30990a8c97260d475bca4f11f","test_api_token":"4485d3d52775dbccccc4b64eb5ccf996","user_token":"e6a1bc0e23f73fa6187c77b889a5d836"}
		
		Iugu.init("e6a1bc0e23f73fa6187c77b889a5d836");
		SubAccountInformationResponse responseInformation = new MarketPlaceService().find("BFE13F587384440BB8A05E63BC74B961");
		
		assertTrue( responseInformation.getLastVerificationRequestStatus().contains("pending"));
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testConfigureSoftDescriptionCnpjSubAccount()
    {

    	//{"account_id":"9945CFA951234A85870B7C98E5283836","name":"Noeli Ghisi","live_api_token":"251df262110fc3d74ea3262c20093bbe","test_api_token":"744939511d57522c618466cc5966b72a","user_token":"06fa4a7767762feb3c0b82ebd3143944"}
    	
		Iugu.init("e6a1bc0e23f73fa6187c77b889a5d836");

		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration(null, null, null, null, null, null, null, null);
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration(true, null, null);
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration(null,"ATTENDME PJ", null, null,null,null,null);
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService().configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		assertEquals("ATTENDME PJ", responseInformationResp.getConfiguration().getCreditCardConfiguration().getSoftDescriptor());
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testConfigureKeepSoftDescriptionAndChangeComissionPercentCnpjSubAccount()
    {

    	//{"account_id":"9945CFA951234A85870B7C98E5283836","name":"Noeli Ghisi","live_api_token":"251df262110fc3d74ea3262c20093bbe","test_api_token":"744939511d57522c618466cc5966b72a","user_token":"06fa4a7767762feb3c0b82ebd3143944"}
    	
		Iugu.init("e6a1bc0e23f73fa6187c77b889a5d836");

		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration(2, null, null, null, null, null, null, null);
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration(true, null, null);
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration(null,null, null, null,null,null,null);
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService().configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		//Verifica se manteve o SoftDescription
		assertEquals("ATTENDME PJ", responseInformationResp.getConfiguration().getCreditCardConfiguration().getSoftDescriptor());
		//Verifica se alterou o Percentual de comissão da conta
		assertEquals(new Integer(2), responseInformationResp.getConfiguration().getComissionPercent());
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testConfigureKeepComissionPercentAndChangeAutoWithDraw()
    {

    	//{"account_id":"9945CFA951234A85870B7C98E5283836","name":"Noeli Ghisi","live_api_token":"251df262110fc3d74ea3262c20093bbe","test_api_token":"744939511d57522c618466cc5966b72a","user_token":"06fa4a7767762feb3c0b82ebd3143944"}
    	
		Iugu.init("e6a1bc0e23f73fa6187c77b889a5d836");

		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration(null, Boolean.TRUE, null, null, null, null, null, null);
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration(true, null, null);
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration(null,null, null, null,null,null,null);
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService().configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		//Verifica se manteve o SoftDescription
		assertEquals("ATTENDME PJ", responseInformationResp.getConfiguration().getCreditCardConfiguration().getSoftDescriptor());
		//Mantem Percentual do teste acima
		assertEquals(new Integer(2), responseInformationResp.getConfiguration().getComissionPercent());
		//Verifica se alterou o WithDraw para True
		assertEquals(Boolean.TRUE, responseInformationResp.getAutoWithdraw());
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testConfigureBankSlip()
    {

    	//{"account_id":"9945CFA951234A85870B7C98E5283836","name":"Noeli Ghisi","live_api_token":"251df262110fc3d74ea3262c20093bbe","test_api_token":"744939511d57522c618466cc5966b72a","user_token":"06fa4a7767762feb3c0b82ebd3143944"}
    	
		Iugu.init("e6a1bc0e23f73fa6187c77b889a5d836");

		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration(null, null, null, null, null, null, null, null);
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration(Boolean.TRUE, 2, 2);
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration(null,null, null, null,null,null,null);
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService().configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		assertEquals(Boolean.TRUE, responseInformationResp.getConfiguration().getBankSlipConfiguration().getActive());
		assertEquals(new Integer(2), responseInformationResp.getConfiguration().getBankSlipConfiguration().getExtraDue());
		assertEquals(new Integer(2), responseInformationResp.getConfiguration().getBankSlipConfiguration().getReprintExtraDue());
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testReConfigureBankSlip()
    {

    	//{"account_id":"9945CFA951234A85870B7C98E5283836","name":"Noeli Ghisi","live_api_token":"251df262110fc3d74ea3262c20093bbe","test_api_token":"744939511d57522c618466cc5966b72a","user_token":"06fa4a7767762feb3c0b82ebd3143944"}
    	
		Iugu.init("e6a1bc0e23f73fa6187c77b889a5d836");

		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration(null, null, null, null, null, null, null, null);
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration(Boolean.FALSE, 1, 1);
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration(null,null, null, null,null,null,null);
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService().configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		assertEquals(Boolean.FALSE, responseInformationResp.getConfiguration().getBankSlipConfiguration().getActive());
		assertEquals(new Integer(1), responseInformationResp.getConfiguration().getBankSlipConfiguration().getExtraDue());
		assertEquals(new Integer(1), responseInformationResp.getConfiguration().getBankSlipConfiguration().getReprintExtraDue());
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testConfigureCreditCard()
    {

    	//{"account_id":"9945CFA951234A85870B7C98E5283836","name":"Noeli Ghisi","live_api_token":"251df262110fc3d74ea3262c20093bbe","test_api_token":"744939511d57522c618466cc5966b72a","user_token":"06fa4a7767762feb3c0b82ebd3143944"}
    	
		Iugu.init("e6a1bc0e23f73fa6187c77b889a5d836");

		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration(null, null, null, null, null, null, null, null);
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration(null, null, null);
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration(Boolean.TRUE,"ATTENDCHANG", Boolean.TRUE,Boolean.TRUE,10,6,Boolean.TRUE);
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService().configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		//Verifica se manteve o SoftDescription
		
		//Mantem Percentual do teste acima
		assertEquals(new Integer(2), responseInformationResp.getConfiguration().getComissionPercent());
		//Verifica se alterou o WithDraw para True
		//assertEquals(Boolean.TRUE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getActive());
		//Descrição na fatura do cartao do cliente
		assertEquals("ATTENDCHANG", responseInformationResp.getConfiguration().getCreditCardConfiguration().getSoftDescriptor());
		//Aceita parcelado
		assertEquals(Boolean.TRUE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getInstallments());
		//Se aceita sem juros
		assertEquals(Boolean.TRUE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getInstallmentsPassInterest());
		//Maximo de parcelas
		assertEquals(new Integer(10), responseInformationResp.getConfiguration().getCreditCardConfiguration().getMaxInstallments());
		//Parcelas sem juros
		assertEquals(new Integer(6), responseInformationResp.getConfiguration().getCreditCardConfiguration().getMaxInstallmentsWithoutInterest());
		//Se bloqueia a transacao em avaliacao para so depois cobrar
		assertEquals(Boolean.TRUE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getTwoStepTransaction());
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testReConfigureCreditCard()
    {

    	//{"account_id":"9945CFA951234A85870B7C98E5283836","name":"Noeli Ghisi","live_api_token":"251df262110fc3d74ea3262c20093bbe","test_api_token":"744939511d57522c618466cc5966b72a","user_token":"06fa4a7767762feb3c0b82ebd3143944"}
    	
		Iugu.init("e6a1bc0e23f73fa6187c77b889a5d836");

		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration(null, null, null, null, null, null, null, null);
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration(null, null, null);
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration(Boolean.TRUE,"ATTENDCH", Boolean.FALSE,Boolean.FALSE,12,8,Boolean.FALSE);
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService().configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		//Verifica se alterou o WithDraw para True
		//assertEquals(Boolean.TRUE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getActive());
		//Descrição na fatura do cartao do cliente
		assertEquals("ATTENDCH", responseInformationResp.getConfiguration().getCreditCardConfiguration().getSoftDescriptor());
		//Aceita parcelado
		assertEquals(Boolean.FALSE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getInstallments());
		//Se aceita sem juros
		assertEquals(Boolean.FALSE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getInstallmentsPassInterest());
		//Maximo de parcelas
		assertEquals(new Integer(12), responseInformationResp.getConfiguration().getCreditCardConfiguration().getMaxInstallments());
		//Parcelas sem juros
		assertEquals(new Integer(8), responseInformationResp.getConfiguration().getCreditCardConfiguration().getMaxInstallmentsWithoutInterest());
		//Se bloqueia a transacao em avaliacao para so depois cobrar
		assertEquals(Boolean.FALSE, responseInformationResp.getConfiguration().getCreditCardConfiguration().getTwoStepTransaction());
    }
    
    /**
     * Rigourous Test : testCreatePJTesteSubAccount
     */
    public void testCreatePFTesteSubAccount()
    {

    	//{"account_id":"9945CFA951234A85870B7C98E5283836","name":"Noeli Ghisi","live_api_token":"251df262110fc3d74ea3262c20093bbe","test_api_token":"744939511d57522c618466cc5966b72a","user_token":"06fa4a7767762feb3c0b82ebd3143944"}
    	
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		SubAccountResponse responseSubAccount = new MarketPlaceService().createSubAccount(new SubAccount("Noeli Ghisi",1));
		
		assertTrue( responseSubAccount.getId() != null);
		
		System.out.println("TESTANDO CREATE SUBACCOUNT");
		System.out.println(" ACCOUNT ID: " + responseSubAccount.getId() + ";");
		System.out.println(" LIVE TOKEN: " + responseSubAccount.getLiveApiToken()+ ";");
		System.out.println(" TEST TOKEN: " + responseSubAccount.getTestApiToken()+ ";");
		System.out.println(" USER TOKEN: " + responseSubAccount.getTestApiToken()+ ";");

		
		System.out.println("TESTANDO VALIDATE CNPJ");
		System.out.print(" Message: " + responseSubAccount.getMessage() + ";");
		System.out.print(" Success: " + responseSubAccount.getSuccess()+ ";");
		System.out.print(" Code: " + responseSubAccount.getStatusCode()+ ";");
		
		System.out.println("END CERATION SUB ACCOUNT");
		
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testFindSubAccountPF()
    {

    	//{"account_id":"BFE13F587384440BB8A05E63BC74B961","name":"Marcel Ghisi","live_api_token":"56e9b3a30990a8c97260d475bca4f11f","test_api_token":"4485d3d52775dbccccc4b64eb5ccf996","user_token":"e6a1bc0e23f73fa6187c77b889a5d836"}
		
		Iugu.init("06fa4a7767762feb3c0b82ebd3143944");
		SubAccountInformationResponse responseInformation = new MarketPlaceService().find("9945CFA951234A85870B7C98E5283836");
		
		System.out.println("TESTANDO FIND SUBACCOUNT");
		System.out.print(" ID: " + responseInformation.getId() + ";");
		System.out.print(" Name: " + responseInformation.getName()+ ";");
		
		//Response
		//{"id":"BFE13F587384440BB8A05E63BC74B961","name":"Marcel Ghisi","created_at":"2016-01-07T19:16:10-02:00","updated_at":"2016-01-07T19:16:12-02:00","can_receive?":false,"is_verified?":false,"last_verification_request_status":null,"last_verification_request_data":null,"last_verification_request_feedback":null,"change_plan_type":1,"subscriptions_trial_period":0,"subscriptions_billing_days":null,"disable_emails":false,"last_withdraw":null,"reply_to":null,"webapp_on_test_mode":false,"marketplace":false,"default_return_url":null,"credit_card_verified":null,"fines":null,"late_payment_fine":null,"per_day_interest":null,"auto_withdraw":false,"payment_email_notification":false,"auto_advance":false,"auto_advance_type":null,"auto_advance_option":null,"balance":"R$ 0,00","protected_balance":"R$ 0,00","payable_balance":"R$ 0,00","receivable_balance":"R$ 0,00","commission_balance":"R$ 0,00","volume_last_month":"R$ 0,00","volume_this_month":"R$ 0,00","total_subscriptions":0,"total_active_subscriptions":0,"taxes_paid_last_month":"R$ 0,00","taxes_paid_this_month":"R$ 0,00","custom_logo_url":null,"custom_logo_small_url":null,"informations":[{"key":"commission_percent","value":"1.0"}],"configuration":{"auto_withdraw":false,"payment_email_notification":false,"auto_advance":null,"auto_advance_type":null,"auto_advance_option":null,"commission_percent":1.0,"fines":null,"late_payment_fine":null,"per_day_interest":null,"bank_slip":{"active":true,"extra_due":"0","reprint_extra_due":"0"},"credit_card":{"active":false,"soft_descriptor":"","installments":false,"installments_pass_interest":false,"max_installments":"0","max_installments_without_interest":"0","two_step_transaction":false}}}
		
		assertTrue( responseInformation.getId() != null);
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testValidateCPFInvalidoSubAccount()
    {

    	//{"account_id":"9945CFA951234A85870B7C98E5283836","name":"Noeli Ghisi","live_api_token":"251df262110fc3d74ea3262c20093bbe","test_api_token":"744939511d57522c618466cc5966b72a","user_token":"06fa4a7767762feb3c0b82ebd3143944"}
    	
		Iugu.init("06fa4a7767762feb3c0b82ebd3143944");
		SubAccountInformationResponse responseInformation = new MarketPlaceService().find("9945CFA951234A85870B7C98E5283836");
		
		String accountId = responseInformation.getId().toString();

		MainSetthingsData mainSetthingsData = new MainSetthingsData("Serviços de Manicure",SubAccountPriceRange.ENTRE_100_500,Boolean.FALSE,Boolean.TRUE);
		PersonData pF = new PersonData("123.123.123-12","NOELI OLIVA XAVIER GHISI","11-3399-5090");
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		BankInformation bankInfo = new BankInformation(Bank.BRADESCO, AccountType.Corrente, "0138-4", "0174016-4");
		
		SubAccountValidationData data = new SubAccountValidationData(mainSetthingsData,bankInfo,address,pF);
		//SubAccountValidationFiles files = new SubAccountValidationFiles(CPF_VOVO_HELIO_BASE64,null,PROVE_ACTIVITY_BASE64);
		//SubAccountValidationFiles files = new SubAccountValidationFiles();
		
		SubAccountValidation subAccountValidation = new SubAccountValidation(data, null, Boolean.FALSE);
		
		SubAccountValidationResponse responseSubAccountValidation = new MarketPlaceService().createSubAccountValidation(accountId, subAccountValidation);
		
		//assertTrue(responseSubAccountValidation.getErrors().get("cpf") != null);
		
		assertFalse( responseSubAccountValidation.getSuccess());
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testValidateCPFValidoSubAccount()
    {

    	//{"account_id":"9945CFA951234A85870B7C98E5283836","name":"Noeli Ghisi","live_api_token":"251df262110fc3d74ea3262c20093bbe","test_api_token":"744939511d57522c618466cc5966b72a","user_token":"06fa4a7767762feb3c0b82ebd3143944"}
    	
		Iugu.init("06fa4a7767762feb3c0b82ebd3143944");
		SubAccountInformationResponse responseInformation = new MarketPlaceService().find("9945CFA951234A85870B7C98E5283836");
		
		String accountId = responseInformation.getId().toString();

		MainSetthingsData mainSetthingsData = new MainSetthingsData("Serviços de Manicure",SubAccountPriceRange.ENTRE_100_500,Boolean.FALSE,Boolean.TRUE);
		PersonData pF = new PersonData("18788209822","NOELI OLIVA XAVIER GHISI","11-3399-5090");
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		BankInformation bankInfo = new BankInformation(Bank.BRADESCO, AccountType.Corrente, "0138-4", "0174016-4");
		
		SubAccountValidationData data = new SubAccountValidationData(mainSetthingsData,bankInfo,address,pF);
		//SubAccountValidationFiles files = new SubAccountValidationFiles(CPF_VOVO_HELIO_BASE64,null,PROVE_ACTIVITY_BASE64);
		//SubAccountValidationFiles files = new SubAccountValidationFiles();
		
		SubAccountValidation subAccountValidation = new SubAccountValidation(data, null, Boolean.FALSE);
		
		SubAccountValidationResponse responseSubAccountValidation = new MarketPlaceService().createSubAccountValidation(accountId, subAccountValidation);
		
		assertTrue(responseSubAccountValidation.getErrors() == null);
		
		assertFalse( responseSubAccountValidation.getSuccess());
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testVerifyIsPendingVerificationForCPF()
    {
    	//{"account_id":"BFE13F587384440BB8A05E63BC74B961","name":"Marcel Ghisi","live_api_token":"56e9b3a30990a8c97260d475bca4f11f","test_api_token":"4485d3d52775dbccccc4b64eb5ccf996","user_token":"e6a1bc0e23f73fa6187c77b889a5d836"}
		
		Iugu.init("06fa4a7767762feb3c0b82ebd3143944");
		SubAccountInformationResponse responseInformation = new MarketPlaceService().find("9945CFA951234A85870B7C98E5283836");
		
		assertTrue( responseInformation.getLastVerificationRequestStatus().contains("pending"));
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testConfigureSoftDescriptionSubAccount()
    {

    	//{"account_id":"9945CFA951234A85870B7C98E5283836","name":"Noeli Ghisi","live_api_token":"251df262110fc3d74ea3262c20093bbe","test_api_token":"744939511d57522c618466cc5966b72a","user_token":"06fa4a7767762feb3c0b82ebd3143944"}
    	
		Iugu.init("06fa4a7767762feb3c0b82ebd3143944");

		MainSettingsConfiguration mainSettingsConfiguration = new MainSettingsConfiguration(null, null, null, null, null, null, null, null);
		BankSlipConfiguration bankSlipConfiguration = new BankSlipConfiguration(true, null, null);
		CreditCardConfiguration creditCardConfiguration = new CreditCardConfiguration(null,"ATTENDME PF", null, null,null,null,null);
		
		SubAccountConfiguration subAccountConfiguration = new SubAccountConfiguration(mainSettingsConfiguration, bankSlipConfiguration, creditCardConfiguration);
		
		SubAccountInformationResponse responseInformationResp = new MarketPlaceService().configureSubAccount(subAccountConfiguration);
		
		System.out.println("TESTANDO CONFIGURE SUB ACCOUNT");

		assertEquals("ATTENDME PF", responseInformationResp.getConfiguration().getCreditCardConfiguration().getSoftDescriptor());
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testUpdateBankDataDocumentBlankPF()
    {

		Iugu.init("06fa4a7767762feb3c0b82ebd3143944");
		
		String b64 = null; 
		try {
			b64 = Base64.encodeFromFile("//Users//marcel//Desktop/CNH.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BankUpdate bankUpdate = new BankUpdate(BankNumber.CAIXA, AccountType.Corrente, "0246","12358",b64,Boolean.TRUE);
		
		MessageResponse responseInformationBank = new MarketPlaceService().updateBankInformation(bankUpdate);
		
		assertTrue(responseInformationBank.getErrors() == null);
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testRequestWithDraw()
    {
		Iugu.init("06fa4a7767762feb3c0b82ebd3143944");
		SubAccountInformationResponse responseInformation = new MarketPlaceService().find("9945CFA951234A85870B7C98E5283836");

		String accountId = responseInformation.getId();

		RequestWithDrawResponse responseWithDraw = new MarketPlaceService().createWithDrawRequest(accountId, new Double(1));

		assertTrue( responseWithDraw.getAmount() != null);
		

    }
    


}
