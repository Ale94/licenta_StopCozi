package com.stopcozi.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.stopcozi.dao.FileUploadDao;
import com.stopcozi.domain.UploadDocs;
import com.stopcozi.domain.User;
import com.stopcozi.service.UserService;

/**
 * 
 * @author Alexandra
 * Handles requests for the file upload page.
 */
@RequestMapping("/uploadFiles")
public class UploadFileController {

	 @Autowired
	 private FileUploadDao fileUploadDao;
	 
	 @Autowired
	UserService userService;

	 @RequestMapping(value = "/uploadDocs", method = RequestMethod.GET)
	    public String showUploadForm(HttpServletRequest request) {
	        return "uploadDocs";
	    }
	 @RequestMapping(value = "/uploadDocs", method = RequestMethod.POST)
	    public String handleFileUpload(@RequestParam("myFile") MultipartFile myFile
	          /*  @RequestParam CommonsMultipartFile[] fileUpload*/, Principal principal) throws Exception {
	          
//	        if (fileUpload != null && fileUpload.length > 0) {
//	            for (CommonsMultipartFile aFile : fileUpload){
//	                  
//	                System.out.println("Saving file: " + aFile.getOriginalFilename());
//	                 
//	                UploadDocs uploadFile = new UploadDocs();
//	                uploadFile.setFileName(aFile.getOriginalFilename());
//	                uploadFile.setData(aFile.getBytes());
//	                
//	                User user=userService.findByUsername(principal.getName());
//	                uploadFile.setUser(user);
//	        		
//	        		
//	                fileUploadDao.save(uploadFile);  
//	                
//	                
//	            }
//	        }
		 if(myFile!=null){
			 UploadDocs uploadFile = new UploadDocs();
             uploadFile.setFileName(myFile.getOriginalFilename());
             uploadFile.setData(myFile.getBytes());
             
             User user=userService.findByUsername(principal.getName());
             uploadFile.setUser(user);
     		
     		
             fileUploadDao.save(uploadFile);  
		 }
	  
	        return "uploadDocs";
	    }  
}
