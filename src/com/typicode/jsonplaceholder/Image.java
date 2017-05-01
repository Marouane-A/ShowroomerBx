package com.typicode.jsonplaceholder;

public class Image {

	 private int imageId;
     private String name;
     private String url;
     private Product product;
     private int productId;
     
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Image(int imageId, String name, String url, Product product) {
		super();
		this.imageId = imageId;
		this.name = name;
		this.url = url;
		this.product = product;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
     
}
