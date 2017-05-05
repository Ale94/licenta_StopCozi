package com.stopcozi.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity 
public class Appointment implements Serializable {
	private String agency;
	private String service;
	private Date date;
	private String location;
	private boolean confirmed;
	private String description;
	private String hour;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;	
	@ManyToOne
    @JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;
	
	
	@OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonManagedReference
	private List<DocumentsSent> documentsSent;
	public Long getId() {	
		return id;
	}
	public void setId(Long appointmentId) {
		this.id = appointmentId;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}	

	public List<DocumentsSent> getDocumentsSent() {
		return documentsSent;
	}
	public void setDocumentsSent(List<DocumentsSent> documentsSent) {
		this.documentsSent = documentsSent;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	 public String getDescription() {
	        return description;
	}

	public void setDescription(String description) {
	        this.description = description;
	}
    
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + id + ", agency=" + agency + ", service=" + service + ", date=" + date + ", city=" + location + "]";
	}
	

}
