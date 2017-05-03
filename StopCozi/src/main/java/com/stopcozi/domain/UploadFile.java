//package com.stopcozi.domain;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
///**
// * 
// * @author Alexandra
// * 
// * We need to write a POJO class to represent an upload file
// * As we can see, JPA annotations are used to map this model class to the database table, very straightforward.
// */
//@Entity
//@Table(name = "FILES_UPLOAD")
//public class UploadFile {
//    private long id;
//    private String fileName;
//    private byte[] data;
// 
//    @Id
//    @GeneratedValue
//    @Column(name = "FILE_ID")
//    public long getId() {
//        return id;
//    }
// 
//    public void setId(long id) {
//        this.id = id;
//    }
// 
//    @Column(name = "FILE_NAME")
//    public String getFileName() {
//        return fileName;
//    }
// 
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
// 
//    @Column(name = "FILE_DATA")
//    public byte[] getData() {
//        return data;
//    }
// 
//    public void setData(byte[] data) {
//        this.data = data;
//    }
//}
//
