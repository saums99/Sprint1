package com.cg.sbs.repository;

	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;

	import com.cg.entity.CartItem;
	import com.cg.entity.FoodCart;
	import com.cg.entity.Product;

	public interface ICartItemRepository extends JpaRepository<CartItem,String>{








	    void deleteByCart(Cart cart);
	    
	    List<CartItem> findByCart(Cart cart);

	    @Query("select item from CartItem where cart=:cart")
	    List<Item>findItemsByCart(@Param("cart") Cart cart);

	}


