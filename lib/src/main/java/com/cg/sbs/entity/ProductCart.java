package com.cg.sbs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Table(name = " ")
@Entity
public class ProductCart {
	
	@Id
	private String id;
	
	@JoinColumn(name= "cart")
	@ManyToOne
	private Cart cart;
	
	@JoinColumn(name= "product")
	@ManyToOne
	private Products product;
	
	private int quantity;
    public ProductCart() {

	}
    private String id(Cart cart, Products product) {
		return cart.getCartId() + "-" + product.getProductId() + "-ci";
	}
    public ProductCart(Cart cart, Products product, int quantity) {
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
		this.id = id(cart, product);
	}
 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductCart [id=" + id + ", cart=" + cart + ", product=" + product + ", quantity=" + quantity + "]";
	}
}
