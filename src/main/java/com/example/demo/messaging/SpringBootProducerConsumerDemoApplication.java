package com.example.demo.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.messaging.data.RequestVO;
import com.example.demo.messaging.data.ResponseVO;
import com.example.demo.messaging.producer.MessageProducer;

@SpringBootApplication
@RestController
public class SpringBootProducerConsumerDemoApplication extends SpringBootServletInitializer {
	
	@Autowired
	MessageProducer messageProducer;
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SpringBootProducerConsumerDemoApplication.class);
	    }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProducerConsumerDemoApplication.class, args);
	}
	
	@Bean
    public MessageConverter jacksonJmsMessageConverter()
    {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

	@PostMapping(value="/doOperation")
	public ResponseVO doOperation(@RequestBody RequestVO requestVO) {
		System.out.println("inside doOperation");
		messageProducer.produceMessage(requestVO);
		System.out.println("doOperation complete");
		return new ResponseVO();
	}
	
	 @GetMapping(path="/sampleservice", produces = "application/json")
	    public String getEmployees()
	    {
	        return "{\"result\":\"success\"}";
	    }
	
	/*
	 * @GetMapping("/getByOperation/{operationName}") public ResponseVO
	 * getByOperation(@PathVariable String operationName) {
	 * 
	 * ResponseVO responseObj;
	 * 
	 * return responseObj; }
	 */
}

