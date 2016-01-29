package com.iugu.responses;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.iugu.model.Facets;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListSubscriptionResponse extends MessageResponse implements Serializable {

	private static final long serialVersionUID = -4229186497940178039L;

	private Facets facets;
	
	private Integer totalItems;
	
	private List<SubscriptionResponse> items;

	public Facets getFacets() {
		return facets;
	}

	public void setFacets(Facets facets) {
		this.facets = facets;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public List<SubscriptionResponse> getItems() {
		return items;
	}

	public void setItems(List<SubscriptionResponse> items) {
		this.items = items;
	}
	
	
}