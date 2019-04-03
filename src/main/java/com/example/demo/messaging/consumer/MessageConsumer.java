package com.example.demo.messaging.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.demo.messaging.data.RequestVO;
import com.example.demo.messaging.service.MathService;

@Component
public class MessageConsumer {
	
	@Autowired
	MathService mathService;

	@JmsListener(destination = "objectMessageQueue")
	public void consumeMessgae(RequestVO requestVO) {
		System.out.println("Message Received : "+requestVO);
		mathService.doMathOperation(requestVO);
	}
}
