package com.cg.sbs.dto.Booking;

	import com.cg.sbs.entity.Booking;
	import com.cg.sbs.entity.OrderDetails;

	public class ConfirmBooking {

			private OrderDetails orderId;
			private String orderStatus;
			public OrderDetails getOrderId() {
				return orderId;
			}
			public void setOrderId(OrderDetails orderId) {
				this.orderId = orderId;
			}
			public String getOrderStatus() {
				return orderStatus;
			}
			public void setOrderStatus(String orderStatus) {
				this.orderStatus = orderStatus;
			}
			
			
			
		}



