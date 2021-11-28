package com.sportyshoes.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="purchase_details")
public class PurchaseDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="shoe_brand")
	private String shoeBrand;
	
	@Column(name="shoe_name")
	private String shoeName;
	
	@Column(name="unit")
	private int unit;
	
	@Column(name="email")
	private String email;
	
	@Column(name="price")
	private double price;
	
	@Column(name="category")
	private String category;
	
	@Column(name="date_added")
	private java.time.LocalDateTime date;
	
	public PurchaseDetails() {
		super();
	}
	
	

	public PurchaseDetails(String username, String shoeBrand, String shoeName, int unit, String email, double price,String category,
			LocalDateTime date) {
		super();
		this.username = username;
		this.shoeBrand = shoeBrand;
		this.shoeName = shoeName;
		this.unit = unit;
		this.email = email;
		this.price = price;
		this.category = category;
		this.date = date;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getShoeBrand() {
		return shoeBrand;
	}

	public void setShoeBrand(String shoeBrand) {
		this.shoeBrand = shoeBrand;
	}

	public String getShoeName() {
		return shoeName;
	}

	public void setShoeName(String shoeName) {
		this.shoeName = shoeName;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	@Override
	public String toString() {
		return "PurchaseDetails [id=" + id + ", username=" + username + ", shoeBrand=" + shoeBrand + ", shoeName="
				+ shoeName + ", unit=" + unit + ", email=" + email + ", price=" + price + ", category=" + category
				+ ", date=" + date + "]";
	}
	
	
	
	
	
}
