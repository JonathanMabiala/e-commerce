package com.sportyshoes.entity;


import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="shoe")
public class Shoe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="name")
	private String name;

	@Column(name="category")
	private String category;
	
	@Column(name="shoe_size")
	private int shoeSize;
	
	@Column(name="description")
	private String description;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
	private double price;
	
	@Column(name="image")
	private String image;

	@Transient
	private LinkedHashMap<String , String> categoryOptions;
	
	
	public Shoe() {
		
		categoryOptions = new LinkedHashMap<>();
		categoryOptions.put("Men", "Men");
		categoryOptions.put("Women", "Women");
		categoryOptions.put("Kids", "Kids");
		
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getShoeSize() {
		return shoeSize;
	}

	public void setShoeSize(int shoeSize) {
		this.shoeSize = shoeSize;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public LinkedHashMap<String, String> getCategoryOptions() {
		return categoryOptions;
	}



	public void setCategoryOptions(LinkedHashMap<String, String> categoryOptions) {
		this.categoryOptions = categoryOptions;
	}



	@Override
	public String toString() {
		return "Shoe [id=" + id + ", brand=" + brand + ", name=" + name + ", category=" + category + ", shoeSize="
				+ shoeSize + ", description=" + description + ", quantity=" + quantity + ", price=" + price + ", image="
				+ image + ", categoryOptions=" + categoryOptions + "]";
	}

	
	
	
	

}
