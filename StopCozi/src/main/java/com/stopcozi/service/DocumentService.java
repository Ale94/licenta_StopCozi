package com.stopcozi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stopcozi.domain.Document;

@Service
public interface DocumentService {

	List<Document> findAll();
	Document findById(Long id);
}
