package com.cg.sbs.controller;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sbs.entity.Review;
import com.cg.sbs.service.*;

@Validated
@RequestMapping("/reviews")
@RestController
public class IReviewController {
	
	public class ReviewController {
		@Autowired
		private Review review;
		@Autowired
		private ReviewServiceImpl revservice;
		
		@PostMapping("/add")
		public Review addReview(@RequestBody @Valid Review request)
		{
			Review rev=revservice.viewReview(request.getProductReview());
			rev.setProductId(rev.getProductId());
			rev.setProductName(rev.getProductName());
			rev.setProductRating(rev.getProductRating());
			rev.setProductReview(rev.getProductReview());
			return revservice.viewReview(revservice.addReview(rev));
		}
		@PostMapping("/update")
		public Review updateReview(@RequestBody @Valid Review request)
		{
			Review rev=revservice.viewReview(request.getProductReview());
			rev.setProductId(rev.getProductId());
			rev.setProductName(rev.getProductName());
			rev.setProductRating(rev.getProductRating());
			rev.setProductReview(rev.getProductReview());
			return revservice.viewReview(revservice.addReview(rev));
		}
		@GetMapping("/view/{id}")
		public Review viewItem(@PathVariable @NotBlank String id) {
			return (revservice.viewReview(id));
		}

	}
}
