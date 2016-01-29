package com.iugu.model;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Facets {

	private FacetsStatus status;
	
	private FacetsStatus suspended;
	
	private FacetsStatus active;
	
	private FacetsStatus due;

	public FacetsStatus getStatus() {
		return status;
	}

	public void setStatus(FacetsStatus status) {
		this.status = status;
	}

	public FacetsStatus getSuspended() {
		return suspended;
	}

	public void setSuspended(FacetsStatus suspended) {
		this.suspended = suspended;
	}

	public FacetsStatus getActive() {
		return active;
	}

	public void setActive(FacetsStatus active) {
		this.active = active;
	}

	public FacetsStatus getDue() {
		return due;
	}

	public void setDue(FacetsStatus due) {
		this.due = due;
	}
	
	
}
