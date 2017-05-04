package com.stopcozi.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.stopcozi.domain.UploadFile;
import com.stopcozi.domain.User;
import com.stopcozi.service.UploadFileService;
import com.stopcozi.service.UserService;

/**
 * 
 * @author Alexandra
 * Handles requests for the file upload page.
 */
@Controller
@RequestMapping("/upload")
public class UploadFileController {

	 @Autowired
	 private UploadFileService uploadService;
	 
	 @Autowired
	UserService userService;

	 @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	    public String showUploadForm() {
	        return "uploadFile";
	    }
	 @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE) 
	    public String handleFileUpload(@RequestParam("myFile") MultipartFile myFile
	         /*  @RequestParam("fileUpload") CommonsMultipartFile[] fileUpload*/, Principal principal) throws Exception {
	          

		 if(myFile!=null){
			 UploadFile uploadFile = new UploadFile();
             uploadFile.setFileName(myFile.getOriginalFilename());
             uploadFile.setData(myFile.getBytes());
             
             User user=userService.findByUsername(principal.getName());
             uploadFile.setUser(user);
     		
     		
             uploadService.save(uploadFile);  
		 }
	  
	        return "uploadFile";
	    }  
}


//if (fileUpload != null && fileUpload.length > 0) {
//for (CommonsMultipartFile aFile : fileUpload){
//      
//    System.out.println("Saving file: " + aFile.getOriginalFilename());
//     
//    UploadFile uploadFile = new UploadFile();
//    uploadFile.setFileName(aFile.getOriginalFilename());
//    uploadFile.setData(aFile.getBytes());
//    
//    User user=userService.findByUsername(principal.getName());
//    uploadFile.setUser(user);
//	
//	
//    uploadService.save(uploadFile);  
//    
//    
//}
//}