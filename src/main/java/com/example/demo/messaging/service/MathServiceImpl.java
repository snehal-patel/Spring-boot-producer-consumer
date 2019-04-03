package com.example.demo.messaging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.messaging.dao.MathRepository;
import com.example.demo.messaging.data.OperationData;
import com.example.demo.messaging.data.RequestVO;
import com.example.demo.messaging.data.ResponseVO;

@Component
public class MathServiceImpl implements MathService {
	
	@Autowired
	MathRepository mathRepo;

	@Override
	public ResponseVO doMathOperation(RequestVO requestVO) {
		
		ResponseVO responseObj=new ResponseVO();
		String result="";
		String operationName=requestVO!=null ? requestVO.getOperator():"NoOperator";
		double operand1=requestVO.getOperand1();
		double operand2=requestVO.getOperand2();
		
		if(operationName!="NoOperator" && operationName.equalsIgnoreCase("Addition")) {
			result=operand1 + operand2+"";
		}else if(operationName!="NoOperator" && operationName.equalsIgnoreCase("Subtraction")) {
			result=operand1 - operand2+"";
		}else if(operationName!="NoOperator" && operationName.equalsIgnoreCase("Multiplication")) {
			result=operand1 * operand2+"";
		}else if(operationName!="NoOperator" && operationName.equalsIgnoreCase("Division")) {
			if(operand2!=0)
				result=operand1 / operand2+"";
			else
				result="cannot perform division as operand2 is 0";
		}else {
			responseObj.setResultMessage("Invalid Operation");
			return responseObj;
		}
		
		OperationData operationData=new OperationData(operationName, operand1, operand2, result);
		int count=mathRepo.saveOperationData(operationData);
		
		if(count>0) {
		responseObj.setResultCode(0);
		responseObj.setResultMessage(result);
		}
		
		return responseObj;
	}

}
