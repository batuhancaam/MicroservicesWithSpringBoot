package com.microservice.three.dao;

import org.springframework.data.repository.CrudRepository;
import com.microservice.three.domain.NameValue;

/**
 * 
 * @author Batuhan Çam
 *
 */
public interface NameValueDao extends CrudRepository<NameValue, Long> {

}
