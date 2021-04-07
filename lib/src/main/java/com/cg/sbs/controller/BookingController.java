package com.cg.sbs.controller;


	import javax.validation.Valid;
	import javax.validation.constraints.NotBlank;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.validation.annotation.Validated;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.cg.sbs.dto.CancelBooking;
	import com.cg.sbs.dto.ConfirmBooking;
	import com.cg.sbs.dto.SearchBooking;
	import com.cg.sbs.dto.UpdateBooking;
	import com.cg.sbs.entity.Booking;
	import com.cg.sbs.service.*;

	@Validated
	@RestController
	@RequestMapping("/bookings")
	public class BookingController {

		
		@Autowired
		private Booking booking;
		@Autowired 
		private BookingServiceImpl bookingservice;
				
			@PostMapping("/confirm")
			public Booking confirmBooking(@RequestBody @Valid ConfirmBooking request)
			{
				Booking book=bookingservice.confirmBooking(request.getOrderId().getOrderId());
				book.setOrderId(book.getOrderId());
				book.setOrderStatus(book.getOrderStatus());
				return bookingservice.confirmBooking(bookingservice.confirmBooking(book));//
			}
			@PutMapping("/update")
			public Booking updateBooking(@RequestBody @Valid UpdateBooking request)
			{
				Booking book=bookingservice.updateBooking(request.getOrderId().getOrderId());
				book.setOrderId(book.getOrderId());
				book.setOrderStatus(book.getOrderStatus());
				return bookingservice.updateBooking(bookingservice.updateBooking(book));//
			}
			@DeleteMapping("/cancel")
			public Booking cancelBooking(@RequestBody @Valid CancelBooking request) {
				Booking book = bookingservice.cancelBooking(request.getOrderId().getOrderId());
				return bookingservice.cancelBooking(bookingservice.cancelBooking(book));//
			}
			@GetMapping("/search")
			public Booking searchBooking(@RequestBody @Valid SearchBooking request) {
				String s=Integer.toString(request.getOrderId().getOrderId());
				Booking book = bookingservice.searchBooking(s);
				return bookingservice.searchBooking(bookingservice.searchBooking(book));//	
			}

		}


