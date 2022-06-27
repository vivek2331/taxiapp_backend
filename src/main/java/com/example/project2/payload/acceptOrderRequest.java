package com.example.project2.payload;

public class acceptOrderRequest {
	private String restaurantname;
	
	private String status;
	
	private long order_id;

	private String customername;
	
	private String customerlocation;
	
	private  String restaurantlocation;
	
	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomerlocation() {
		return customerlocation;
	}

	public void setCustomerlocation(String customerlocation) {
		this.customerlocation = customerlocation;
	}

	public String getRestaurantlocation() {
		return restaurantlocation;
	}

	public void setRestaurantlocation(String restaurantlocation) {
		this.restaurantlocation = restaurantlocation;
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public String getRestaurantname() {
		return restaurantname;
	}

	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
