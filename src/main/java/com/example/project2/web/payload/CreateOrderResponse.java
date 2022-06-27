package com.example.project2.web.payload;


import com.example.project2.entity.OrderDetails;

public class CreateOrderResponse {

	private Boolean success;
	private String message;
	private OrderDetails order;
	public Boolean getSuccess() {
		return success;
	}
	public CreateOrderResponse(Boolean success, String message, OrderDetails order) {
		super();
		this.success = success;
		this.message = message;
		this.order = order;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public OrderDetails getOrder() {
		return order;
	}
	public void setOrder(OrderDetails order) {
		this.order = order;
	}
}
