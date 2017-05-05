package com.stopcozi.service.cityServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stopcozi.dao.CityDao;
import com.stopcozi.domain.City;
import com.stopcozi.service.CityService;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	CityDao cityDao;

	@Override
	public List<City> findAll() {
		return cityDao.findAll();
	}

	@Override
	public City findCity(Long id) {
		return cityDao.findOne(id);
	}

}
