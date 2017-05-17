package com.stopcozi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stopcozi.domain.Institutie;

@Service
public interface InstituteService {

	List<Institutie> findAll();
	Institutie findInstitute(Long id);
	
}
