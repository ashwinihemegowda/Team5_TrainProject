package com.torryharris.controllers;


import com.torryharris.model.UserLogin;
import com.torryharris.model.UserRegDTO;
import com.torryharris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
public class UserRegistrationController {

	@Autowired
	UserService service;
	
	@RequestMapping("/registration")
	public ModelAndView register() {
		return new ModelAndView("register","objReg", new UserRegDTO());
	}
	
	@ModelAttribute("countryList")
	public Map<String,String> countries(){
		//get countries from db
		Map<String,String> map = new HashMap<String, String>();
		map.put("Ind","Bangalore");
		map.put("SI","Chennai");
		map.put("Ch","Kolkata");
		map.put("USA","Mumbai");

		return map;
	}
	

	
	@RequestMapping("/processRegistration")
	public ModelAndView processReg(@ModelAttribute("objReg") UserRegDTO user) {
		
		if(service.registerUser(user)) {
			return new ModelAndView("login","objUser", new UserLogin());
		}
		return new ModelAndView("register","objReg", new UserRegDTO("reg failed!!"));
	}
	
}
