package com.example.demo.messaging.service;

import org.springframework.stereotype.Component;

import com.example.demo.messaging.data.RequestVO;
import com.example.demo.messaging.data.ResponseVO;

@Component
public interface MathService {
	
	public ResponseVO doMathOperation(RequestVO requestVO);
}
