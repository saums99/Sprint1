package com.cg.sbs.service;
import com.cg.sbs.entity.Cart;
import com.cg.sbs.entity.Products;

public interface ICartService {


	 Cart addItemToCart(Cart cart,Products product);
	 Cart increaseQuantity(Cart cart,Products product,int quantity);
	 Cart reduceQuantity(Cart cart,Products product,int quantity);
	 Cart removeItem(Cart cart,Products product);
	
}