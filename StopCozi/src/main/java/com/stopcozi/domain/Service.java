package com.stopcozi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Service {

	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Column(name = "serviceId", nullable = false, updatable = false)
	private long id;
	private String name;
	
	@ManyToOne
    @JoinColumn(name = "agency_id")
	@JsonBackReference
	private Agency agency;

	private String acteNecesare;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public String getActeNecesare() {
		return acteNecesare;
	}

	public void setActeNecesare(String acteNecesare) {
		this.acteNecesare = acteNecesare;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", agency=" + agency + ", acteNecesare=" + acteNecesare + "]";
	}

	
	
	
}
