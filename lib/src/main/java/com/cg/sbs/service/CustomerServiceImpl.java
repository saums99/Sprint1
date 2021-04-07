package com.cg.sbs.service;


	import java.util.List;
	import java.util.Optional;
	import java.util.Random;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.cg.sbs.entity.Address;
	import com.cg.sbs.entity.Customer;
	import com.cg.sbs.exceptions.CustomerNotFoundException;
	import com.cg.sbs.exceptions.InvalidCustomerAddressException;
	import com.cg.sbs.exceptions.InvalidCustomerException;
	import com.cg.sbs.exceptions.InvalidCustomerPhoneNumberException;
	import com.cg.sbs.repository.IAddressRepository;
	import com.cg.sbs.repository.ICustomerRepository;
	import com.cg.sbs.util.StationeryBookingSystemUtil;


	@Service
	public class CustomerServiceImpl implements ICustomerService {
		@Autowired
		private ICustomerRepository customerRepository;

		@Autowired
		private IAddressRepository addressRepository;

		@Autowired
		private StationeryBookingSystemUtil cartUtil;

		public String generateId() {
			StringBuilder builder = new StringBuilder();
			Random random = new Random();
			for (int i = 0; i < 10; i++) {
				int randomNum = random.nextInt(10);
				builder.append(randomNum);
			}
			return builder.toString();
		}

		
		@Override
		public Customer addCustomer(Customer customer) {
			validateCustomer(customer);
			validatePhone(customer.getMobileNumber());
			Address address = customer.getAddress();
			addressRepository.save(address);
			customer.setCustomerId(generateId());
			Customer saved = customerRepository.save(customer);
			StationeryBookingSystem cart = cartUtil.getStationeryBookingSystem();
			cart.setCartId(generateId());
			cart.setCustomer(saved);
			cartRepository.save(cart);
			return saved;
		}

		

		@Override
		public Customer updateCustomer(Customer customer) {
			validateCustomer(customer);
			String customerId = customer.getCustomerId();
			boolean exist = customerRepository.existsById(customerId);
			if (!exist) {
				throw new CustomerNotFoundException("Customer doesn't exist for id =" + customer.getCustomerId());
			}

			Customer updateCustomer = customerRepository.save(customer);

			return updateCustomer;
		}

		
		@Override
		public Customer removeCustomer(Customer customer) {
			validateCustomer(customer);
			String customerId = customer.getCustomerId();
			boolean exist = customerRepository.existsById(customerId);
			if (!exist) {
				throw new CustomerNotFoundException("Customer doesn't exist for id =" + customer.getCustomerId());
			}
			StationeryBookingSystem cart = cartRepository.findStationeryBookingSystemByCustomer(customer);
			List<CartItem> cartItems = cartItemRepository.findByCart(cart);
			for (CartItem cartItem : cartItems) {
				cartItemRepository.deleteById(cartItem.getId());
			}

			cartRepository.delete(cart);
			customerRepository.delete(customer);
			return customer;
		}

		
		@Override
		public Customer viewCustomer(String id) {
			Optional<Customer> viewCustomer = customerRepository.findById(id);
			if (!viewCustomer.isPresent()) {
				throw new CustomerNotFoundException("Customer doesn't exist for id =" + id);
			}
			return viewCustomer.get();
		}

		

		@Override
		public List<Customer> viewAllCustomer(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		public void validateCustomer(Customer customer) {
			if (customer == null) {
				throw new InvalidCustomerException("Customer cannot be null");
			}

		}

		public void validatePhone(String phoneNumber) {
			if (phoneNumber == null) {
				throw new InvalidCustomerPhoneNumberException("Customer Phone Number cannot be null");
			}
		}

		public void validateAddress(String address) {
			if (address == null) {
				throw new InvalidCustomerAddressException("Customer Address cannot be null");
			}
		}
		
	}


