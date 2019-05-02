package com.microservice.two.service.impl;

import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.microservice.two.service.impl.NameValueServiceImpl;
import com.microservice.two.dao.NameValueDao;
import com.microservice.two.domain.NameValue;
import com.microservice.two.model.AllNameValueTO;
import com.microservice.two.model.NameValueTO;
import com.microservice.two.service.NameValueService;

/**
 * 
 * @author Batuhan Çam
 *
 */
@Service(value = "nameValueService")
public class NameValueServiceImpl implements NameValueService {
	
	private Logger logger = Logger.getLogger(NameValueServiceImpl.class);
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	private NameValueDao nameValueDao;

	@Autowired
	private ServiceTwoRabbitMessageProducer serviceTwoRabbitMessageProducer;

	@Override
	public NameValueTO updateNameValue(NameValueTO nameValueTO) {
		return updateNameValue(nameValueTO, false);
	}

	@Override
	public NameValueTO updateNameValue(NameValueTO nameValueTO, boolean fromRabbit) {
		logger.info("Saving: " + nameValueTO);
		NameValueTO savedData = dozerBeanMapper
				.map(nameValueDao.save(dozerBeanMapper.map(nameValueTO, NameValue.class)), NameValueTO.class);
		if (!fromRabbit) {
			serviceTwoRabbitMessageProducer.sendMessageToQueue(savedData);
		}
		return savedData;
	}

	@Override
	public AllNameValueTO getAllNameValues(String name) {
		Iterable<NameValue> nameValues = nameValueDao.findAll();
		AllNameValueTO allNameValueTO = new AllNameValueTO();
		for (NameValue nameValue : nameValues) {
			if (nameValue.getName().equals(name)) {
				allNameValueTO.setOriginalName(nameValue.getName());
				allNameValueTO.setOriginalValue(nameValue.getValue());
			} else {
				allNameValueTO.getRemainingNameValuePair().put(nameValue.getName(), nameValue.getValue());
			}
		}


		allNameValueTO.setOriginalName("Stok-Service");
		allNameValueTO.setOriginalValue(allNameValueTO.getRemainingNameValuePair().get("Stok"));
		allNameValueTO.getRemainingNameValuePair().remove("Stok");

		return allNameValueTO;
	}

	private Random random=new Random();
	
	@Override
	@Scheduled (fixedDelay= 5000)
	public NameValueTO generateUUID() {
		return generateUUID(applicationName);
	}

	@Override
	public NameValueTO generateUUID(String applicatFionName) {
		NameValueTO nameValueTO = new NameValueTO();
		nameValueTO.setName("Stok");
		Integer randomValue=random.nextInt(100);
		nameValueTO.setValue(randomValue.toString() + " Adet");
		logger.info("Saved Information: " + updateNameValue(nameValueTO));
		return nameValueTO;
	}
}
