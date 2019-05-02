package com.microservice.two.service;

import com.microservice.two.model.AllNameValueTO;
import com.microservice.two.model.NameValueTO;

/**
 * 
 * @author Batuhan Çam
 *
 */
public interface NameValueService {

	NameValueTO updateNameValue(NameValueTO nameValueTO);

	AllNameValueTO getAllNameValues(String name);

	NameValueTO updateNameValue(NameValueTO nameValueTO, boolean fromRabbit);

	NameValueTO generateUUID();

	NameValueTO generateUUID(String applicationName);

}
