package com.sportyshoes.dao;

import java.util.List;

import com.sportyshoes.entity.PurchaseDetails;

public interface PurchaseDetailsDAO {

	
	public List<PurchaseDetails> getPurchases();
	public void savePurchase(PurchaseDetails purchase);
	public List<PurchaseDetails> getPurchases(String param);
	public List<PurchaseDetails> getPurchasesByDate();
}
