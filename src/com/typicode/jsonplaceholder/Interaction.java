package com.typicode.jsonplaceholder;





public class Interaction {
	private int interactionId;
	private int userId;
	private int productId;
	private User user;
	private Product product;
	
	public Interaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Interaction [interactionId=" + interactionId + ", userId=" + userId + ", productId=" + productId
				+ ", user=" + user + ", product=" + product + "]";
	}

	public Interaction(int interactionId, int userId, int productId, User user, Product product) {
		super();
		this.interactionId = interactionId;
		this.userId = userId;
		this.productId = productId;
		this.user = user;
		this.product = product;
	}

	public int getInteractionId() {
		return interactionId;
	}

	public void setInteractionId(int interactionId) {
		this.interactionId = interactionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
}
