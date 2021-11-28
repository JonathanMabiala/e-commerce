package com.sportyshoes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entity.User;
import com.sportyshoes.entity.UserRole;

@Repository
public class UserRoleDAOImpl implements UserRoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List <UserRole> getUserRoles() {
		
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create a query ...sort by last name
		
		Query <UserRole> theQuery = currentSession.createQuery("from UserRole",
				UserRole.class);
		
		// Execute query and get result list
		
		List <UserRole> roles = theQuery.getResultList();
		
		return roles;
	}

}
