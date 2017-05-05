package com.stopcozi.service.fileUploadImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stopcozi.dao.FileUploadDao;
import com.stopcozi.domain.UploadFile;
import com.stopcozi.service.UploadFileService;

@Service
@Transactional
public class FileUploadServiceImpl implements UploadFileService {

	@Autowired
	private SessionFactory sessionFactory;
	   
	@Autowired
	private FileUploadDao fileUploadDao;
	@Override
	@Transactional
	public void save(UploadFile uploadFile) {
	        sessionFactory.getCurrentSession().save(uploadFile);
	    }

	@Override
	public UploadFile findById(Long idFile) {
		return fileUploadDao.findOne(idFile);
	}

	@Override
	public void deleteById(Long idFile) {
		fileUploadDao.delete(idFile);
		
	}
}
