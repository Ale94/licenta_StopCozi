package com.stopcozi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stopcozi.domain.City;

@Service
public interface CityService {
	
	List<City> findAll();
	City findCity(Long id);
}
