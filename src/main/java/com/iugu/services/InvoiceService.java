package com.iugu.services;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iugu.Iugu;
import com.iugu.model.DuplicateInvoiceRequest;
import com.iugu.model.Invoice;
import com.iugu.model.ListInvoiceCriteria;
import com.iugu.responses.InvoiceResponse;
import com.iugu.responses.ListInvoiceResponse;
import com.iugu.responses.PaymentMethodResponse;
import com.iugu.responses.PlanResponse;

public class InvoiceService extends BaseService{

	private final String CREATE_URL = Iugu.url("/invoices");
	private final String LIST_URL = Iugu.url("/invoices");
	private final String FIND_URL = Iugu.url("/invoices/%s");
	private final String CHANGE_URL = Iugu.url("/invoices/%s");
	private final String CAPTURE_URL = Iugu.url("/invoices/%s/capture");
	private final String DUPLICATE_URL = Iugu.url("/invoices/%s/duplicate");
	private final String REMOVE_URL = Iugu.url("/invoices/%s");
	private final String CANCEL_URL = Iugu.url("/invoices/%s/cancel");
	private final String REFUND_URL = Iugu.url("/invoices/%s/refund");

	public InvoiceResponse create(Invoice invoice) {
		Response response = Iugu.getClient().target(CREATE_URL).request()
				.post(Entity.entity(invoice, MediaType.APPLICATION_JSON));

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(response, InvoiceResponse.class);
		
		return paymentResponse;
	}

	public InvoiceResponse find(String id) {
		Response response = Iugu.getClient().target(String.format(FIND_URL, id)).request().get();

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(response, InvoiceResponse.class);
		
		return paymentResponse;
	}

	public InvoiceResponse change(Invoice invoice) {

		Response response = Iugu.getClient().target(String.format(CHANGE_URL, invoice.getId())).request()
				.put(Entity.entity(invoice, MediaType.APPLICATION_JSON));

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(response, InvoiceResponse.class);
		
		return paymentResponse;
	}
	
	public InvoiceResponse capture(String invoiceId) {

		Response response = Iugu.getClient().target(String.format(CAPTURE_URL, invoiceId)).request()
				.post(null);

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(response, InvoiceResponse.class);
		
		return paymentResponse;
	}
	
	public InvoiceResponse duplicate(String id, DuplicateInvoiceRequest duplicateRequest) {
		
		Response response = Iugu.getClient().target(String.format(DUPLICATE_URL, id)).request()
				.post(Entity.entity(duplicateRequest, MediaType.APPLICATION_JSON));

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(response, InvoiceResponse.class);
		
		return paymentResponse;
	}
	

	public InvoiceResponse remove(String id) {
		Response response = Iugu.getClient().target(String.format(REMOVE_URL, id)).request().delete();

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(response, InvoiceResponse.class);
		
		return paymentResponse;
	}

	public InvoiceResponse cancel(String id) {
		Response response = Iugu.getClient().target(String.format(CANCEL_URL, id)).request().put(null);

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(response, InvoiceResponse.class);
		
		return paymentResponse;
	}

	public InvoiceResponse refund(String id) {
		Response response = Iugu.getClient().target(String.format(REFUND_URL, id)).request().post(null);

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(response, InvoiceResponse.class);
		
		return paymentResponse;
	}

	public List<InvoiceResponse> list(ListInvoiceCriteria criteria) {
		Response response = Iugu.getClient()
				.target(LIST_URL)
				.request()
				.get();
		
		if(response.getStatus() == 200 || (response.getStatus() >= 400 && response.getStatus() < 500)) {
			
			final String responseEntity = response.readEntity(String.class);

			System.out.println(responseEntity);

			Gson gson = new Gson();

			Type listType = new TypeToken<ArrayList<InvoiceResponse>>() {}.getType();

            List<InvoiceResponse> responseList = gson.fromJson(responseEntity, listType);
			
			return responseList;
		}

		return null;
	}
	
	public ListInvoiceResponse listWithParams(ListInvoiceCriteria criteria) {
		
		SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
		Form form = new Form();

		form.param("due_date", sm.format(criteria.getDueDate()));

		Response response = Iugu.getClient().target(LIST_URL).request()
				.buildGet().property("dueDate", sm.format(criteria.getDueDate()))
				.invoke();
		
		ListInvoiceResponse paymentResponse = (ListInvoiceResponse) readResponse(response, ListInvoiceResponse.class);
		
		return paymentResponse;
	}
	

}