package com.stopcozi.instituteServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stopcozi.dao.InstituteDao;
import com.stopcozi.domain.Institutie;
import com.stopcozi.service.InstituteService;

@Service
public class InstituteServiceImpl implements InstituteService{

	
	@Autowired
	InstituteDao instituteDao;
	
	@Override
	public List<Institutie> findAll() {
		return instituteDao.findAll();
	}

	@Override
	public Institutie findInstitute(Long id) {
		return instituteDao.findOne(id);
	}

}
