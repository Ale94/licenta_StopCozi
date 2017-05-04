package com.stopcozi.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stopcozi.domain.Appointment;
import com.stopcozi.domain.User;
import com.stopcozi.service.AppointmentService;
import com.stopcozi.service.UserService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AppointmentService appointmentService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createAppointmentPost(Model model){
	
		Appointment appointment=new Appointment();
		model.addAttribute("appointment", appointment);
		model.addAttribute("dateString", "");
		return "appointment";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String postAppointment(@ModelAttribute("appointment") Appointment appointment,
			@ModelAttribute("dateString") String date,Principal principal,Model model) throws ParseException{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date date1;
		try {
			date1 = format.parse(date);
			appointment.setDate(date1);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		User user=userService.findByUsername(principal.getName());
		appointment.setUser(user);
		
		appointmentService.createAppointment(appointment);
		
		return "redirect:/userFront";
	}
	
	@RequestMapping("/myapps")
	public String myApps(Principal principal, Model model){
		
	User user = userService.findByUsername(principal.getName());
//		List<Appointment> appointments = user.getAppointments();
//		for (Appointment appointment : appointments) {
//			String location = appointment.getLocation();
//			Date date = appointment.getDate();
//		}
		//model.addAttribute("user", user);
		model.addAttribute("appointments", userService.listAllAppointments(user));
		return "myapps";
	}
	



}
