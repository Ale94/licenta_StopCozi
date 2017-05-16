package com.stopcozi.sendEmail;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmail  {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void setMailSenderJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
    
    public void sendMail(String to,String body) {
    	
    	System.out.println("Sending email...");
    	
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("alexandra.petcov@gmail.com");
        message.setSubject("Confirmare programare");
        message.setText(body);
        javaMailSender.send(message);
        
        System.out.println("Email Sent!");
        }

}