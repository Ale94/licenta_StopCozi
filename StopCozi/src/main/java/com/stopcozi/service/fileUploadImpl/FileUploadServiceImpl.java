//package com.stopcozi.service.fileUploadImpl;
//
//import javax.transaction.Transactional;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.stopcozi.dao.FileUploadDao;
//import com.stopcozi.domain.UploadFile;
//
//public class FileUploadServiceImpl implements FileUploadDao {
//
//	 @Autowired
//	 private SessionFactory sessionFactory;
//	     
//	 public FileUploadServiceImpl() {
//	    }
//	 
//	 public FileUploadServiceImpl(SessionFactory sessionFactory) {
//	        this.sessionFactory = sessionFactory;
//	    }
//	 
//	@Override
//	@Transactional
//	public void save(UploadFile uploadFile) {
//	        sessionFactory.getCurrentSession().save(uploadFile);
//	    }
//}
