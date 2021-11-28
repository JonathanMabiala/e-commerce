package com.sportyshoes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.entity.User;



public interface UserDAO extends JpaRepository<User, Integer>{

	public List<User> getCustomers();
	public List<User> getAdmins();

	public void saveCustomer(User theCustomer);

	public User getCustomerById(int theId);

	public void deleteCustomer(int theId);

	public List<User> getCustomers(String data);

	public User getCustomerByEmail(String name);   
}
