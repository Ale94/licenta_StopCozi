package com.stopcozi.service.documentServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stopcozi.dao.DocumentDao;
import com.stopcozi.domain.Document;
import com.stopcozi.service.DocumentService;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	DocumentDao documentDao;
	
	@Override
	public List<Document> findAll() {
		List<Document> documents = documentDao.findAll();
		documents.removeIf(i -> i.getType().equals("pdf"));
		return documents;
	}

	@Override
	public Document findById(Long id) {
		return documentDao.findOne(id);
	}

}
