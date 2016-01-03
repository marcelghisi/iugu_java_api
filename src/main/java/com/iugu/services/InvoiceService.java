package com.iugu.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.iugu.Iugu;
import com.iugu.model.Invoice;
import com.iugu.responses.InvoiceResponse;

public class InvoiceService {

	private final String CREATE_URL = Iugu.url("/invoices");
	private final String FIND_URL = Iugu.url("/invoices/%s");
	private final String DUPLICATE_URL = Iugu.url("/invoices/%s/duplicate");
	private final String REMOVE_URL = Iugu.url("/invoices/%s");
	private final String CANCEL_URL = Iugu.url("/invoices/%s/cancel");
	private final String REFUND_URL = Iugu.url("/invoices/%s/refund");

	public InvoiceResponse create(Invoice invoice) {
		Response response = Iugu.getClient().target(CREATE_URL).request()
				.post(Entity.entity(invoice, MediaType.APPLICATION_JSON));

		if (response.getStatus() == 200) {
			return response.readEntity(InvoiceResponse.class);
		}

		response.close();
		return null; // FIXME Tratar retornos de erro
	}

	public InvoiceResponse find(String id) {
		Response response = Iugu.getClient().target(String.format(FIND_URL, id)).request().get();

		if (response.getStatus() == 200) {
			return response.readEntity(InvoiceResponse.class);
		}

		response.close();
		return null; // FIXME Tratar retornos de erro
	}

	// FIXME Tratar ignore_canceled_email e Items
	public InvoiceResponse duplicate(String id, Date date) {
		SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
		Form form = new Form();

		form.param("due_date", sm.format(date));

		Response response = Iugu.getClient().target(String.format(DUPLICATE_URL, id)).request()
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

		if (response.getStatus() == 200) {
			return response.readEntity(InvoiceResponse.class);
		}

		response.close();
		return null; // FIXME Tratar retornos de erro
	}

	// TODO Capturar fatura

	public InvoiceResponse remove(String id) {
		Response response = Iugu.getClient().target(String.format(REMOVE_URL, id)).request().delete();

		if (response.getStatus() == 200) {
			return response.readEntity(InvoiceResponse.class);
		}

		response.close();
		return null; // FIXME Tratar retornos de erro
	}

	public InvoiceResponse cancel(String id) {
		Response response = Iugu.getClient().target(String.format(CANCEL_URL, id)).request().put(null);

		if (response.getStatus() == 200) {
			return response.readEntity(InvoiceResponse.class);
		}

		response.close();
		return null; // FIXME Tratar retornos de erro
	}

	public InvoiceResponse refund(String id) {
		Response response = Iugu.getClient().target(String.format(REFUND_URL, id)).request().post(null);

		if (response.getStatus() == 200) {
			return response.readEntity(InvoiceResponse.class);
		}
		response.close();

		return null; // FIXME Tratar retornos de erro
	}

	// TODO Listar as faturas
}