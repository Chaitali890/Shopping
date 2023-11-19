package com.cnc.shoppings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cnc.shoppings.model.Orders;
import com.cnc.shoppings.service.OrdersService;

@Service
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@PostMapping("add-orders")
	public Orders addOrders(@RequestBody Orders orders) {
		return ordersService.addOrder(orders);
	}
	
	@GetMapping("all-orders")
	public List<Orders> getOrders(){
		return ordersService.getOrders();
	}
}
