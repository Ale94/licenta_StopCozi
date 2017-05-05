package com.stopcozi.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
public class DocumentsSent {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appointment_id")
	//@JsonIgnore
	@JsonBackReference
	public Appointment appointment;
	
	@ManyToOne(targetEntity = UploadFile.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "uploadFile_id")
	@JsonBackReference
	public UploadFile uploadFile;
	
	public DocumentsSent(){
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public UploadFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(UploadFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
}
