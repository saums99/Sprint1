package com.cg.sbs.controller;

	import java.util.List;

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

	import com.cg.sbs.dto.order.AddOrderRequest;
	import com.cg.sbs.dto.order.ViewOrDeleteOrderRequest;
	import com.cg.sbs.dto.order.OrderDetailsResponse;
	import com.cg.sbs.dto.order.UpdateOrderRequest;
	import com.cg.sbs.dto.order.ViewAllByCustomerIdRequest;
	import com.cg.sbs.entity.Customer;
	import com.cg.sbs.entity.StationaryCart;
	import com.cg.sbs.entity.OrderDetails;
	import com.cg.sbs.service.CartServiceImpl;
	import com.cg.sbs.service.CustomerServiceImpl;
	import com.cg.sbs.service.IOrderService;
	import com.cg.sbs.util.OrderUtil;

	@Validated
	@RequestMapping("/orders")
	@RestController
	public class OrderController {

		@Autowired
		private IOrderService orderService;

		@Autowired
		private CartServiceImpl cartService;

		@Autowired
		private CustomerServiceImpl customerService;

		@Autowired
		private OrderUtil orderUtil;

		@GetMapping("/view")
		public OrderDetailsResponse viewOrder(@RequestBody @Valid ViewOrDeleteOrderRequest request) {
			return orderUtil.toOrderDetailsResponse(orderService.viewOrder(request.getOrderId()));
		}

		@GetMapping("/viewbycustomerid")
		public List<OrderDetailsResponse> viewAllOrderByCustomer(@RequestBody @Valid ViewAllByCustomerIdRequest request) {

			Customer customer = customerService.viewCustomer(request.getCustomerId());
			return orderUtil.toOrderDetailsResponseList(orderService.viewAllOrders(customer));
		}

	}



