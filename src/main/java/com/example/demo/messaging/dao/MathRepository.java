package com.example.demo.messaging.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.messaging.data.OperationData;

@Component
public class MathRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int saveOperationData(OperationData operationData) {
		
		return jdbcTemplate.update("insert into OperationData(operator,operand1,operand2,result)"+"values(?,?,?,?)",
				new Object[] {operationData.getOperator(),operationData.getOperand1(),operationData.getOperand2(),operationData.getResult()});
	}
}
