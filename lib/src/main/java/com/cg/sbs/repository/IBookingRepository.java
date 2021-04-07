package com.cg.sbs.repository;

	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.cg.sbs.entity.Booking;

	public interface IBookingRepository extends JpaRepository<Booking,String > {
		List<Booking> FindbyBooking(String orderid);
	}

