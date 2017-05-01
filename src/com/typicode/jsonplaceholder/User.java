package com.typicode.jsonplaceholder;

import java.util.ArrayList;
import java.util.List;

public class User {

    int userId;
    String username;
   // private String password;
    //private String email;
    //private String firstName;
    //private String lastName;
   // private String phone;
    //private Date dateCreation;
    String city;
    String street;
    long zipCode;
    
    //private List<Media> medias = new ArrayList<Media>();
	List<Interaction> interactions = new ArrayList<Interaction>();
	 List<Order> orders = new ArrayList<Order>();
	 List<Voucher> vouchers = new ArrayList<Voucher>();
	 
	public User() {
		
	}
	
	public User(int userId, String username, String city, String street,long zipCode,  List<Interaction> interactions,
			List<Order> orders, List<Voucher> vouchers) {
		super();
		this.userId = userId;
		this.username = username;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.interactions = interactions;
		this.orders = orders;
		this.vouchers = vouchers;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public List<Interaction> getInteractions() {
		return interactions;
	}
	public void setInteractions(List<Interaction> interactions) {
		this.interactions = interactions;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<Voucher> getVouchers() {
		return vouchers;
	}
	public void setVouchers(List<Voucher> vouchers) {
		this.vouchers = vouchers;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", city=" + city + ", street=" + street
				+ ", zipCode=" + zipCode + ", interactions=" + interactions + ", orders=" + orders + ", vouchers="
				+ vouchers + "]";
	}
	
	
}