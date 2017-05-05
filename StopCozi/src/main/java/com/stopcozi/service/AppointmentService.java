package com.stopcozi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stopcozi.domain.Appointment;

@Service
public interface AppointmentService {
	
	Appointment createAppointment (Appointment appointment);
	List<Appointment> findAll();
	Appointment findAppointment(Long id);
	void confirmAppointment(Long id);
	List<String> findAllReservedHours(Long userId,  String agencyName, String serviceName, String data);
}
