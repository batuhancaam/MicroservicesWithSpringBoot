package com.microservice.three.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.three.component.queue.ServiceThreeRabbitMQBean;
import com.microservice.three.model.NameValueTO;

/**
 * 
 * @author Batuhan Çam
 *
 */
@Service("serviceThreeRabbitMessageProducer")
public class ServiceThreeRabbitMessageProducer {

	private Logger logger = LoggerFactory.getLogger(ServiceThreeRabbitMessageProducer.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMessageToQueue(final NameValueTO message) {

		try {
			logger.info("Sending message (" + message + ") to RabbitMQ's exchange ("
					+ ServiceThreeRabbitMQBean.exchangeName + ")");
			this.rabbitTemplate.convertAndSend(ServiceThreeRabbitMQBean.exchangeName,
					ServiceThreeRabbitMQBean.routingKeyName, new ObjectMapper().writeValueAsString(message));
		} catch (MessagingException | JsonProcessingException e) {

		}
	}
}
