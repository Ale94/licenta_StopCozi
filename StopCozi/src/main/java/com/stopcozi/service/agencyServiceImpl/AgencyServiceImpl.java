package com.stopcozi.service.agencyServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stopcozi.dao.AgencyDao;
import com.stopcozi.domain.Agency;
import com.stopcozi.domain.City;
import com.stopcozi.service.AgencyService;

@Service
public class AgencyServiceImpl implements AgencyService{

	@Autowired
	AgencyDao agencyDao; 
	
	@Override
	public List<Agency> listAllAgencies(City city) {
		return city.getAgencyList();
	}

	@Override
	public Agency findbyId(Long id) {
		return agencyDao.findOne(id);
	}

	@Override
	public Agency findbyName(String agencyName) {
		Iterable<Agency> findAll = agencyDao.findAll();
		for (Agency agency : findAll) {
			if(agency.getNume().equals(agencyName)){
				return agency;
			}
		}

		return null;
	}
}
