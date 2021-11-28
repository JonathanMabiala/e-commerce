package com.sportyshoes.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportyshoes.dao.UserDAO;
import com.sportyshoes.dao.RoleDAO;
import com.sportyshoes.entity.User;
import com.sportyshoes.entity.Role;


@Service
public class UserServiceImpl implements UserService {

	//Need to inject User DAO
	
	@Autowired 
	private UserDAO userDAO;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	RoleDAO roleDAO;
	
	
	@Override
	@Transactional
	public List<User> getCustomers() {
		
		//Get User
		return userDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(User theCustomer) {
		
		theCustomer.setPassword(encoder.encode(theCustomer.getPassword()));
		theCustomer.setRoleId(2);
		theCustomer.setStatus("VERIFIED");
		Role customerRole = roleDAO.findByRole("SITE_USER");
		theCustomer.setRoles(new HashSet<Role>(Arrays.asList(customerRole)));
		
		
		userDAO.saveCustomer(theCustomer);
	}
	
	@Override
	@Transactional
	public void saveCustomerPassword(User theUser) {
		
		theUser.setPassword(encoder.encode(theUser.getNewPassword()));
		Role customerRole = roleDAO.findByRole("SITE_USER");
		theUser.setRoles(new HashSet<Role>(Arrays.asList(customerRole)));
		System.out.println("This is the final product : " + theUser);
		userDAO.saveCustomer(theUser);
		
	}

	@Override
	@Transactional
	public User getCustomerById(int theId) {
		
		return	userDAO.getCustomerById(theId);
		
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		userDAO.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<User> getCustomers(String data) {
		
		return userDAO.getCustomers(data);
	}

	@Override
	@Transactional
	public User getCustomerByEmail(String name) {
		
		return userDAO.getCustomerByEmail(name);
	}

	@Override
	@Transactional
	public boolean isCustomerAlreadyPresent(User user) {
		User theCustomer = null;
		try {
			//Get the email from customer
			String email = user.getEmail();
			 theCustomer = getCustomerByEmail(email);
			
		}catch(Exception exc) {
			System.out.println("The user error getting user");
		}
		if( theCustomer != null) {
			
			return true;
		}else {
		
		return false;
		}
		
	}

	@Override
	@Transactional
	public List<User> getAdmins() {
		
		return userDAO.getAdmins();
	}

	@Override
	@Transactional
	public void saveAdmin(User theUser) {
		theUser.setRoleId(1);
		theUser.setStatus("VERIFIED");
		Role customerRole = roleDAO.findByRole("ADMIN_USER");
		theUser.setRoles(new HashSet<Role>(Arrays.asList(customerRole)));
		theUser.setPassword(theUser.getPassword());
		
		userDAO.saveCustomer(theUser);
		
	}

	@Override
	@Transactional
	public void saveAdminPassword(User theUser) {
		
		theUser.setPassword(encoder.encode(theUser.getNewPassword()));
		Role userRole = roleDAO.findByRole("ADMIN_USER");
		theUser.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userDAO.saveCustomer(theUser);
		
	}

	@Override
	@Transactional
	public void saveNewAdmin(User theUser) {
		
		theUser.setRoleId(1);
		theUser.setStatus("VERIFIED");
		theUser.setPassword(encoder.encode(theUser.getPassword()));
		Role userRole = roleDAO.findByRole("ADMIN_USER");
		theUser.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userDAO.saveCustomer(theUser);
	}

}
