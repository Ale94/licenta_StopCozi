package com.stopcozi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stopcozi.domain.Document;

@RepositoryRestResource
public interface DocumentDao extends CrudRepository<Document, Long>{
	
	List<Document> findAll();

}
