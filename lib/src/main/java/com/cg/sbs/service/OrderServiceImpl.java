package com.cg.sbs.service;

	import java.time.LocalDateTime;
	import java.util.List;
	import java.util.Optional;

	import javax.transaction.Transactional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	
	import com.cg.sbs.entity.Customer;
	import com.cg.sbs.entity.Cart;
	import com.cg.sbs.entity.Products;
	import com.cg.sbs.entity.OrderDetails;

	import com.cg.sbs.exceptions.AddOrderException;
	import com.cg.sbs.exceptions.InvalidOrderException;
	import com.cg.sbs.exceptions.OrderNotFoundException;
	

	@Service
	public class OrderServiceImpl implements IOrderService {

		@Autowired
		private IOrderRepository orderRepository;

		@Autowired
		private ICartService cartService;

		
		public LocalDateTime currentDateTime() {
			return LocalDateTime.now();
		}

		
		@Override
		public OrderDetails viewOrder(int orderId) {
			Optional<OrderDetails> optionOrderDetail = orderRepository.findById(orderId);
			if (!optionOrderDetail.isPresent()) {
				throw new OrderNotFoundException("order not found for id=" + orderId);
			}
			return optionOrderDetail.get();
		}

		

		@Override
		public List<OrderDetails> viewAllOrders(Customer customer) {
			Cart cart = cartRepository.findsCartByCustomer(customer);
			List<OrderDetails> orderList = orderRepository.findByCart(cart);
			return orderList;

		}

		public void validateOrder(OrderDetails order) {
			if (order == null) {
				throw new InvalidOrderException("OrderDetail Cannot be null");
			}

		}

	}


