package com.example.demo.messaging.data;

public class OperationData {
	
	private String operator;
	private double operand1;
	private double operand2;
	private String result;
	
	public OperationData(String operator, double operand1, double operand2, String result) {
		super();
		this.operator = operator;
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.result = result;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
