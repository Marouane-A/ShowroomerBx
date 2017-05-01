package com.typicode.jsonplaceholder;

public class Buyer extends User {
	private String deliveryAddress;
    
	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Buyer(String deliveryAddress) {
		super();
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public String toString() {
		return super.toString()+ "Buyer [deliveryAddress=" + deliveryAddress + "]";
	}
	

}
