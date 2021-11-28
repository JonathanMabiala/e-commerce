package com.sportyshoes.service;

import java.util.List;

import com.sportyshoes.entity.Shoe;

public interface ShoeService {

	public List<Shoe> getShoes();

	public void addShoe(Shoe theShoe);

	public Shoe getShoeById(int theId);

	public void deleteShoe(int theId);

	public List<Shoe> getByCategoryShoes(String string);
}
