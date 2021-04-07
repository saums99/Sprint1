package com.cg.sbs.dto.Cart;

	public class CartItemDetails {



		private String itemId;
		private String itemName;
		private String categoryName;
//		private int quantity;
		private double cost;

		public CartItemDetails() {

		}

		public String getItemId() {
			return itemId;
		}

		public void setItemId(String itemId) {
			this.itemId = itemId;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

//		public int getQuantity() {
//			return quantity;
//		}
	//
//		public void setQuantity(int quantity) {
//			this.quantity = quantity;
//		}

		public double getCost() {
			return cost;
		}

		public void setCost(double cost) {
			this.cost = cost;
		}

	}


