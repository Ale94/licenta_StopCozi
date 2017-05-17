package com.stopcozi.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
 
@Entity
public class UploadFile {
	
	/**
	 * @JsonManagedReference is the forward part of reference – the one that gets serialized normally. 
	 * @JsonBackReference is the back part of reference – it will be omitted from serialization.
	 */
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
    
    @OneToMany(mappedBy = "uploadFile", fetch = FetchType.LAZY)
    @JsonManagedReference
	private List<DocumentsSent> documentsSent;
    
    private UploadFileStatus status;  

	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UploadFileStatus getStatus() {
		return status;
	}

	public void setStatus(UploadFileStatus status) {
		this.status = status;
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
