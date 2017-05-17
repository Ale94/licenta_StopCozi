package com.stopcozi.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stopcozi.domain.Agency;
import com.stopcozi.domain.Appointment;
import com.stopcozi.domain.City;
import com.stopcozi.domain.DocumentsSent;
import com.stopcozi.domain.Institutie;
import com.stopcozi.domain.Service;
import com.stopcozi.domain.UploadFile;
import com.stopcozi.domain.User;
import com.stopcozi.service.AgencyService;
import com.stopcozi.service.AppointmentService;
import com.stopcozi.service.CityService;
import com.stopcozi.service.InstituteService;
import com.stopcozi.service.SerService;
import com.stopcozi.service.UploadFileService;
import com.stopcozi.service.UserService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	UserService userService;
	@Autowired
	AppointmentService appointmentService;
	@Autowired
	CityService cityService;
	@Autowired
	AgencyService agencyService;
	@Autowired
	SerService serService;
	@Autowired
	UploadFileService uploadFileSer;
	@Autowired
	InstituteService instituteService;

	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createAppointmentPost(Model model, @ModelAttribute("city") City city, 
			@ModelAttribute("agency") Agency agency, Principal principal){
			
		User user = userService.findByUsername(principal.getName());
		Appointment appointment=new Appointment();
		model.addAttribute("appointment", appointment);
		model.addAttribute("dateString", "");
		model.addAttribute("cities", cityService.findAll());	
		model.addAttribute("institutieList", instituteService.findAll());
		model.addAttribute("myFiles", userService.listAllUploadedFiles(user));
		return "appointment";
	}		

    @RequestMapping(value = "/agencies", method = RequestMethod.GET)
    public @ResponseBody
    List<Agency> findAllAgencies(
    		@RequestParam(value = "cityId", required = true) Long cityId, 
    		@RequestParam(value = "idInstitutie", required = true) String idInstitutie) {
		City city = cityService.findCity(cityId);
		//Institutie institute = instituteService.findInstitute(idInstitutie);
    	return agencyService.listAllAgencies(city,idInstitutie);
    }
    
	@RequestMapping(value="/services", method=RequestMethod.GET)
	public @ResponseBody
	List<Service> findAllServices(
			@RequestParam(value="agencyName", required=true) String agencyName){
		//Agency agency = agencyService.findbyId(agencyId);
		Agency agency = agencyService.findbyName(agencyName);
		return serService.listAllServices(agency);
	}

	/*
	 * Find all available Hours.
	 */
	@RequestMapping(value="/datepickerHours", method=RequestMethod.GET)
	public @ResponseBody List<String> fiindAllAvailableHours(@RequestParam(value="agencyName") String agencyName
			,@RequestParam(value="serviceName") String serviceName, @RequestParam(value="data") String data, Principal principal){
		List<String> allHours=new ArrayList<String>();
		allHours.add("8:00");allHours.add("8:30");allHours.add("9:00");allHours.add("9:30");
		User username = userService.findByUsername(principal.getName());
		List<String> reservedHours=appointmentService.findAllReservedHours(username.getUserId(), agencyName, serviceName, data);
		
		Iterator<String> it = allHours.iterator();
		while(it.hasNext()){
			String next = it.next();
			for (String resHour : reservedHours) {
		    if(next.equalsIgnoreCase(resHour))
		    	it.remove();
			}
		}
		
//		for (String hour : allHours) {
//			for (String resHour : reservedHours) {
//				if(hour.equals(resHour)){
//					allHours.remove(hour);
//				}	
//		    }
//		}
		return allHours;
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String postAppointment(@ModelAttribute("appointment") Appointment appointment,
			@ModelAttribute("dateString") String date,Principal principal,Model model, 
			@RequestParam("id") List<String> ids) throws ParseException{
		
		List<DocumentsSent> docsSent=new ArrayList<DocumentsSent>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1;
		try {
			date1 = format.parse(date);
			appointment.setDate(date1);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		User user=userService.findByUsername(principal.getName());
		appointment.setUser(user);
		String cityId = appointment.getLocation();
		City findCity = cityService.findCity(Long.parseLong(cityId));
		appointment.setLocation(findCity.getName());

		for (String string : ids) {
			if(string!=null && string!=""){
				UploadFile uploadFile = uploadFileSer.findById(Long.parseLong(string));
				DocumentsSent docSentBuilder=new DocumentsSent();
				docSentBuilder.setUploadFile(uploadFile);
				docSentBuilder.setAppointment(appointment);
				docsSent.add(docSentBuilder);
				

			}
		}
		appointment.setDocumentsSent(docsSent);
		appointmentService.createAppointment(appointment);
		
		return "redirect:/userFront";
	}
	
	@RequestMapping("/myapps")
	public String myApps(Principal principal, Model model){
		
	User user = userService.findByUsername(principal.getName());
		model.addAttribute("appointments", userService.listAllAppointments(user));
		return "myapps";
	}
	



}
