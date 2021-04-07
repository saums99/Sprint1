package com.cg.sbs.util;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Random;

	import org.springframework.stereotype.Component;

	import com.cg.sbs.dto.Customers.CustomerDetails;
	import com.cg.sbs.entity.Customer;

	@Component
	public class CustomerUtil {
		public Customer getCustomer() {
			return new Customer();
		}

		
		public CustomerDetails customerDetails(Customer customer) {
			
			CustomerDetails details= new CustomerDetails();
		    details.setFirstName(customer.getFirstName());
		    details.setLastName(customer.getLastName());
		    
		    return details;
		}
		public List<CustomerDetails> customerDetailsList(List<Customer> list){
			List<CustomerDetails> cd=new ArrayList<>();
			for(Customer customer:list) {
				cd.add(customerDetails(customer));
			}
			return cd;
		}
	}



