package com.stopcozi.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
 
@Entity
public class UploadFile {
	
	@Id
	@GeneratedValue
	@Column(name = "fileid", nullable = false, updatable = false)
    private long id;
    private String fileName;
    
    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(length=100000)
    private byte[] data;
 
    @ManyToOne
    @JoinColumn(name = "user_id")
	@JsonBackReference
    private User user;
    public void setUser(User user) {
        this.user = user;
    }
   
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
    public byte[] getData() {
        return data;
    }
 
    public void setData(byte[] data) {
        this.data = data;
    }
}
