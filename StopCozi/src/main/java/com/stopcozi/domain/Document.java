package com.stopcozi.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity	
public class Document {

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false, updatable = false)
    private long id;
	
	@Column(name="name", length=100, nullable=false)
    private String name;
    
	@Column(name="type", length=100, nullable=false)
    private String type;
	
    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(length=100000)
    private byte[] data;
	
    @Column(name="description", length=255)
    private String description;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
     
}
