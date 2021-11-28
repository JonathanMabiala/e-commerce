package com.sportyshoes.service;

import java.util.List;

import com.sportyshoes.entity.PurchaseDetails;

public interface PurchaseDetailsService {

	public List<PurchaseDetails> getPurchases();
	public void savePurchase(PurchaseDetails purchase);
	public List<PurchaseDetails> getPurchases(String param);
	public List<PurchaseDetails> getPurchasesByDate();
}
