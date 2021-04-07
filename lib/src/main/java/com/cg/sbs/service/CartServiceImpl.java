package com.cg.sbs.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.sbs.entity.Cart;
import com.cg.sbs.exceptions.InvalidCartException;
import com.cg.sbs.repository.ICartItemRepository;
import com.cg.sbs.repository.ICartRepository;

@Service
public class CartServiceImp implements ICartService {





	@Autowired
	private ICartRepository cartRepository;

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private ICartItemRepository cartItemRepository;

	

	@Override
	public Cart addItemToCart(Cart cart, Item item) {
		validateCart(cart);
		increaseQuantity(cart, item, 1);
		return cart;
	}

	
	@Override
	public Cart increaseQuantity(Cart cart, Item item, int quantity) {
		validateCart(cart);
		String cartItemId = CartItem.id(cart, item);
		Optional<CartItem> optional = cartItemRepository.findById(cartItemId);
		if (!optional.isPresent()) {
			CartItem cartItem = new CartItem(cart, item, quantity);
			cartItemRepository.save(cartItem);
			return cart;
		}
		CartItem cartItem = optional.get();
		int existingQuantity = cartItem.getQuantity();
		int updatedQuantity = existingQuantity + quantity;
		cartItem.setQuantity(updatedQuantity);
		cartItemRepository.save(cartItem);
		return cart;
	}

	

	@Override
	public Cart reduceQuantity(Cart cart, Item item, int quantity) {
		validateCart(cart);
		String cartItemId = CartItem.id(cart, item);
		Optional<CartItem> optional = cartItemRepository.findById(cartItemId);
		if (!optional.isPresent()) {
			throw new InvalidCartException("item not found in cart");
		}
		CartItem cartItem = optional.get();
		int existingQuantity = cartItem.getQuantity();
		int updatedQuantity = existingQuantity - quantity;
		if (updatedQuantity <= 0) {
			cartItemRepository.delete(cartItem);
			return cart;
		}
		cartItem.setQuantity(updatedQuantity);
		cartItemRepository.save(cartItem);
		return cart;
	}

	
	@Override
	public Cart removeItem(Cart cart, Item item) {
		validateCart(cart);
		String cartItemId = CartItem.id(cart, item);
		cartItemRepository.deleteById(cartItemId);
		return cart;
	}

	
	@Override
	public Cart clearCart(Cart cart) {
		validateCart(cart);
		cartItemRepository.deleteByCart(cart);
		return cart;
	}

	
	@Override
	public Cart findCartByCustomer(String customerId) {
		Customer customer = customerService.viewCustomer(customerId);
		Cart cart = cartRepository.findCartByCustomer(customer);
		return cart;
	}

	public void validateCart(Cart cart) {
		if (cart == null) {
			throw new InvalidCartException("Cart cannot be null");
		}
	}

}
