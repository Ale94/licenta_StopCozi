package com.stopcozi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stopcozi.domain.Appointment;
import com.stopcozi.sendEmail.SendEmail;
import com.stopcozi.service.AppointmentService;

@EnableAutoConfiguration
@RestController
@RequestMapping("/api/appointment")
@PreAuthorize("hasRole('ADMIN')")
public class AppointmentResource {

    @Autowired
    private AppointmentService appointmentService;
    
    @Autowired
    private SendEmail serviceSendEmail;

    @RequestMapping("/all")
    public List<Appointment> findAppointmentList() {
        List<Appointment> appointmentList = appointmentService.findAll();

        return appointmentList;
    }

    @RequestMapping("/{id}/confirm")
    public void confirmAppointment(@PathVariable("id") Long id) {
        appointmentService.confirmAppointment(id);
        Appointment appointment = appointmentService.findAppointment(id);
        String email = appointment.getUser().getEmail();
        serviceSendEmail.sendMail(email, "Programarea dumneavoastra la agentia "
        +appointment.getAgency()+" si serviciul "+appointment.getService()+" "
        		+ "realizata in data "+appointment.getDate().toString().substring(0,10) + " la ora "+appointment.getHour()+" a fost confirmata. O zi buna!");
    }
}
