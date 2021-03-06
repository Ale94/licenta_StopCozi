package com.stopcozi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stopcozi.domain.UploadFile;


/**
 * 
 * @author Alexandra
 * We need to implement DAO classes to save the upload files to database.
 */
@RepositoryRestResource
public interface FileUploadDao extends CrudRepository<UploadFile, Long>{
	
	
}

