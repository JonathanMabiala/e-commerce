package com.sportyshoes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.entity.User;
import com.sportyshoes.service.UserService;

@Controller
public class Login {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/login")
	public String showLogin() {
		
		return "login";
	}
	
	@RequestMapping("/register")
	public String register(Model theModel) {
		
		theModel.addAttribute("customer", new User());
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult,ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		//Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in the form!");
			modelAndView.addObject("bindingResult", bindingResult);
		}
		//
		
		else if (userService.isCustomerAlreadyPresent(user))
		{
			modelAndView.addObject("errorMessage", "user already exits!");
			
		}else {
			userService.saveCustomer(user);
			modelAndView.addObject("successMessage", "user is registered successfully!");
		}
		modelAndView.addObject("customer", new User());
		modelAndView.setViewName("register");
		
		return modelAndView;
		
	}
	
	//Add access denied page
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
	}

	
}
