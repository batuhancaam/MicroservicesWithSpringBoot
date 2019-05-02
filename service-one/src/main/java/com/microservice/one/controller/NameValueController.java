package com.microservice.one.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.one.ServiceOneApplication;
import com.microservice.one.model.AllNameValueTO;
import com.microservice.one.model.NameValueTO;
import com.microservice.one.service.NameValueService;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Batuhan Çam
 *
 */

@RestController
public class NameValueController {

	@Value("${spring.application.name}")
	private String applicationName;

	@Autowired
	private NameValueService nameValueService;

	private Logger logger = Logger.getLogger(ServiceOneApplication.class);

	@GetMapping(value = "/")
	@ApiOperation(value = "Get name and value", notes = "Get service name and its corresponding values for all the services", response = NameValueTO.class)
	public AllNameValueTO getAllNameValue() {
		logger.info("Inside " + applicationName + " controller's getAllNameValue() method");
		return nameValueService.getAllNameValues(applicationName);
	}

}
