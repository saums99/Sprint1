package com.cg.sbs.dto.Cart;

	import java.util.List;
	public class CartDetails {


		private String customerId;
		private String firstName;
		private List<CartItemDetails> items;

		public CartDetails() {

		}

		public String getCustomerId() {
			return customerId;
		}

		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public List<CartItemDetails> getItems() {
			return items;
		}

		public void setItems(List<CartItemDetails> items) {
			this.items = items;
		}

	}


