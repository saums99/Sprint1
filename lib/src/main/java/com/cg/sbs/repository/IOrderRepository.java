package com.cg.sbs.repository;

	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.cg.sbs.entity.Cart;
	import com.cg.sbs.entity.OrderDetails;

	public interface IOrderRepository extends JpaRepository<OrderDetails, Integer> {

		OrderDetails findOrderDetailsByCart(Cart cart);

		List<OrderDetails> findByCart(Cart cart);

	}

