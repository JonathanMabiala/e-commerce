package com.sportyshoes.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.entity.User;
import com.sportyshoes.entity.PurchaseDetails;
import com.sportyshoes.entity.SessionUtil;
import com.sportyshoes.entity.Shoe;
import com.sportyshoes.service.UserService;
import com.sportyshoes.service.PurchaseDetailsService;
import com.sportyshoes.service.ShoeService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private PurchaseDetailsService purchaseDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShoeService shoeService;
	

	@RequestMapping("/show")
	public String showPurchases(Model theModel, HttpServletRequest request) {
		
	try {
		List <PurchaseDetails> purchases = purchaseDetailsService.getPurchases();
		
		theModel.addAttribute("purchases", purchases);
		
		
	}catch(Exception exc) {
		
		System.out.println("No purchases");
	}
	SessionUtil util = new SessionUtil();
	util.userStatus(request, theModel);
	return "purchases";
	}
	
	@RequestMapping("/show_by_date")
	public String showPurchasesByDate(Model theModel, HttpServletRequest request) {
		
	try {
		List <PurchaseDetails> purchases = purchaseDetailsService.getPurchasesByDate();
		
		theModel.addAttribute("purchases", purchases);
		
		
	}catch(Exception exc) {
		
		System.out.println("No purchases");
	}
	SessionUtil util = new SessionUtil();
	util.userStatus(request, theModel);
	return "purchases";
	}
	
	@RequestMapping("/show_by_category")
	public String showPurchasesBydate(Model theModel, HttpServletRequest request,@RequestParam("category") String param) {
		
	try {
		List <PurchaseDetails> purchases = purchaseDetailsService.getPurchases(param);
		
		theModel.addAttribute("purchases", purchases);
		
		
	}catch(Exception exc) {
		
		System.out.println("No purchases");
	}
	SessionUtil util = new SessionUtil();
	util.userStatus(request, theModel);
	return "purchases";
	}
	
//	@GetMapping("/buy")
//	public String saveStudent(@RequestParam("id") int id, Principal principal) {
//		
//		// Save the Student object with the Service object
//		
//		//purchaseDetailsService.savePurchase(null);
//		//System.out.println("The user name " + principal.getName());
//		//System.out.println("The shoe id is :" + id);
//		
//		return "shoes";
//		
//	}
	
	@GetMapping("/buy")
    public String currentUserNameSimple(HttpServletRequest request,@RequestParam("id") int id,@RequestParam("category") String category, Model theModel) {
		
		
		//Create a custom url based on the Category
		String url = "redirect:/shoe/"+ category.toLowerCase();
		// Define a message for any alert
		
		String message =null;
		
		
		Principal principal = request.getUserPrincipal();
		
		//Check if the principal object is not null if null tell the user to login first
		if(principal !=null) {
		//Get the customer by email
		User theCustomer = userService.getCustomerByEmail(principal.getName());
		
		
		
       
         
       //User Properties
       String username = theCustomer.getName() + " " + theCustomer.getLastName();
       String email = theCustomer.getEmail();
         
        //Get the shoe by id
         
         Shoe theShoe = shoeService.getShoeById(id);
    
        //Shoe Properties
        
        String shoeBrand = theShoe.getBrand();
        String shoeName = theShoe.getName();
        String thecategory = theShoe.getCategory();
        double price = theShoe.getPrice();
        int quantity = theShoe.getQuantity()  < 1 ? 0 : theShoe.getQuantity()-1;
         
         if(quantity != 0) {
         //Create a purchase object
         //Get time
        
         PurchaseDetails thepurchase = new PurchaseDetails(username, shoeBrand, shoeName, 1, email, price,thecategory, java.time.LocalDateTime.now());
       
        // Save the purchase
       
         purchaseDetailsService.savePurchase(thepurchase);
        
        //Set new Shoe quantity
        theShoe.setQuantity(quantity);
        //Save quantiy
        shoeService.addShoe(theShoe) ;
         } else {
        	 message = "This Product is no more Available";
        	 
        	 
         }
		}else {
			
			message = "Login First to purchase the product";
			
		}
		
		List <Shoe> shoes = shoeService.getByCategoryShoes(category.toLowerCase());
		
		theModel.addAttribute("shoe", shoes);
		
		
         
		theModel.addAttribute("message",message);
        
        return "shoes";
    }
	
	
}
