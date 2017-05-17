package com.stopcozi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stopcozi.domain.Institutie;

@RepositoryRestResource
public interface InstituteDao extends CrudRepository<Institutie, Long>{
	
	List<Institutie> findAll();
}
