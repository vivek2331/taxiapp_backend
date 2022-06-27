package com.example.project2.payload;

public class createOrderRequest {

	private String restaurantname;
	
    private String restaurantlocation;
    
	private String customer_location;

	private String customer_name;

	public String getRestaurantname() {
		return restaurantname;
	}

	public String getRestaurantlocation() {
		return restaurantlocation;
	}

	public void setRestaurantlocation(String restaurantlocation) {
		this.restaurantlocation = restaurantlocation;
	}

	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}



	public String getCustomer_location() {
		return customer_location;
	}

	public void setCustomer_location(String customer_location) {
		this.customer_location = customer_location;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
}
