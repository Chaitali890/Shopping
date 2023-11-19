package com.cnc.shoppings.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.cnc.shoppings.model.Cart;
import com.cnc.shoppings.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	public Cart addCart(Cart cart) {
		try
		{
			cart.setStatus("active");
			return cartRepository.save(cart);
		}
		catch(Exception e) {
			System.err.println("Exception occured in addCart"+e.getMessage()+"cause:"+e.getCause());
		}
		return null;
	}
	
	public List<Cart> getCarts(){
		try
		{
			return cartRepository.findAll();
		}
		catch(Exception e) {
			System.err.println("Exception occured in getcarts"+e.getMessage()+" cause "+e.getCause());
		}
		return Collections.emptyList();
	}
	
	public Cart getCart(int cartId) {
		try
		{
			return cartRepository.findById(cartId).get();
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in getCart"+e.getMessage()+" cause "+e.getCause());
		}
		return null;
	}
	
	@GetMapping("remove/{cartId}")
	public boolean removeCart(int cartId) {
		try
		{
			cartRepository.deleteById(cartId);
			return true;
		}
		catch(Exception e)
		{
			System.err.println("Exception occuredd in"+e.getMessage()+" cause "+e.getCause());
		}
			return false;
	}

	
	public List<Cart> getCartByuserId(int userId) {
		try
		{
			return cartRepository.getCartByuserId(userId);
		}
		catch(Exception e)
		{
			System.err.println("Exception occuredd in getCartByuserId"+e.getMessage()+" cause "+e.getCause());
		}
			return null;
	}
}
