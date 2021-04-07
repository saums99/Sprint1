package com.cg.sbs.service;

	import java.util.List;

	import com.cg.sbs.entity.Customer;
	import com.cg.sbs.entity.OrderDetails;

	public interface IOrderService {

		 OrderDetails viewOrder(int orderId);
		 List<OrderDetails> viewAllOrders(Customer customer);
		
	}



