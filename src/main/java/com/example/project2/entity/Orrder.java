package com.example.project2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity //will create table called order(based on class name)
public class Orrder {

	public String getRestaurantlocation() {
		return restaurantlocation;
	}
	public void setRestaurantlocation(String restaurantlocation) {
		this.restaurantlocation = restaurantlocation;
	}
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
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String restaurantname;
	
	private String status;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
//	private int order_id;
	
//	@JsonIgnore
//	@OneToOne
//	@JoinColumn(name = "order_details_id")
//	private OrderDetails order_Details;
	
	@Column(name = "order_id")
	private long orderid;
	
	@Column(name = "restaurantlocation")
	private String restaurantlocation;
	
	@Column(name = "customername")
	private String customername;
	
	@Column(name = "customerlocation")
	private String customerlocation;
	
	
//	public void setOrder_id(int order_id) {
//		this.order_id = order_id;
//	}


	
	
	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
//	public OrderDetails getOrder_Details() {
//		return order_Details;
//	}
//	public void setOrder_Details(OrderDetails order_Details) {
//		this.order_Details = order_Details;
//	}
	
	
	public Orrder() {
	}
	

	public Orrder(String restaurantname, String status, User user, long orderid, String restaurantlocation,
		String customername, String customerlocation) {
	super();
	this.restaurantname = restaurantname;
	this.status = status;
	this.user = user;
	this.orderid = orderid;
	this.restaurantlocation = restaurantlocation;
	this.customername = customername;
	this.customerlocation = customerlocation;
}
	//	public int getOrder_id() {
//		return order_id;
//	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//private User assignedTo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRestaurantname() {
		return restaurantname;
	}
	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}
//	public String getOrrdername() {
//		return orrdername;
//	}
//	public void setOrrdername(String orrdername) {
//		this.orrdername = orrdername;
//	}
	
}
