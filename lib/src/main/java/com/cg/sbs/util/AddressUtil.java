package com.cg.sbs.util;

	import java.util.Random;

	import org.springframework.stereotype.Component;

	import com.cg.sbs.entity.Address;

	@Component
	public class AddressUtil {
		public Address getAddress() {
			return new Address();
		}
	  
		public String generateId() {
			StringBuilder builder= new StringBuilder();
			Random random= new Random();
			for(int i=0; i<10; i++) {
				int randomNum=random.nextInt(10);
				builder.append(randomNum);
			}
			return builder.toString();
		}
	}


