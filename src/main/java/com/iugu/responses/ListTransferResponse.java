package com.iugu.responses;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListTransferResponse extends MessageResponse implements Serializable {


	private static final long serialVersionUID = -1033861344296764092L;

	private List<TransferResponse> sent;
	
	private List<TransferResponse> received;

	public List<TransferResponse> getSent() {
		return sent;
	}

	public void setSent(List<TransferResponse> sent) {
		this.sent = sent;
	}

	public List<TransferResponse> getReceived() {
		return received;
	}

	public void setReceived(List<TransferResponse> received) {
		this.received = received;
	}


	
	
}