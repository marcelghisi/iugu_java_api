package com.iugu.model;

import org.jboss.resteasy.util.Base64;


public class SubAccountValidationFiles {

	public SubAccountValidationFiles(byte[] rgDocumentForBase64Encode,byte[] cpfDocumentForBase64Encode,byte[] proveActivityDocumentForBase64Encode) {
		this.id = Base64.encodeBytes(rgDocumentForBase64Encode);
		this.cpf = Base64.encodeBytes(cpfDocumentForBase64Encode);
		this.activity = Base64.encodeBytes(proveActivityDocumentForBase64Encode);
	}
	
	public SubAccountValidationFiles(String rgDocumentBase64Encode,String cpfDocumentInBase64,String proveActivityDocumentInBase64) {
		this.id = rgDocumentBase64Encode;
		this.cpf = cpfDocumentInBase64;
		this.activity = proveActivityDocumentInBase64;
	}
    //Id Identidade com cpf
	private String id;
	
	//Cpf caso nao tenha na identidade
	private String cpf;
	
	//Documento que comprove a atividade da empresa
	private String activity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}




	
}
