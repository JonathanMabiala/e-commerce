package com.sportyshoes.entity;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class SessionUtil {

	public Model userStatus (HttpServletRequest request,Model theModel) {
		boolean logged=false;
		Principal principal = request.getUserPrincipal();
		if(principal!=null) {
		if( principal.getName() !=null)
			logged = true;
		}
		return theModel.addAttribute("logged", logged);
	}
}
