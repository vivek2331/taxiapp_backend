package com.example.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project2.entity.OrderDetails;
import com.example.project2.entity.Orrder;
import com.example.project2.entity.User;
import com.example.project2.repository.OrderRepository;
import com.example.project2.repository.Order_Details_Repository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private Order_Details_Repository order_Details_Repository;
	
	public Orrder save(User user,long id) {
		OrderDetails orderDetails = order_Details_Repository.findOrderDetailsById(id);
		
		Orrder orrder = new Orrder();
		orrder.setStatus("Not Accepted");
		orrder.setRestaurantname(orderDetails.getRestaurantname());
		orrder.setUser(user);
//		System.out.println(orrder.getStatus()+" -- "+orrder.getId()+" -- "+orrder.getUser().getUsername());
		
		return orderRepository.save(orrder);
	}

	public List<OrderDetails> findByRestaurantlocation(String city){
		return order_Details_Repository.findByRestaurantlocation(city);
	}
	
	public OrderDetails findOrderDetailsById(long id) {
		return order_Details_Repository.findOrderDetailsById(id);
	}
	
	public Orrder findByOrderid(long id) {
		return orderRepository.findByOrderid(id);
	}

	public List<Orrder> findByStatus(User user) {
		List<Orrder> ordersByStatus = orderRepository.findByUserAndStatus(user,"pending");
		return ordersByStatus;
	}

	public List<Orrder> findByDeliveredStatus(User user) {
		List<Orrder> orderBydeliveredStatus = orderRepository.findByUserAndStatus(user, "Delivered");
		return orderBydeliveredStatus;
	}
}
