package com.stopcozi.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
public class City implements Serializable {

	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Column(name = "cityId", nullable = false, updatable = false)
	private long id;
	private String name;
	private long noPeople;
	private String country;
	
	@OneToMany
    @JsonIgnore
    @JsonManagedReference
	private List<Agency> agencyList;

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

	public long getNoPeople() {
		return noPeople;
	}

	public void setNoPeople(long noPeople) {
		this.noPeople = noPeople;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Agency> getAgencyList() {
		return agencyList;
	}

	public void setAgencyList(List<Agency> agencyList) {
		this.agencyList = agencyList;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", noPeople=" + noPeople + ", country=" + country + ", agencyList="
				+ agencyList + "]";
	}
	
	
}
