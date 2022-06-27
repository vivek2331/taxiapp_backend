package com.example.project2.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetails {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "restaurantname")
	private String restaurantname;
	
	public OrderDetails(String restaurantname, String restaurantlocation, String customer_location,
			String customer_name) {
		super();
		this.restaurantname = restaurantname;
		this.restaurantlocation = restaurantlocation;
		this.customer_location = customer_location;
		this.customer_name = customer_name;
	}

	public OrderDetails() {
	
	}

	@Column(name = "restaurantlocation")
	private String restaurantlocation;
	
//	@Column(name = "order_id")
//	private int order_id;
//	
	@Column(name = "customer_location")
	private String customer_location;
	
	public String getRestaurantlocation() {
		return restaurantlocation;
	}

	public void setRestaurantlocation(String restaurantlocation) {
		this.restaurantlocation = restaurantlocation;
	}

	@Column(name = "customer_name")
	private String customer_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRestaurantname() {
		return restaurantname;
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
