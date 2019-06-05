package edu.mum.cs.cs425.demowebapps.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {

	//@GetMapping(value= {"/","/elibrary","/elibrary/home"})
	//@RequestMapping(value="/", method=RequestMethod.GET)
	
	@RequestMapping(value= {"/","/elibrary"}, method=RequestMethod.GET)
	
	public String displayHomePage() {
		
		return "home/index";
	} 
}
