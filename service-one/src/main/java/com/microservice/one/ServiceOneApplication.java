package com.microservice.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import com.microservice.one.service.NameValueService;

/**
 * 
 * @author Batuhan Çam
 *
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceOneApplication extends SpringBootServletInitializer {

	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(ServiceOneApplication.class, args);
		context.getBean(NameValueService.class)
				.generateUUID(context.getEnvironment().getProperty("spring.application.name"));
	}
}
