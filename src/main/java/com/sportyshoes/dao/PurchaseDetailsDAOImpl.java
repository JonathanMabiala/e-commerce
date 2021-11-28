package com.sportyshoes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entity.User;
import com.sportyshoes.entity.PurchaseDetails;


@Repository
public class PurchaseDetailsDAOImpl implements PurchaseDetailsDAO {

	//Inject the session factory object
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<PurchaseDetails> getPurchases() {
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create a query ...sort by last name
		
		Query <PurchaseDetails> theQuery = currentSession.createQuery("from PurchaseDetails ",
				PurchaseDetails.class);
		
		// Execute query and get result list
		
		List <PurchaseDetails> purchases = theQuery.getResultList();
		return purchases;
	}
	
	@Override
	public List<PurchaseDetails> getPurchases(String param) {
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create a query ...sort by last name
		
		Query <PurchaseDetails> theQuery = currentSession.createQuery("from PurchaseDetails where category=:data",
				PurchaseDetails.class);
		theQuery.setParameter("data", param);
		
		// Execute query and get result list
		
		List <PurchaseDetails> purchases = theQuery.getResultList();
		return purchases;
	}

	@Override
	public List<PurchaseDetails> getPurchasesByDate() {
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create a query ...sort by last name
		
		Query <PurchaseDetails> theQuery = currentSession.createQuery("from PurchaseDetails order by date_added",
				PurchaseDetails.class);
		
		// Execute query and get result list
		
		List <PurchaseDetails> purchases = theQuery.getResultList();
		return purchases;
	}

	
	@Override
	public void savePurchase(PurchaseDetails purchase) {
		
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Save the customer
		currentSession.saveOrUpdate(purchase);

	}


	

}
