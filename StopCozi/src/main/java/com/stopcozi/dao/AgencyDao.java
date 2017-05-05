package com.stopcozi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stopcozi.domain.Agency;


@RepositoryRestResource
public interface AgencyDao extends CrudRepository<Agency, Long>{

}
