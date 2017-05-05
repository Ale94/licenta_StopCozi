package com.stopcozi.service.serServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stopcozi.dao.ServiceDao;
import com.stopcozi.domain.Agency;
import com.stopcozi.service.SerService;

@Service
public class SerServiceImpl implements SerService{

	
	@Autowired
	ServiceDao serviceDao;
	@Override
	public List<com.stopcozi.domain.Service> listAllServices(Agency agency) {
		return agency.getServiceList();
	}

	@Override
	public com.stopcozi.domain.Service findbyName(String serviceName) {
		 Iterable<com.stopcozi.domain.Service> findAll = serviceDao.findAll();
		 for (com.stopcozi.domain.Service service : findAll) {
			if(service.getName().equals(serviceName))
				return service;
		}
		 return null;
	}
	
	
}
