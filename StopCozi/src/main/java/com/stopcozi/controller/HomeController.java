package com.stopcozi.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stopcozi.dao.RoleDaoRepository;
import com.stopcozi.domain.User;
import com.stopcozi.domain.security.UserRole;
import com.stopcozi.service.UserService;

//register the class as a controller
//with this annotation the class will be register as a bean in the spring container
@Controller
public class HomeController {

	
	@Autowired
	private UserService userService;
	
	/*
	 * It will be better to define a RoleService, so RoleDao -> RoleService (eventually)  
	 */
	@Autowired
	private RoleDaoRepository roleDao;
	// /-> root folder
	@RequestMapping("/")
	public String home(){
		//the string will be automatically known as a template name
		//because we added the dependency thymeleaf, so spring is smart enough to know that and in a template the extension 
		//will be .xml 
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model){
		
		User user=new User();
		model.addAttribute("user", user);
		
		return "signup";
		
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") User user, Model model){
		if(userService.checkUserExists(user.getUsername(), user.getEmail())){
			if(userService.checkEmailExists(user.getEmail())){
				model.addAttribute("emailExists", true);
			}
			if(userService.checkUsernameExists(user.getUsername())){
				model.addAttribute("usernameExists", true);
			}
			return "signup";
		}
		else{
			Set<UserRole> userRoles = new HashSet<>();
			userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));
			
			userService.createUser(user, userRoles);
			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/userFront")
	public String userFront(Principal principal, Model model){
		User user=userService.findByUsername(principal.getName());
		
		return "userFront";
	}
}
