package com.example.demo.messaging.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.messaging.data.RequestVO;

@Component
public class MessageProducer {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void produceMessage(RequestVO requestVO) {
		jmsTemplate.convertAndSend("objectMessageQueue", requestVO);
	}
}
