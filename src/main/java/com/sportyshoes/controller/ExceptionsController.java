package com.sportyshoes.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionsController  {
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String pageNotFound(Model theModel,Exception exc) {
		
		theModel.addAttribute("message", exc.getMessage());
		return "error";
	}

}
   