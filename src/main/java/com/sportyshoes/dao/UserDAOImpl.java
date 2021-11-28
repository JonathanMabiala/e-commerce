package com.sportyshoes.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entity.User;



@Repository
public class UserDAOImpl implements UserDAO {

	//Inject the session factory object
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<User> getCustomers() {
		
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create a query ...sort by last name
		
		Query <User> theQuery = currentSession.createQuery("from User where role_id=2 order by lastName ",
																User.class);
		
		// Execute query and get result list
		
		List <User> users = theQuery.getResultList();
		
		
		return users;
	}

	@Override
	public void saveCustomer(User theCustomer) {
		
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		
		 
		//Save the customer
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public User getCustomerById(int theId) {
		//Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve / read form database using the primary key
		
		User theCustomer = currentSession.get(User.class,theId);
		
		return theCustomer;

	}

	@Override
	public void deleteCustomer(int theId) {
		
		//Get the current Hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		
		Query theQuery = currentSession.createQuery("delete from User where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
		
	}

	@Override
	public List<User> getCustomers(String data) {
		
		//Get the current Hibernate session

		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		
		Query <User> theQuery = currentSession.createQuery("from User where first_name=:data or last_name=:data ", User.class);
		theQuery.setParameter("data", data);
		
		List <User> users = theQuery.getResultList();
		
		//System.out.println("Here we are :" + customers);
		
		return users;
		
	}

	@Override
	public User getCustomerByEmail(String email) {
		//Get the current Hibernate session

				Session currentSession = sessionFactory.getCurrentSession();
				
				// delete object with primary key
				
				Query <User> theQuery = currentSession.createQuery("from User where email=:data ", User.class);
				theQuery.setParameter("data", email);
				
				User user = theQuery.getSingleResult();
				
				//System.out.println(customer);
				return user;
	}
	
	
	@Override
	public List <User> getAdmins() {
		//Get the current Hibernate session

				Session currentSession = sessionFactory.getCurrentSession();
				
				// delete object with primary key
				
				Query <User> theQuery = currentSession.createQuery("FROM User where role_id=:data " , User.class);
				
				theQuery.setParameter("data",1);
				
				List <User> users = theQuery.getResultList();
				
				
			
				return users;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends User> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<User> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends User> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends User> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends User, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
