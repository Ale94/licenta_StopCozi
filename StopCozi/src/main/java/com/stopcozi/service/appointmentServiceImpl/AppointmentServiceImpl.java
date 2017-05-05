package com.stopcozi.service.appointmentServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stopcozi.dao.AppointmentDaoRepository;
import com.stopcozi.domain.Appointment;
import com.stopcozi.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentDaoRepository appointmentDao;
	
	@Override
	public Appointment createAppointment(Appointment appointment) {
		return appointmentDao.save(appointment);
	}

	@Override
	public List<Appointment> findAll() {
		return appointmentDao.findAll();
	}

	@Override
	public Appointment findAppointment(Long id) {
		return appointmentDao.findOne(id);
	}

	@Override
	public void confirmAppointment(Long id) {
		Appointment appointment = findAppointment(id);
		appointment.setConfirmed(true);
		appointmentDao.save(appointment);
		
	}

	@Override
	public List<String> findAllReservedHours(Long userId, String agencyName, String serviceName, String data) {
		List<Appointment> allApps = findAll();
		List<String> reservedHours=new ArrayList<>();
		for (Appointment appointment : allApps) {
			if(appointment.getDate().toString().substring(0,10).equals(data)){
				if(appointment.getAgency().equals(agencyName) && 
				    appointment.getService().equals(serviceName)) {
						reservedHours.add(appointment.getHour());
					}
				}
			if(appointment.getUser().getUserId().equals(userId)
			    && appointment.getDate().toString().equals(data)){
				if(!reservedHours.contains(appointment.getHour())){
					reservedHours.add(appointment.getHour());
				}				
			}		
		}
		return reservedHours;
	}

}
