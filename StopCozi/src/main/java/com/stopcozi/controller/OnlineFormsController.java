package com.stopcozi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/account")

public class OnlineFormsController {

	@RequestMapping(value="/formulare", method=RequestMethod.GET)
	public String viewFormulare(Model model){
	
		return "formulare";
	}
}
