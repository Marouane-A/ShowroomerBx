package com.typicode.jsonplaceholder;
import java.util.ArrayList;
import java.util.List;

public class Showroomer extends User  {

	/*int userId;
    String username;
    String city;
    String street;
    long zipCode;
    */
	private String description;
	private float latitude;
    private float longitude;
	private List<Showroom> showrooms = new ArrayList<Showroom>();
	//private List<Voucher> vouchers = new ArrayList<Voucher>();
	
	

	

	
	




	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Showroom> getShowrooms() {
		return showrooms;
	}
	public void setShowrooms(List<Showroom> showrooms) {
		this.showrooms = showrooms;
	}


	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "Showroomer [description=" + description + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", showrooms=" + showrooms + ", toString()=" + super.toString() + "]";
	}



	
	
	
	
}
