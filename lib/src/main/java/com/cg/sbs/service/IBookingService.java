package com.cg.sbs.service;

	import com.cg.sbs.entity.Booking;
	import com.cg.sbs.exceptions.OrderNotFoundException;
	import com.cg.sbs.exceptions.ProductNotFoundException;

	public interface IBookingService {

		Booking updateBooking(Booking booking);

		Booking searchBooking(String id);

		Booking confirmBooking(Booking booking);

		Booking cancelBooking(Booking booking);

	}



