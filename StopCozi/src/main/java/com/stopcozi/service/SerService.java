package com.stopcozi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.stopcozi.domain.Agency;

@Service
public interface SerService {
	
	List<com.stopcozi.domain.Service> listAllServices(Agency agency);
	com.stopcozi.domain.Service findbyName(String serviceName);

}
