package com.iugu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

//Classe criada para resolver problema ao mapear itens na duplicação da fatura se mapeais o item da internal server error
@JsonIgnoreProperties(ignoreUnknown = true)
public class DuplicateItemsInvoiceRequest extends DuplicateInvoiceRequest implements Serializable {

	private static final long serialVersionUID = 1719931730355279382L;
	
	public DuplicateItemsInvoiceRequest(Date newDueDate,List<Item> newItems,Boolean ignoreDueEmail,Boolean ignoreCanceledMail) {
		super(newDueDate,ignoreDueEmail,ignoreCanceledMail);
		this.items = newItems;
	}


	/**
	 * Itens da Fatura
	 */
	private List<Item> items = new ArrayList<>();

	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}




}