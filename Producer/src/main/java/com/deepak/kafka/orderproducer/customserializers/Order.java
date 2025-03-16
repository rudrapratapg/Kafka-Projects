package com.deepak.kafka.orderproducer.customserializers;

public class Order {
	private String customerName; //optional
	private final String productName; //mandatory
	private final int quantity; //mandatory
	public String getCustomerName() {
		return customerName;
	}
	public String getProductName() {
		return productName;
	}
	public int getQuantity() {
		return quantity;
	}
	@Override
	public String toString() {
		return "Order [customerName=" + customerName + ", productName=" + productName + ", quantity=" + quantity + "]";
	}
	
	private Order(Builder builder) {
		this.customerName = builder.customerName;
		this.productName = builder.productName;
		this.quantity = builder.quantity;
	}
	
	public static class Builder {
		private String customerName;
		private final String productName;
		private final int quantity;
		
		public Builder(String productname, int quantity) {
			this.productName = productname;
			this.quantity = quantity;
		}
		
		public Builder setCustomerName(String customerName) {
			this.customerName = customerName;
			return this;
		}
//		We have made them mandatory (final) so we won't be able to set values using setter method		
//		public Builder setProductName(String productName) {
//			this.productName = productName;
//			return this;
//		}
//		
//		public Builder setQuantity(int quantity) {
//			this.quantity = quantity;
//			return this;
//		}
		
		public Order build() {
			return new Order(this);
		}
	}
	
}