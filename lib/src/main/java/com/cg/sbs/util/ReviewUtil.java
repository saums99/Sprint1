package com.cg.sbs.util;

import com.cg.sbs.entity.Review;

public class ReviewUtil {
	
	public Review getReview() {
			return new Review();
		}
		public Review toReviewDetails(Review review) {
			Review id = new Review();
			id.setProductId(review.getProductId());
			id.setProductName(review.getProductName());
			id.setProductRating(review.getProductRating());
			id.setProductReview(review.getProductReview());
			return id;
		}
	}


