package com.stopcozi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stopcozi.domain.City;

@RepositoryRestResource
public interface CityDao extends CrudRepository<City, Long>{
	
	List<City> findAll();

}
