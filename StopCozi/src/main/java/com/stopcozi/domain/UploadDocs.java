package com.stopcozi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
/**
 * 
 * @author Alexandra
 * 
 * We need to write a POJO class to represent an upload file
 * As we can see, JPA annotations are used to map this model class to the database table, very straightforward.
 */
@Entity
@Table(name = "FILES_UPLOAD")
public class UploadDocs {
	
	@Id
    @GeneratedValue
    @Column(name = "FILE_ID")
    private long id;
	
    private String fileName;
    private byte[] data;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
	@JsonBackReference
    private User user;
 
    
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(name = "FILE_NAME")
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
 
    @Column(name = "FILE_DATA")
    public byte[] getData() {
        return data;
    }
 
    public void setData(byte[] data) {
        this.data = data;
    }
}

