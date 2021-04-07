package com.cg.sbs.repository;
//Repository
	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.cg.sbs.entity.Review;
	public interface IReviewRepository extends JpaRepository<Review, String> {
		List<Review> findByReviewName(String reviewName);

		boolean existsById(long reviewId);
	}

