package com.example.demo.messaging.data;

public class ResponseVO {
	
	private int resultCode=0;
	private String resultMessage="Request has been accepted";
	
	public ResponseVO() {
		super();
	}

	public ResponseVO(int resultCode, String resultMessage) {
		super();
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}
	
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
}
