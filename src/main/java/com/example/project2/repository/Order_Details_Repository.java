package com.example.project2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project2.entity.OrderDetails;
import com.example.project2.entity.Orrder;

public interface Order_Details_Repository extends JpaRepository<OrderDetails, Long>{
	
	OrderDetails findOrderDetailsById(long id);
    List<OrderDetails> findByRestaurantlocation(String city);
}
