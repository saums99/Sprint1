package com.cg.sbs.entity;

public class Track {
	
	    private String TrackStatus;
		private OrderDetails orderId;
		public OrderDetails getOrderId() {
			return orderId;
		}
		public void setOrderId(OrderDetails orderId) {
			this.orderId = orderId;
		}
		
		public String getTrackStatus() {
			return TrackStatus;
		}
		public void setTrackStatus(String trackStatus) {
			TrackStatus = trackStatus;
		}
}		
		

