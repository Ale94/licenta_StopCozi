//package com.stopcozi.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
//import com.stopcozi.dao.FileUploadDao;
//import com.stopcozi.domain.UploadFile;
//
///**
// * 
// * @author Alexandra
// * Handles requests for the file upload page.
// */
//public class UploadFileController {
//
//	 @Autowired
//	 private FileUploadDao fileUploadDao;
//	 
//
//	 @RequestMapping(value = "/uploadDocs", method = RequestMethod.GET)
//	    public String showUploadForm(HttpServletRequest request) {
//	        return "uploadDocs";
//	    }
//	 @RequestMapping(value = "/uploadDocs", method = RequestMethod.POST)
//	    public String handleFileUpload(HttpServletRequest request,
//	            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
//	          
//	        if (fileUpload != null && fileUpload.length > 0) {
//	            for (CommonsMultipartFile aFile : fileUpload){
//	                  
//	                System.out.println("Saving file: " + aFile.getOriginalFilename());
//	                 
//	                UploadFile uploadFile = new UploadFile();
//	                uploadFile.setFileName(aFile.getOriginalFilename());
//	                uploadFile.setData(aFile.getBytes());
//	                fileUploadDao.save(uploadFile);               
//	            }
//	        }
//	  
//	        return "uploadDocs";
//	    }  
//}
