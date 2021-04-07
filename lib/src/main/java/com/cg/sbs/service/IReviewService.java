package com.cg.sbs.service;

import com.cg.sbs.entity.Review;
import com.cg.sbs.exceptions.InvalidProductException;
import com.cg.sbs.exceptions.ProductNotFoundException;

public interface IReviewService {
		Review viewReview(String id) throws ProductNotFoundException;
		Review addReview(Review review) throws InvalidProductException;
		Review updateReview(Review review);
		//Review viewReview(Review review) throws ProductNotFoundException; 
	}


