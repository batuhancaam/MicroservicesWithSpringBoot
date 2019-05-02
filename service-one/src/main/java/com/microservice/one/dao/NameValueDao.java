package com.microservice.one.dao;

import org.springframework.data.repository.CrudRepository;
import com.microservice.one.domain.NameValue;

/**
 * 
 * @author Batuhan Çam
 *
 */
public interface NameValueDao extends CrudRepository<NameValue, Long> {

}
