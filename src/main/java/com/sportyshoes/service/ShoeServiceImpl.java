package com.sportyshoes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.dao.ShoeDao;
import com.sportyshoes.entity.Shoe;

@Service
public class ShoeServiceImpl implements ShoeService {
	
	@Autowired
	private ShoeDao shoeDao;

	@Override
	@Transactional
	public List<Shoe> getShoes() {
		
		return shoeDao.getShoes();
	}

	@Override
	@Transactional
	public void addShoe(Shoe theShoe) {
		shoeDao.addShoe(theShoe);	
	}

	@Override
	@Transactional
	public Shoe getShoeById(int theId) {
		
		return shoeDao.getShoeById(theId);
	}

	@Override
	@Transactional
	public void deleteShoe(int theId) {
		
		shoeDao.deleteShoe(theId);
	}

	@Override
	@Transactional
	public List<Shoe> getByCategoryShoes(String data) {
		// TODO Auto-generated method stub
		return shoeDao.getByCategoryShoes(data);
	}

}
