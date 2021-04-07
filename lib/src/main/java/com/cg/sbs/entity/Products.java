package com.cg.sbs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Products {
	
	@Id
	private String productId;
	private String productName;
	
	
	
	private double cost;
	private int quantity;
	
	private boolean availability;
	
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", cost=" + cost + ", quantity=" + quantity + ", availability=" + availability + "]";
	}
	
	

}
