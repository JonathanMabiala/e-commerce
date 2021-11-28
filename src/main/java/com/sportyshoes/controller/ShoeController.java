package com.sportyshoes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.entity.SessionUtil;
import com.sportyshoes.entity.Shoe;
import com.sportyshoes.service.ShoeService;

@Controller
@RequestMapping("/shoe")
public class ShoeController {

	@Autowired
	private ShoeService shoeService;
	
	@RequestMapping("/shoes")
	public String showShoes(HttpServletRequest request,Model theModel) {
		
		List <Shoe> shoes = shoeService.getShoes();
		
		SessionUtil util = new SessionUtil();
		util.userStatus(request, theModel);
		theModel.addAttribute("shoe", shoes);
		
		return "shoes";
	}
	
	@RequestMapping("/kids")
	public String showKidsShoes(HttpServletRequest request,Model theModel) {
		
		List <Shoe> shoes = shoeService.getByCategoryShoes("kids");
		
		SessionUtil util = new SessionUtil();
		util.userStatus(request, theModel);
		theModel.addAttribute("shoe", shoes);
		
		return "shoes";
	}
	
	@RequestMapping("/women")
	public String showWomenShoes(HttpServletRequest request,Model theModel) {
		
		List <Shoe> shoes = shoeService.getByCategoryShoes("women");
		
		SessionUtil util = new SessionUtil();
		util.userStatus(request, theModel);
		theModel.addAttribute("shoe", shoes);
		
		return "shoes";
	}
	
	@RequestMapping("/men")
	public String showMenShoes(HttpServletRequest request,Model theModel) {
		
		List <Shoe> shoes = shoeService.getByCategoryShoes("men");
		
		SessionUtil util = new SessionUtil();
		util.userStatus(request, theModel);
		theModel.addAttribute("shoe", shoes);
		
		return "shoes";
	}
	
	@GetMapping("/newShoe")
	public String newShoe(HttpServletRequest request,Model theModel) {
		
		Shoe theShoe = new Shoe();
		
		SessionUtil util = new SessionUtil();
		util.userStatus(request, theModel);
		theModel.addAttribute("shoe", theShoe);
		
		return "new_shoe";
	}
	
	@PostMapping("/addNewShoe")
	public String saveStudent(@ModelAttribute("shoe") Shoe theShoe) {
		
		// Save the Student object with the Service object
		
		shoeService.addShoe(theShoe);
		
		return "redirect:/shoe/shoes";
		
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute("id") int theId, Model theModel) {
		
		//Get a Subject by Id
		Shoe theShoe = shoeService.getShoeById(theId);
		
		//Assign the subject to a model
		
		theModel.addAttribute("shoe",theShoe);
		
		return "new_shoe";
		
	}
	
	@GetMapping("/delete")
	public String deleteSubject(@RequestParam("id") int theId, Model theModel) {
		
		//Delete the subject
		shoeService.deleteShoe(theId);
		
		return "redirect:/shoe/shoes";
	}
}
