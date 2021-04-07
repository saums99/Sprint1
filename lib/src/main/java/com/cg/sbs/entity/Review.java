package com.cg.sbs.entity;

public class Review {

		private Products productId;
		private Products productName;
		private String productReview;
		private int productRating;
		public Products getProductId() {
			return productId;
		}
		public void setProductId(Products productId) {
			this.productId = productId;
		}
		public Products getProductName() {
			return productName;
		}
		public void setProductName(Products productName) {
			this.productName = productName;
		}
		public int getProductRating() {
			return productRating;
		}
		public void setProductRating(int productRating) {
			this.productRating = productRating;
		}
		
		public String getProductReview() {
			return productReview;
		}
		public void setProductReview(String productReview) {
			this.productReview = productReview;
		}
}
	
	


