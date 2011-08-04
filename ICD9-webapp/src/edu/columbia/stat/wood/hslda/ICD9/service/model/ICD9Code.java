package edu.columbia.stat.wood.hslda.ICD9.service.model;

public class ICD9Code {
	private String code;
	private String text;
	
	public ICD9Code(String code, String text) {
		super();
		this.code = code;
		this.text = text;
	}
	
	public ICD9Code() {
		super();
		this.code = null;
		this.text = null;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
