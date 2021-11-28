package com.sportyshoes.service;

import java.util.List;

import com.sportyshoes.entity.User;



public interface UserService {
	
	public List<User> getCustomers();
	public List<User> getAdmins();

	public void saveCustomer(User theCustomer);

	public User getCustomerById(int theId);

	public void deleteCustomer(int theId);

	public List<User> getCustomers(String data);

	public User getCustomerByEmail(String data);
	
	public boolean isCustomerAlreadyPresent(User user);
	public void saveAdmin(User theUser);
	public void saveAdminPassword(User theUser);
	void saveCustomerPassword(User theUser);
}
