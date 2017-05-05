package com.stopcozi.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	 /**
	  * Upload a document.
	  * @param principal
	  * @param model
	  * @return redirect to "uploadFile.html"
	  */
	 @RequestMapping(value="/uploadFile", method = RequestMethod.GET)
		public String myApps(Principal principal, Model model){
			
		User user = userService.findByUsername(principal.getName());
		model.addAttribute("myFiles", userService.listAllUploadedFiles(user));
		return "uploadFile";
		}
	 
	 /**
	  * Download a document, redirect to "upload/uploadFile" where the page gets refreshed and the list of
	  * documents is updated.
	  * First I was trying to use PathVariable and working with GET Method, but
	  * since I am also working with spring security (always recommended) I've read that should be
	  * preferred POST instead of GET for all modification operations, such as delete to protect against CSRF attack.
	  * produces=".." necessarily for force the download, but still not working 
	  * @param id
	  * @param response
	  * @return redirect to "uploadFile.html"
	  * @throws IOException
	  */
	 @RequestMapping(value ="/download", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	    public void downloadDocument(@RequestParam Long id, HttpServletResponse response) throws IOException {
	        UploadFile document = uploadService.findById(id);
	        //with this 
	        response.setContentType("application/force-download");
	        response.setContentLength(document.getData().length);
	        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getFileName() +"\"");	  
	        FileCopyUtils.copy(document.getData(), response.getOutputStream());	
	        //and this worked :D
	        response.flushBuffer();
	    }
	 
//	 @RequestMapping(value = "/download", method = RequestMethod.GET)
//	 public @ResponseBody HttpEntity<byte[]> download(@RequestParam Long id) throws IOException {
//		 UploadFile document = uploadService.findById(id);
//		 byte[] data = document.getData();	     
//	     HttpHeaders header = new HttpHeaders();
//	     header.set("Content-Disposition", "inline; filename=" + document.getFileName());
//	     header.setContentLength(data.length);
//	     return new HttpEntity<byte[]>(data, header);
//	 }
	    /**
	     * Delete a document. Read the comment above(downloadDocu) why I used RequestParam insead of PathVariable
	     * @param id
	     * @return redirect to "uploadFile.html"
	     */
	    @RequestMapping(value ="/delete", method = RequestMethod.POST)
	    public String deleteDocument(@RequestParam Long id) {
	    	uploadService.deleteById(id);
	        return "redirect:/upload/uploadFile";
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