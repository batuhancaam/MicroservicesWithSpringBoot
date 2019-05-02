package com.microservice.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Batuhan Çam
 *
 */

@RestController
public class ApiGatewayMainController {

	private Logger logger = Logger.getLogger(ApiGatewayMainController.class);
	
	@GetMapping (value = "/")
	public String home() {
		logger.info("Called API Gateway's root API");
		return "Message from API-Gateway!!";
	}
}
