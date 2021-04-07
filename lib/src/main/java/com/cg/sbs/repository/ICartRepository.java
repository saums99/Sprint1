package com.cg.sbs.repository;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.cg.sbs.entity.Customer;
	import com.cg.sbs.entity.Cart;


	public interface ICartRepository extends JpaRepository<Cart, String>{





		Cart findCartByCustomer(Customer customer);

	}



