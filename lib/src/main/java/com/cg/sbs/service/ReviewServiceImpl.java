package com.cg.sbs.service;

	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;


	import com.cg.sbs.entity.Review;
	import com.cg.sbs.exceptions.InvalidProductException;
	import com.cg.sbs.exceptions.ProductNotFoundException;
import com.cg.sbs.repository.IReviewRepository;

	public class ReviewServiceImpl implements IReviewService {
		@Autowired
		private IReviewRepository reviewRepository;

		@Override
		public Review addReview(Review review) throws InvalidProductException {
			validateReview(review);
			Review saved = reviewRepository.save(review);
			return saved;
		}
		void validateReview(Review review) throws InvalidProductException {
			if (review == null) {
				throw new InvalidProductException("Review can't be null");
			}

		}

		@Override
		public Review updateReview(Review review) {
			try {
				validateReview(review);
			} catch (InvalidProductException e) {
				e.printStackTrace();
			}
			try {
			boolean exists = reviewRepository.existsById(review.getProductId().getProductId());
			if (!exists) {
				throw new ProductNotFoundException("Review with id not present=" + review.getProductId());
			}
			Review updateReview = reviewRepository.save(review);
			return updateReview;
			}
			catch(ProductNotFoundException e)
			{
				e.printStackTrace();
				return null;
			}
		}
		@Override
		public Review viewReview(String id) throws ProductNotFoundException {
			Optional<Review> viewreview = reviewRepository.findById(id);
			if (!viewreview.isPresent()) {
				throw new ProductNotFoundException("Review with id not present=" + id);
			}
			return viewreview.get();
		}

	}


