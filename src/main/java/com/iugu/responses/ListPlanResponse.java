package com.iugu.responses;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListPlanResponse extends MessageResponse implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8277349644711624451L;

	private Integer totalItems;
	
	private List<PlanResponse> items;


	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public List<PlanResponse> getItems() {
		return items;
	}

	public void setItems(List<PlanResponse> items) {
		this.items = items;
	}
	
	
}