package com.stopcozi.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Institutie {
	
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Column(name = "idInstitutie", nullable = false, updatable = false)
	private Long idInstitutie;
	
	private String numeInstitutie;
	private String domeniu;
	
	@OneToMany(mappedBy = "institutie", fetch = FetchType.EAGER)
    @JsonIgnore
    @JsonManagedReference
	private List<Agency> agencyList;

	public Long getIdIntitutie() {
		return idInstitutie;
	}

	public void setIdIntitutie(Long idInstitutie) {
		this.idInstitutie = idInstitutie;
	}

	public String getNumeInstitutie() {
		return numeInstitutie;
	}

	public void setNumeInstitutie(String numeInstitutie) {
		this.numeInstitutie = numeInstitutie;
	}

	public String getDomeniu() {
		return domeniu;
	}

	public void setDomeniu(String domeniu) {
		this.domeniu = domeniu;
	}

	public List<Agency> getAgencyList() {
		return agencyList;
	}

	public void setAgencyList(List<Agency> agencyList) {
		this.agencyList = agencyList;
	}
	
	
	

}
