package com.cg.sbs.repository;



	import org.springframework.data.jpa.repository.JpaRepository;

	import com.cg.sbs.entity.Customer;

	public interface ICustomerRepository extends JpaRepository<Customer, String> {
		Customer findCustomerByCustomerId(String customerId);
	}


