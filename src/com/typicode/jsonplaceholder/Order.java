package com.typicode.jsonplaceholder;

public class Order {
	private int orderId;
	private int userId;
	private User user;
	private int productId;
	private Product product;
	private int quantity;
	private int purchaseId;
	private Purchase purchase;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Order(int orderId, int userId, User user, int productId, Product product, int quantity, int purchaseId,
			Purchase purchase) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.user = user;
		this.productId = productId;
		this.product = product;
		this.quantity = quantity;
		this.purchaseId = purchaseId;
		this.purchase = purchase;
	}


	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", user=" + user + ", productId=" + productId
				+ ", product=" + product + ", quantity=" + quantity + ", purchaseId=" + purchaseId + ", purchase="
				+ purchase + "]";
	}
	
	
}
	
	