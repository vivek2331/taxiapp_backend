package com.example.project2.web;

import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.project2.entity.OrderDetails;
import com.example.project2.entity.Orrder;
import com.example.project2.entity.User;
import com.example.project2.payload.acceptOrderRequest;
import com.example.project2.payload.createOrderRequest;
import com.example.project2.repository.OrderRepository;
import com.example.project2.repository.Order_Details_Repository;
import com.example.project2.service.OrderService;
import com.example.project2.web.payload.CreateOrderResponse;

@RestController
@RequestMapping("/api/acceptorder")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	Order_Details_Repository order_Details_Repository;
	
   @Autowired
   OrderRepository orderRepository;
	
	@PostMapping("")
	public ResponseEntity<?> acceptOrder(@AuthenticationPrincipal User user, @RequestBody acceptOrderRequest acceptorderrequest){
//		System.out.println(user.getUsername());
		long userId = user.getId();
		String Restaurantname = acceptorderrequest.getRestaurantname();
		String Status = acceptorderrequest.getStatus();
		long orderId = acceptorderrequest.getOrder_id();
		String Customername = acceptorderrequest.getCustomername();
		String Customerlocation = acceptorderrequest.getCustomerlocation();
		String Restaurantlocation = acceptorderrequest.getRestaurantlocation();
//		System.out.println(Customername +"--"+Customerlocation+"--"+Restaurantlocation);
		Orrder acceptOrrder = new Orrder(Restaurantname, Status, user, orderId, Restaurantlocation, Customername, Customerlocation);
		orderRepository.save(acceptOrrder);
		OrderDetails orderdetails = orderService.findOrderDetailsById(orderId);
		orderdetails.setRestaurantlocation(null);
		order_Details_Repository.save(orderdetails);
		return ResponseEntity.ok(acceptOrrder);
	}
	
	@PostMapping("/updatestatus/{id}")
	public ResponseEntity<?> updateStatus(@PathVariable("id") int id){
		Orrder orrder = orderService.findByOrderid(id);
		orrder.setStatus("Delivered");
		orderRepository.save(orrder);
		return ResponseEntity.ok(orrder);
	}
	
//	@PostMapping("/create")
//	public ResponseEntity<?> createOrder(@RequestBody createOrderRequest createorderrequest){
//		String Restaurantname = createorderrequest.getRestaurantname();
//		String Restaurantlocation = createorderrequest.getRestaurantlocation();
//		String Customerlocation = createorderrequest.getCustomer_location();
//		String Customername = createorderrequest.getCustomer_name();
//		
//		OrderDetails order = new OrderDetails(Restaurantname, Restaurantlocation, Customerlocation, Customername );
//		order_Details_Repository.save(order);
//		
//		return ResponseEntity.ok(new CreateOrderResponse(true, "New Order created", order));
//	}
	
	@GetMapping("/orderdetails")
	public ResponseEntity<?> getOrderDetails(@AuthenticationPrincipal User user){
		String city = user.getCity();
		List<OrderDetails> ordersByCity = orderService.findByRestaurantlocation(city);
		return ResponseEntity.ok(ordersByCity);
	}
	
	@GetMapping("/pendingorders")
	public ResponseEntity<?> pendingOrder(@AuthenticationPrincipal User user){
		List<Orrder> ordersByStatus =  orderService.findByStatus(user);
		return ResponseEntity.ok(ordersByStatus);
	}
	
	@GetMapping("/deliveredorders")
	public ResponseEntity<?> deliveredOrder(@AuthenticationPrincipal User user){
		List<Orrder> ordersByDeliveredStatus = orderService.findByDeliveredStatus(user);
		return ResponseEntity.ok(ordersByDeliveredStatus);
	}
}
