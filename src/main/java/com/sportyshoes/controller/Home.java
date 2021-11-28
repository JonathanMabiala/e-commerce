package com.sportyshoes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sportyshoes.entity.SessionUtil;
import com.sportyshoes.entity.Shoe;
import com.sportyshoes.service.ShoeService;

@Controller
public class Home {
	
	@Autowired
	private ShoeService shoeService;
	
	
	
	@RequestMapping("/")
	public String showHome(HttpServletRequest request,Model theModel) {
		
		
		
		List <Shoe> shoes = shoeService.getShoes();
		
		SessionUtil util = new SessionUtil();
		util.userStatus(request, theModel);
		theModel.addAttribute("shoe", shoes);
		
		
		return "home";
	}
	
	// Add Request mapping for /leaders
	
	@GetMapping("/leaders")
	public String showLeaders() {
		
		return "leaders";
	}
	
	// Add Request mapping for /systems
	
		@GetMapping("/systems")
		public String showSystems() {
			
			return "systems";
		}
}
