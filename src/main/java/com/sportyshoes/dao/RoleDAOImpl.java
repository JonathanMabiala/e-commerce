package com.sportyshoes.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;

import com.sportyshoes.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public Role findByRole(String role) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query <Role> theQuery = currentSession.createQuery("from Role where role_name=:data ", Role.class);
		theQuery.setParameter("data", role);
		
		Role theRole = theQuery.getSingleResult();
		
		//System.out.println(customer);
	
		return theRole;
	}

	@Override
	public void saveRole(Role role) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(role);
		
	}

}
