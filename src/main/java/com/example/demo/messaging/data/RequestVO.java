package com.example.demo.messaging.data;


public class RequestVO {
	
	private String operator;
	private double operand1;
	private double operand2;
	
	
	
	public RequestVO() {
		super();
	}
	public RequestVO(String operator, double operand1, double operand2) {
		super();
		this.operator = operator;
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public double getOperand1() {
		return operand1;
	}
	public void setOperand1(double operand1) {
		this.operand1 = operand1;
	}
	public double getOperand2() {
		return operand2;
	}
	public void setOperand2(double operand2) {
		this.operand2 = operand2;
	}
}
