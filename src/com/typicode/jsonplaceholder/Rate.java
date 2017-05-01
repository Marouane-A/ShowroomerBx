package com.typicode.jsonplaceholder;



public class Rate extends Interaction{
	private int mark;

	public Rate(int mark) {
		super();
		this.mark = mark;
	}

	public Rate() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Rate(int interactionId, int userId, int productId, User users, Product products) {
		super(interactionId, userId, productId, users, products);
		// TODO Auto-generated constructor stub
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Rate [mark=" + mark + ", toString()=" + super.toString() + "]";
	}
	
    
}
