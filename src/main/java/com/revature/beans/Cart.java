package com.revature.beans;

import java.util.List;

	public class Cart {
		
		private int cartId;
		private List<CartItem> cartItems;
		private double grandTotal;
		
		
		
		
		public Cart() {
			super();
		}
		
		public Cart(int cartId, List<CartItem> cartItems, double grandTotal) {
			super();
			this.cartId = cartId;
			this.cartItems = cartItems;
			this.grandTotal = grandTotal;
		}
		public int getCartId() {
			return cartId;
		}
		public void setCartId(int cartId) {
			this.cartId = cartId;
		}
		public List<CartItem> getCartItems() {
			return cartItems;
		}
		public void setCartItems(List<CartItem> cartItems) {
			this.cartItems = cartItems;
		}
		public double getGrandTotal() {
			return grandTotal;
		}
		public void setGrandTotal(double grandTotal) {
			this.grandTotal = grandTotal;
		}
		@Override
		public String toString() {
			return "Cart [cartId=" + cartId + ", cartItems=" + cartItems + ", grandTotal=" + grandTotal + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + cartId;
			result = prime * result + ((cartItems == null) ? 0 : cartItems.hashCode());
			long temp;
			temp = Double.doubleToLongBits(grandTotal);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cart other = (Cart) obj;
			if (cartId != other.cartId)
				return false;
			if (cartItems == null) {
				if (other.cartItems != null)
					return false;
			} else if (!cartItems.equals(other.cartItems))
				return false;
			if (Double.doubleToLongBits(grandTotal) != Double.doubleToLongBits(other.grandTotal))
				return false;
			return true;
		}
		
		
		

	}
