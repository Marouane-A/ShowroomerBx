package com.typicode.jsonplaceholder;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Purchase {
	private int purchaseId;
	private Date datePurchase;
	private double total ;
    private String  Status ;
    private List<Order> orders = new ArrayList<Order>();
    
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Purchase(int purchaseId, Date datePurchase, double total, String status, List<Order> orders) {
		super();
		this.purchaseId = purchaseId;
		this.datePurchase = datePurchase;
		this.total = total;
		Status = status;
		this.orders = orders;
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public Date getDatePurchase() {
		return datePurchase;
	}
	public void setDatePurchase(Date datePurchase) {
		this.datePurchase = datePurchase;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", datePurchase=" + datePurchase + ", total=" + total
				+ ", Status=" + Status + ", orders=" + orders + "]";
	}
    

}
