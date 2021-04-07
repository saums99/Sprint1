package com.cg.sbs.util;


	import java.util.ArrayList;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;

	import com.cg.sbs.entity.Products;
	import com.cg.sbs.entity.OrderDetails;

	@Component
	public class OrderUtil {

		public OrderDetails getOrderDeatils() {
			return new OrderDetails();
		}

		public OrderDetailsResponse toOrderDetailsResponse(OrderDetails order) {
			OrderDetailsResponse odr = new OrderDetailsResponse();
			List<String> itemName = new ArrayList<>();
			odr.setCustomerId(order.getCart().getCustomer().getCustomerId());
			odr.setFirstName(order.getCart().getCustomer().getFirstName());
			odr.setOrderStatus(order.getOrderStatus());
			
			for (Products product : order.getProducts()) {
				productName.add(product.getproductName());
			}
			odr.setItemName(itemName);
			return odr;
		}

		public List<OrderDetailsResponse> toOrderDetailsResponseList(List<OrderDetails> orders) {
			List<OrderDetailsResponse> OrderDetailsResponses = new ArrayList<>();
			for (OrderDetails order : orders) {
				OrderDetailsResponses.add(toOrderDetailsResponse(order));
			}
			return OrderDetailsResponses;
		}

	}


