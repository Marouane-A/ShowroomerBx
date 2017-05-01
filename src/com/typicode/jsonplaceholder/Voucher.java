package com.typicode.jsonplaceholder;

public class Voucher {

	private int voucherId;
    private String reference;
    private String name;
    private String description;
    private float amount;
   
    private int UserId ;
    private User user;
	public Voucher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Voucher [voucherId=" + voucherId + ", reference=" + reference + ", name=" + name + ", description="
				+ description + ", amount=" + amount + ", showroomer=" + user + "]";
	}
	
    
}
