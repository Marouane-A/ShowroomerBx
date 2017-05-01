package com.typicode.jsonplaceholder;


public class Showroom {

	private int showroomId;
	private int showroomerId;
	private int productId;
	private Showroomer showroomer ;
	private Product product;
	
	public Showroom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getShowroomId() {
		return showroomId;
	}
	public void setShowroomId(int showroomId) {
		this.showroomId = showroomId;
	}
	
	public Showroomer getShowroomer() {
		return showroomer;
	}

	public void setShowroomer(Showroomer showroomer) {
		this.showroomer = showroomer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getShowroomerId() {
		return showroomerId;
	}
	public void setShowroomerId(int showroomerId) {
		this.showroomerId = showroomerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
}
