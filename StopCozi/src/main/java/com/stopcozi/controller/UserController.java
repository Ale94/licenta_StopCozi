package com.stopcozi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stopcozi.domain.User;
import com.stopcozi.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String profile(Principal principal, Model model){
	
		User user = userService.findByUsername(principal.getName());
		model.addAttribute("user",user);
		
		return "profile";
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public String postProfile(@ModelAttribute("user") User newUser,Model model){
		
		User user= userService.findByUsername(newUser.getUsername());
		user.setLastName(newUser.getLastName());
		user.setEmail(newUser.getEmail());
		user.setPhone(newUser.getPhone());
		user.setFirstName(newUser.getFirstName());
		user.setUsername(newUser.getUsername());
		
		model.addAttribute("user", user);
		
		userService.save(user);
		
		return "profile";
	}
	
	
}

