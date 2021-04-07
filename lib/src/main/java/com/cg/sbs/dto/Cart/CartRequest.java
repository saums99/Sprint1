package com.cg.sbs.dto.Cart;

	import javax.validation.constraints.NotBlank;

	public class CartRequest {


		@NotBlank
		private String customerId;
		@NotBlank
		private String itemId;

		public CartRequest() {

		}

		public String getCustomerId() {
			return customerId;
		}

		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}

		public String getItemId() {
			return itemId;
		}

		public void setItemId(String itemId) {
			this.itemId = itemId;
		}

	}



