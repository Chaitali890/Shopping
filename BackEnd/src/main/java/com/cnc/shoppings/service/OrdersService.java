package com.cnc.shoppings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.shoppings.model.Orders;
import com.cnc.shoppings.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;
	
	public Orders addOrder(Orders order) {
		try {
			
		return ordersRepository.save(order);
	      }
		catch(Exception e)
		{
			System.err.println("Exception occured in orders"+e.getMessage()+"cause:"+e.getCause());
		}
	return null;
	}
	
	public boolean cancelOrder(int orderId) {
		try
		{
			if(ordersRepository.cancelOrder(orderId)>0)
			{
			return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in orders"+e.getMessage()+"cause:"+e.getCause());
		}
	return false;
  }
	
	public List<Orders> getOrders(){
		return ordersRepository.findAll();
	}
}
