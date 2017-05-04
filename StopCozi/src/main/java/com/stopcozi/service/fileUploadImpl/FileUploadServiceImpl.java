package com.stopcozi.service.fileUploadImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stopcozi.domain.UploadFile;
import com.stopcozi.service.UploadFileService;

@Service
@Transactional
public class FileUploadServiceImpl implements UploadFileService {

	@Autowired
	private SessionFactory sessionFactory;
	   
	@Override
	@Transactional
	public void save(UploadFile uploadFile) {
	        sessionFactory.getCurrentSession().save(uploadFile);
	    }
}
