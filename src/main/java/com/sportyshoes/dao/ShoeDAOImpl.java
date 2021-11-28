package com.sportyshoes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entity.User;
import com.sportyshoes.entity.Shoe;

@Repository
public class ShoeDAOImpl implements ShoeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Shoe> getShoes() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query <Shoe> theQuery = currentSession.createQuery("FROM Shoe",Shoe.class);
		
		List<Shoe> shoes = theQuery.getResultList();
		
		return shoes;
	}

	@Override
	public void addShoe(Shoe theShoe) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theShoe);
		
		
	}

	@Override
	public Shoe getShoeById(int theId) {
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// now retrieve / read form database using the primary key
				
		Shoe theShoe = currentSession.get(Shoe.class,theId);
		
		return theShoe;
	}

	@Override
	public void deleteShoe(int theId) {
		//Get the current Hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		
		Query theQuery = currentSession.createQuery("delete from Shoe where id=:shoeId");
		
		theQuery.setParameter("shoeId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Shoe> getByCategoryShoes(String data) {
		
		//Get the current Hibernate session

		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		
		Query <Shoe> theQuery = currentSession.createQuery("from Shoe where category=:data ", Shoe.class);
		theQuery.setParameter("data", data);
		
		List <Shoe> shoes = theQuery.getResultList();
		
		return shoes;
	}

}
