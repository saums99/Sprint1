package com.cg.sbs.repository;

	import java.time.LocalDate;
	import java.util.List;

	import javax.transaction.Transactional;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Modifying;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;
	import org.springframework.stereotype.Repository;

	import com.cg.sbs.entity.Track;


	@Repository
	public interface TrackRepository extends JpaRepository<Track, Long>{
		
		@Query(value  = 
			    " select * from track where ship_date >= :startDate AND ship_date <= :endDate", nativeQuery = true)
			public List<Track> getShipmentsInfo(
			    @Param("startDate") LocalDate startDate, 
			    @Param("endDate") LocalDate endDate);
		
		@Modifying
		@Transactional
		@Query(value = "update track set status = 'DELIVERED' where order_id = :orderId", nativeQuery = true)
		public void setDeliveryStatus(@Param("orderId") Long orderId);
		
		@Query(value = 
				"select * from track  where ship_date > now() - interval '1 week'", nativeQuery = true)
			List<Track> getTrackInfoWeekly();
		
		@Query(value = 
				"select * from track  where ship_date > now() - interval '4 week'", nativeQuery = true)
			List<Track> getTrackInfoMonthly();

	}


