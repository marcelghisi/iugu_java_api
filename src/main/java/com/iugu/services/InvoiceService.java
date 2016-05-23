package com.iugu.services;

import java.text.SimpleDateFormat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.iugu.IuguFactory;
import com.iugu.model.DuplicateInvoiceRequest;
import com.iugu.model.Invoice;
import com.iugu.model.ListInvoiceCriteria;
import com.iugu.responses.InvoiceResponse;
import com.iugu.responses.ListInvoiceResponse;

public class InvoiceService extends BaseService {

	private final String CREATE_URL = IuguFactory.generateEndPointUrl("/invoices");
	private final String LIST_URL = IuguFactory.generateEndPointUrl("/invoices");
	private final String FIND_URL = IuguFactory.generateEndPointUrl("/invoices/%s");
	private final String CHANGE_URL = IuguFactory.generateEndPointUrl("/invoices/%s");
	private final String CAPTURE_URL = IuguFactory.generateEndPointUrl("/invoices/%s/capture");
	private final String DUPLICATE_URL = IuguFactory.generateEndPointUrl("/invoices/%s/duplicate");
	private final String REMOVE_URL = IuguFactory.generateEndPointUrl("/invoices/%s");
	private final String CANCEL_URL = IuguFactory.generateEndPointUrl("/invoices/%s/cancel");
	private final String REFUND_URL = IuguFactory.generateEndPointUrl("/invoices/%s/refund");

	private Client client = null;
	
	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public InvoiceService(Client client) {
		super();
		this.setClient(client);
	}
	
	public InvoiceResponse create(Invoice invoice) {
		Response response = this.client.target(CREATE_URL).request()
				.post(Entity.entity(invoice, MediaType.APPLICATION_JSON));

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(
				response, InvoiceResponse.class);

		return paymentResponse;
	}

	public InvoiceResponse find(String id) {
		Response response = this.client
				.target(String.format(FIND_URL, id)).request().get();

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(
				response, InvoiceResponse.class);

		return paymentResponse;
	}

	public InvoiceResponse change(Invoice invoice) {

		Response response = this.client
				.target(String.format(CHANGE_URL, invoice.getId())).request()
				.put(Entity.entity(invoice, MediaType.APPLICATION_JSON));

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(
				response, InvoiceResponse.class);

		return paymentResponse;
	}

	public InvoiceResponse capture(String invoiceId) {

		Response response = this.client
				.target(String.format(CAPTURE_URL, invoiceId)).request()
				.post(null);

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(
				response, InvoiceResponse.class);

		return paymentResponse;
	}

	public InvoiceResponse duplicate(String invoiceId,
			DuplicateInvoiceRequest duplicateRequest) {

		Response response = this.client
				.target(String.format(DUPLICATE_URL, invoiceId))
				.request()
				.post(Entity.entity(duplicateRequest,
						MediaType.APPLICATION_JSON));

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(
				response, InvoiceResponse.class);

		return paymentResponse;
	}

	public InvoiceResponse remove(String id) {
		Response response = this.client
				.target(String.format(REMOVE_URL, id)).request().delete();

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(
				response, InvoiceResponse.class);

		return paymentResponse;
	}

	public InvoiceResponse cancel(String id) {
		Response response = this.client
				.target(String.format(CANCEL_URL, id)).request().put(null);

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(
				response, InvoiceResponse.class);

		return paymentResponse;
	}

	public InvoiceResponse refund(String id) {
		Response response = this.client
				.target(String.format(REFUND_URL, id)).request().post(null);

		InvoiceResponse paymentResponse = (InvoiceResponse) readResponse(
				response, InvoiceResponse.class);

		return paymentResponse;
	}

	public ListInvoiceResponse list(ListInvoiceCriteria criteria) {

		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");

		WebTarget target = this.client.target(LIST_URL);
		
		if (criteria.getDueDate() != null){
			target = target.queryParam("due_date", sm.format(criteria.getDueDate()));
		}
		if (criteria.getCustomerId() != null){
			target = target.queryParam("customer_id", criteria.getCustomerId());
		}
		if (criteria.getLimit() != null){
			target = target.queryParam("limit", criteria.getLimit());
		}
		if (criteria.getStart() != null){
			target = target.queryParam("start", criteria.getStart());
		}
		if (criteria.getCreatedAtFrom() != null){
			target = target.queryParam("created_at_from", sm.format(criteria.getCreatedAtFrom()));
		}
		if (criteria.getCreatedAtTo() != null){
			target = target.queryParam("created_at_to", sm.format(criteria.getCreatedAtTo()));
		}
		if (criteria.getUpdatedSince() != null){
			target = target.queryParam("updated_since", sm.format(criteria.getUpdatedSince()));
		}
		if (criteria.getQuery() != null){
			target = target.queryParam("query", criteria.getQuery());
		}
		if (criteria.getSortBy() != null){
			target = target.queryParam("sortBy", criteria.getSortBy());
		}
		
		Response response = target.request().get();

		ListInvoiceResponse paymentResponse = (ListInvoiceResponse) readResponse(
				response, ListInvoiceResponse.class);

		return paymentResponse;
	}

}