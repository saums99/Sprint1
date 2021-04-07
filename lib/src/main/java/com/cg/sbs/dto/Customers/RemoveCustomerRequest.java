package com.cg.sbs.dto.Customers;



	import javax.validation.constraints.NotBlank;

	public class RemoveCustomerRequest {

		@NotBlank
		private String id;

		public RemoveCustomerRequest() {
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

	}

