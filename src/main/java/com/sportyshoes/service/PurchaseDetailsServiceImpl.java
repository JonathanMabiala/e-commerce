package com.sportyshoes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.dao.PurchaseDetailsDAO;
import com.sportyshoes.entity.PurchaseDetails;
@Service
public class PurchaseDetailsServiceImpl implements PurchaseDetailsService {
	
	@Autowired
	private PurchaseDetailsDAO purchaseDetailsDAO;

	@Override
	@Transactional
	public List<PurchaseDetails> getPurchases() {
		
		return purchaseDetailsDAO.getPurchases();
	}

	@Override
	@Transactional
	public void savePurchase(PurchaseDetails purchase) {
		purchaseDetailsDAO.savePurchase(purchase);

	}

	@Override
	@Transactional
	public List<PurchaseDetails> getPurchases(String param) {
		// TODO Auto-generated method stub
		return purchaseDetailsDAO.getPurchases(param);
	}

	@Override
	@Transactional
	public List<PurchaseDetails> getPurchasesByDate() {
		
		return purchaseDetailsDAO.getPurchasesByDate();
	}

}
