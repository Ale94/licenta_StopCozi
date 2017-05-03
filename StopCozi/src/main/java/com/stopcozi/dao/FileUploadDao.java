package com.stopcozi.dao;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stopcozi.domain.UploadDocs;
/**
 * 
 * @author Alexandra
 * We need to implement DAO classes to save the upload files to database.
 */
@RepositoryRestResource
public interface FileUploadDao {
	
	void save(UploadDocs uploadFile);
	
}
