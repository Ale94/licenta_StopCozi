package com.stopcozi.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stopcozi.domain.Service;

@RepositoryRestResource
public interface ServiceDao extends CrudRepository<Service, Long>{

}
