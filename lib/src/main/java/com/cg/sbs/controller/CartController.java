package com.cg.sbs.controller;



	import javax.transaction.Transactional;
	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.validation.annotation.Validated;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.cg.sbs.dto.Cart.CartRequest;
	import com.cg.sbs.dto.Cart.ChangeQuantityRequest;
	import com.cg.sbs.dto.Cart.ClearCartRequest;
	import com.cg.sbs.dto.Cart.CartRequest;
	import com.cg.sbs.dto.Cart.CartDetails;
	import com.cg.sbs.entity.Cart;
	import com.cg.sbs.entity.Item;
	import com.cg.sbs.service.ICartService;
	import com.cg.sbs.service.IItemService;

	import com.cg.sbs.util.CartUtil;

	@Validated
	@RequestMapping("/cart")
	@RestController


	public class CartController {







		@Autowired
		private ICartService cartService;

		@Autowired
		private CartUtil cartUtil;

		@Autowired
		private IItemService itemService;

		@PostMapping("/additemtocart")
		public CartDetails addItemToCart(@RequestBody @Valid CartRequest request) {
			Cart cart = cartService.findCartByCustomer(request.getCustomerId());
			Item item = itemService.viewItem(request.getItemId());
			return cartUtil.toCartDetails(cartService.addItemToCart(cart, item));
		}

		@PutMapping("/increasequantity")
		public CartDetails increaseQuantity(@RequestBody @Valid ChangeQuantityRequest request) {
			Cart cart = cartService.findCartByCustomer(request.getCustomerId());
			Item item = itemService.viewItem(request.getItemId());
			return cartUtil.toCartDetails(cartService.increaseQuantity(cart, item, request.getQuantity()));
		}

		@PutMapping("/reducequantity")
		public CartDetails reduceQuantity(@RequestBody @Valid ChangeQuantityRequest request) {
			Cart cart = cartService.findCartByCustomer(request.getCustomerId());
			Item item = itemService.viewItem(request.getItemId());
			return cartUtil.toCartDetails(cartService.reduceQuantity(cart, item, request.getQuantity()));
		}

		@DeleteMapping("/removeitem")
		public CartDetails removeItem(@RequestBody @Valid CartRequest request) {
			Cart cart = cartService.findCartByCustomer(request.getCustomerId());
			Item item = itemService.viewItem(request.getItemId());
			return cartUtil.toCartDetails(cartService.removeItem(cart, item));
		}

		@Transactional
		@DeleteMapping("/clear")
		public CartDetails clearCart(@RequestBody @Valid ClearCartRequest request) {
			Cart cart = cartService.findCartByCustomer(request.getCustomerId());
			return cartUtil.toCartDetails(cartService.clearCart(cart));
		}

		@GetMapping("/find")
		publicCartDetails findCart(@RequestBody @Valid FindCartRequest request) {
			return cartUtil.toCartDetails(cartService.findFoodCartByCustomer(request.getCustomerId()));

		}

	}



