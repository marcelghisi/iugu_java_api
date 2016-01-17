package com.iugu.model;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Facets {

	private FacetsStatus status;

	public FacetsStatus getStatus() {
		return status;
	}

	public void setStatus(FacetsStatus status) {
		this.status = status;
	}
	
	
}
