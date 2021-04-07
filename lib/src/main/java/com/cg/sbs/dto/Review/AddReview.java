package com.cg.sbs.dto.Review;
import com.cg.sbs.entity.Products;

public class AddReview {
	
		public class Review {
		private Products productId;
		private Products productName;
		private String productReview;
		private int productRating;
		public Review()
		{
			
		}
		public int getProductRating() {
			return productRating;
		}
		public void setProductRating(int productRating) {
			this.productRating = productRating;
		}
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
		public String getProductReview() {
			return productReview;
		}
		public void setProductReview(String productReview) {
			this.productReview = productReview;
		}
		
		
	}

}
