package com.stopcozi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stopcozi.domain.Document;
import com.stopcozi.domain.User;
import com.stopcozi.service.DocumentService;
import com.stopcozi.service.UserService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
/**
 * 
 * @author Alexandra
 * The important things: generate the document, which means, the document will be updated with
 * your data and you can preview it, and a download it, you can save your document locally.
 */
@Controller
@RequestMapping("/generateDoc")
public class GenerateDocumentController {

	@Autowired
	DocumentService documentService;
	
	@Autowired
	UserService userService;
	/*
	 * List  all documents which are available.
	 */
	@RequestMapping(value="/document", method = RequestMethod.GET)
	public String myApps(Principal principal, Model model){		
		model.addAttribute("documents", documentService.findAll());
		return "document";
	}
	/*
	 * Download a document.
	 */
	@RequestMapping(value ="/download", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void downloadDocument(Principal principal,@RequestParam Long id, HttpServletResponse response) throws IOException {
        Document document = documentService.findById(id);
        User user = userService.findByUsername(principal.getName());
        try {
			updateDocument(document,user);
		} catch (TemplateException e) {
			e.printStackTrace();
		}
        File file = new File("C:\\Users\\Alexandra\\workspaceEENeon\\StopCozi\\src\\main\\resources\\file.ftl");
        response.setContentType("application/pdf");
        response.setContentLength(document.getData().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getName() +"\"");	  
        FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());	
        response.flushBuffer();
    }
	
	/*
	 * Preview a document and call the update method, to insert the user data in the document.
	 */
	@RequestMapping(value ="/preview", method = RequestMethod.POST)
    public void previewDocument(Principal principal, @RequestParam Long id, HttpServletResponse response) throws IOException {
        Document document = documentService.findById(id);
        User user = userService.findByUsername(principal.getName());
        try {
			updateDocument(document,user);
		} catch (TemplateException e) {
			e.printStackTrace();
		}
        //name of the file can be: file+user.getName()
        File file = new File("C:\\Users\\Alexandra\\workspaceEENeon\\StopCozi\\src\\main\\resources\\file.ftl");
        response.setContentType(document.getType());
        response.setContentLength(document.getData().length);
        response.setHeader("Content-Disposition","inline; filename=\"" + document.getName() +"\"");
        FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());	
  
       
    }
	/*
	 * Insert the user data in the document.
	 */
	public void updateDocument(Document document, User user) throws TemplateException, IOException {
		 Configuration cfg = new Configuration(new Version("2.3.23"));

	        cfg.setDirectoryForTemplateLoading(new File("C:/Users/Alexandra/workspaceEENeon/StopCozi/src/main/resources/"));
	        cfg.setDefaultEncoding("UTF-8");

	        byte[] data = document.getData();
	        OutputStream out = new FileOutputStream("C:\\Users\\Alexandra\\workspaceEENeon\\StopCozi\\src\\main\\resources\\out.ftl");
	        out.write(data);
	        out.close();
	        Template template = cfg.getTemplate("out.ftl");

	        Map<String, Object> templateData = new HashMap<>();
	        
	        templateData.put("nume", (user.getLastName()==null) ? "_________________" : user.getLastName().toUpperCase());
	        templateData.put("prenume", (user.getFirstName()==null) ? "_________________" : user.getFirstName().toUpperCase());
	        templateData.put("tata", (user.getDad()==null) ? "_________________" : user.getDad().toUpperCase());
	        templateData.put("mama", (user.getMum()==null) ? "_________________" : user.getMum().toUpperCase());
	        templateData.put("an", (user.getAnulNasterii()==null) ? "_________________" : user.getAnulNasterii());
	        templateData.put("luna", (user.getLunaNasterii()==null) ? "_________________" : user.getLunaNasterii());
	        templateData.put("zi", (user.getZiuaNasterii()==null) ? "_________________" : user.getZiuaNasterii());
	        templateData.put("locNasterii", (user.getDomiciliuNastere()==null) ? "_________________" : user.getDomiciliuNastere().toUpperCase());
	        templateData.put("judetNas", (user.getJudetNastere()==null) ? "_________________" : user.getJudetNastere().toUpperCase());
	        templateData.put("domiciliu", (user.getDomiciliuActual()==null) ? "_________________" : user.getDomiciliuActual().toUpperCase());
	        templateData.put("judetDom", (user.getJudetActual()==null) ? "_________________" : user.getJudetActual().toUpperCase());
	        templateData.put("strDom", (user.getStrada() == null) ? "_________________" : user.getStrada().toUpperCase());
	        templateData.put("nrDom", (user.getNumarAdresa()==null) ? "_________________" : user.getNumarAdresa());
	        templateData.put("bloc", (user.getBloc() == null) ? "_________________" : user.getBloc().toUpperCase());
	        templateData.put("aprt", (user.getApartament() == null) ? "_________________" : user.getApartament().toUpperCase());
	        templateData.put("seria", (user.getSeria()==null) ? "_________________" : user.getSeria().toUpperCase());
	        templateData.put("nr", (user.getNrBuletin()==null) ? "_________________" : user.getNrBuletin());
	        templateData.put("cnp", (user.getCnp()==null) ? "_________________" : user.getCnp());

	        Writer file = new FileWriter (new File("C:\\Users\\Alexandra\\workspaceEENeon\\StopCozi\\src\\main\\resources\\file.ftl"));
			template.process(templateData, file);
			file.flush();
			file.close();

	}
		
	
}




