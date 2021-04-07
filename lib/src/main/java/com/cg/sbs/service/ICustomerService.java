package com.cg.sbs.service;

import java.util.List;

import com.cg.sbs.entity.Customer;

public interface ICustomerService {

	 Customer addCustomer(Customer customer);
	 Customer updateCustomer(Customer customer);
	 Customer removeCustomer(Customer customer);
	 Customer viewCustomer(String id );
	 List<Customer> viewAllCustomer(String name);
}
