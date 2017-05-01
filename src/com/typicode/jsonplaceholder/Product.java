package com.typicode.jsonplaceholder;

import java.util.ArrayList;
import java.util.List;

public class Product {
	int productId;
	String name;
	String brand;
	String category;
	float discount;
	float price;
	int quantity;
	float tva;
	String facebookId;
	String description;
	String creationDate;
	private List<Interaction> interactions = new ArrayList<Interaction>();
	private List<Showroom> showrooms = new ArrayList<Showroom>();
	private List<Image> images = new ArrayList<Image>();
	public Product() {
		super();
	}

	

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", brand=" + brand + ", category=" + category
				+ ", discount=" + discount + ", price=" + price + ", quantity=" + quantity + ", tva=" + tva
				+ ", interactions=" + interactions + ", showrooms=" + showrooms + ", images=" + images + "]";
	}



	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Showroom> getShowrooms() {
		return showrooms;
	}
	public void setShowrooms(List<Showroom> showrooms) {
		this.showrooms = showrooms;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTva() {
		return tva;
	}
	public void setTva(float tva) {
		this.tva = tva;
	}
	public List<Interaction> getInteractions() {
		return interactions;
	}
	public void setInteractions(List<Interaction> interactions) {
		this.interactions = interactions;
	}
	public String getFacebookId() {
		return facebookId;
	}
	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}



	
}
