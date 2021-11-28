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

import com.sportyshoes.entity.User;
import com.sportyshoes.entity.SessionUtil;
import com.sportyshoes.service.UserService;

@Controller
@RequestMapping("/customer")
public class UserController {

	//Need to inject User service
	
	@Autowired
	UserService userService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel,HttpServletRequest request) {
		
		//Get the customer from the service object
		
		List <User> user = userService.getCustomers();
		User searchCustomer = new User();
		
		// Add the customers to the model
		SessionUtil util = new SessionUtil();
		util.userStatus(request, theModel);
		theModel.addAttribute("customer", user);
		theModel.addAttribute("searchCustomer", searchCustomer);
		
		
		return "customers";
	}
	
	@GetMapping("/admins")
	public String listAdmins(Model theModel,HttpServletRequest request) {
		
		//Get the customer from the service object
		
		List <User> user = userService.getAdmins();
		User searchCustomer = new User();
		
		// Add the customers to the model
		SessionUtil util = new SessionUtil();
		util.userStatus(request, theModel);
		theModel.addAttribute("user", user);
		theModel.addAttribute("searchCustomer", searchCustomer);
		
		
		return "admins";
	}
	
	
	
	
	@PostMapping("/search")
	public String searchCustomers(@ModelAttribute("searchCustomer") User thecustomer,Model theModel,HttpServletRequest request) {
		
		//Get the customer from the service object
		System.out.println("This is the value :" + thecustomer);
		
		
		
		List <User> user;
		
		if(thecustomer.getName().trim() !="") {
			
		 user = userService.getCustomers(thecustomer.getName());
		
		}else{
			
	    user = userService.getCustomers();
		
		}
		
		SessionUtil util = new SessionUtil();
		util.userStatus(request, theModel);
		theModel.addAttribute("customer", user);
		
		return "customers";
	}
	
	@GetMapping("/add")
	public String showFormForAdd(Model theModel) {
		
		//Create model attribute to bind form data
		
		User theCustomer = new User();
		
		theModel.addAttribute("customer",theCustomer);
		
		return "add-customer";
	}
	
	@PostMapping("/save_customer")
	public String saveCustomer(@ModelAttribute("customer") User theUser){
		
		//Set the role_id
		
		//Save the customer using our service
		
		userService.saveCustomer(theUser);
		
		return "redirect:/";
		
	}
	
	@PostMapping("/save_customer_password")
	public String saveCustomerPassword(@ModelAttribute("user") User theUser){
		
		//Set the role_id
		
		//Save the customer using our service
		
		userService.saveCustomerPassword(theUser);
		
		return "redirect:/";
		
	}
	
	@PostMapping("/save_admin_password")
	public String savePassword(@ModelAttribute("user") User theUser){
		
		//Set the role_id
		
		//Save the customer using our service
		
		userService.saveAdminPassword(theUser);
		
		return "redirect:/";
		
	}
	@PostMapping("/save_admin")
	public String saveAdmin(@ModelAttribute("user") User theUser){
		
		//Set the role_id
		
		//Save the customer using our service
		
		userService.saveAdmin(theUser);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/update_admin")
	public String showFormForUpdateAdmin(@RequestParam("id") int theId, Model theModel) {
		
		//Get the customer form our Service
		
		User currentUser = userService.getCustomerById(theId);
		
		//set customer as a model attribute to pre-populate the form
		
		theModel.addAttribute("user",currentUser);
		
		//send over to our form
		
		
		
		return "update_admin";
	}
	
	@GetMapping("/update_admin_password")
	public String showFormForUpdateAdminPassword(@RequestParam("id") int theId, Model theModel) {
		
		//Get the customer form our Service
		
		User currentUser = userService.getCustomerById(theId);
		
		//set customer as a model attribute to pre-populate the form
		
		theModel.addAttribute("user",currentUser);
		
		//send over to our form
		
		
		
		return "update_admin_password";
	}
	
	@GetMapping("/update_customer_password")
	public String showFormForUpdateCustomerPassword(@RequestParam("id") int theId, Model theModel) {
		
		//Get the customer form our Service
		
		User currentUser = userService.getCustomerById(theId);
		
		//set customer as a model attribute to pre-populate the form
		
		theModel.addAttribute("user",currentUser);
		
		//send over to our form

		return "update_customer_password";
	}
	
	@GetMapping("/update_customer")
	public String showFormForUpdateCustomer(@RequestParam("id") int theId, Model theModel) {
		
		//Get the customer form our Service
		
		User currentUser = userService.getCustomerById(theId);
		
		//set customer as a model attribute to pre-populate the form
		
		theModel.addAttribute("user",currentUser);
		
		//send over to our form
			
		return "update_customer";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId, Model theModel) {
		
		//Delete the customer
		userService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
}
