package com.cg.sbs.util;

	import java.util.ArrayList;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import java.util.Random;


	import org.springframework.stereotype.Component;

	import com.cg.sbs.dto.Cart.CartDetails;
	import com.cg.sbs.dto.Cart.CartItemDetails;
	import com.cg.sbs.entity.Cart;
	import com.cg.sbs.entity.Products;
	import com.cg.sbs.service.CartServiceImp;
	import com.cg.sbs.service.ItemServiceImp;

	@Component

	public class CartUtil {


		
		@Autowired
		private CartServiceImp cartService;
		
		@Autowired
		private ItemServiceImp itemService;
		
		public Cart getCart() {
			return new Cart();
		}
		
		public CartDetails toCartDetails(Cart cart)
		{
			CartDetails fcd=new CartDetails();
			fcd.setCustomerId(cart.getCustomer().getCustomerId());
			fcd.setFirstName(cart.getCustomer().getFirstName());
		   Cart c=cartService.findCartByCustomer(cart.getCustomer().getCustomerId());
			List<Item>items=itemService.viewAllItemsByCart(c);	
			fcd.setItems(toFoodCartItemDeatilList(items));
			return fcd;
		}
		
		public CartItemDetails to CartItemDeatil(Item item)
		{
			CartItemDetails foodItem=new CartItemDetails();
			foodItem.setItemId(item.getItemId());
			foodItem.setItemName(item.getItemName());
//			foodItem.setQuantity(item.getQuantity());
			foodItem.setCost(item.getCost());
			foodItem.setCategoryName(item.getCategory().getCategoryName());
			return Item;
		}
		
		public ListC<artItemDetails> toCartItemDeatilList(List<Item>items)
		{
			List<CartItemDetails> list=new ArrayList<>();
			for(Item item:items)
			{
				list.add(toCartItemDeatil(item));
			}
			return list;
		}
		public String generateId() {
			StringBuilder builder= new StringBuilder();
			Random random= new Random();
			for(int i=0; i<10; i++) {
				int randomNum=random.nextInt(10);
				builder.append(randomNum);
			}
			return builder.toString();
		}
	}



