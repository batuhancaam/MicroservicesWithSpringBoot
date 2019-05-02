package com.microservice.one.service;

import com.microservice.one.model.AllNameValueTO;
import com.microservice.one.model.NameValueTO;

/**
 * 
 * @author Batuhan Çam
 *
 */
public interface NameValueService {

	NameValueTO updateNameValue(NameValueTO nameValueTO);
	
	NameValueTO updateNameValue(NameValueTO nameValueTO, boolean fromRabbit);

	AllNameValueTO getAllNameValues(String name);

	NameValueTO generateUUID();

	NameValueTO generateUUID(String applicationName);

}
