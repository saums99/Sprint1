package com.cg.sbs.service;

	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.cg.sbs.*;
import com.cg.sbs.entity.Booking;
import com.cg.sbs.exceptions.*;
	import com.cg.sbs.exceptions.ProductNotFoundException;
	import com.cg.sbs.exceptions.OrderNotFoundException;
	import com.cg.sbs.repository.IBookingRepository;

	@Service
	public class BookingServiceImpl implements IBookingService{

		@Autowired
		private IBookingRepository bookingrepo;
			

		public void validateBooking(Booking booking) //throws InvalidProductException
		{
			if (booking == null) {
				throw new InvalidProductException("Booking can't be null");
			}
		}
				
		@Override
		public Booking updateBooking(Booking booking) {
			try {
				validateBooking(booking);
			} catch (InvalidProductException e) {
				e.printStackTrace();
			}
			try {
				
			String s=Integer.toString((booking.getOrderId().getOrderId()));
			boolean exist = bookingrepo.existsById(s);
			if (!exist) {
				throw new ProductNotFoundException("Booking with id not present=" + booking.getOrderId());
			}
			Booking updateBooking = bookingrepo.save(booking);
			return updateBooking;
			}
			catch(ProductNotFoundException e)
			{
				e.printStackTrace();
				return null;
			}
		}

		@Override
		public Booking searchBooking(String id){
			Optional<Booking> searchbooking = bookingrepo.findById(id);
			if (!searchbooking.isPresent()) {
				throw new OrderNotFoundException("Booking id is not present=" + id);
			}
			return searchbooking.get();
			}
			
		@Override
		public Booking confirmBooking(Booking booking) {
			validateBooking(booking);
			Booking savebooking = bookingrepo.save(booking);
			booking.setOrderStatus("Booking Confirmed Successfully");
			return savebooking;
			}
			
		@Override
		public Booking cancelBooking(Booking booking) {
			validateBooking(booking);
			int orderId = booking.getOrderId().getOrderId();
			String oid=Integer.toString(orderId); 
			boolean exist = bookingrepo.existsById(oid);
			if (!exist) {
				throw new OrderNotFoundException("Order doesn't exist for id =" + booking.getOrderId().getOrderId());
			}
			bookingrepo.delete(booking);
			
			return booking;
		}

		public Booking confirmBooking(int orderId) {
			// TODO Auto-generated method stub
			return null;
		}

		public Booking updateBooking(int orderId) {
			// TODO Auto-generated method stub
			return null;
		}

		public Booking cancelBooking(int orderId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Booking updateBooking(Booking booking) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Booking searchBooking(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Booking confirmBooking(Booking booking) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Booking cancelBooking(Booking booking) {
			// TODO Auto-generated method stub
			return null;
		}

		
		
			
		}



