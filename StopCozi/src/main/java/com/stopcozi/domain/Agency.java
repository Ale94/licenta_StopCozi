package com.stopcozi.domain;

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
public class Agency {

	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Column(name = "agencyId", nullable = false, updatable = false)
	private long id;
	private String nume;
	private String adresa;
	
	private String nrTel;
	
	@ManyToOne
    @JoinColumn(name = "city_id")
	@JsonBackReference
	private City city;
	
	@ManyToOne
    @JoinColumn(name = "id_institutie")
	@JsonBackReference
	private Institutie institutie;
	
	//provide services
	@OneToMany(mappedBy = "agency", fetch = FetchType.EAGER)
    @JsonIgnore
    @JsonManagedReference
	private List<Service> serviceList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Service> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<Service> serviceList) {
		this.serviceList = serviceList;
	}

	@Override
	public String toString() {
		return "Agency [id=" + id + ", nume=" + nume + ", adresa=" + adresa + ", city=" + city + ", serviceList="
				+ serviceList + "]";
	}

	public Institutie getInstitutie() {
		return institutie;
	}

	public void setInstitutie(Institutie institutie) {
		this.institutie = institutie;
	}

	public String getNrTel() {
		return nrTel;
	}

	public void setNrTel(String nrTel) {
		this.nrTel = nrTel;
	}
	
	
	
	
}
