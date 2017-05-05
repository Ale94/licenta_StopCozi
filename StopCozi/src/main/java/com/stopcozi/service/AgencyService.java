package com.stopcozi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stopcozi.domain.Agency;
import com.stopcozi.domain.City;

@Service
public interface AgencyService {

	List<Agency> listAllAgencies(City city);
	Agency findbyId(Long id);
	Agency findbyName(String agencyName);
}
