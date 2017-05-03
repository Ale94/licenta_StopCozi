package com.stopcozi.service.fileUploadImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.stopcozi.dao.FileUploadDao;
import com.stopcozi.domain.UploadDocs;

public class FileUploadServiceImpl implements FileUploadDao {

	 @Autowired
	 private SessionFactory sessionFactory;
	   
	@Override
	@Transactional
	public void save(UploadDocs uploadFile) {
	        sessionFactory.getCurrentSession().save(uploadFile);
	    }
}
