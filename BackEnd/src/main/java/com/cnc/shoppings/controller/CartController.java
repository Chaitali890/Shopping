package com.cnc.shoppings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnc.shoppings.GenericResponse;
import com.cnc.shoppings.model.Cart;
import com.cnc.shoppings.service.CartService;

@RestController
@RequestMapping("cart")
@CrossOrigin("http://localhost:4200")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("add")
	public GenericResponse<Cart> addCart(@RequestBody Cart cart){
		Cart response = cartService.addCart(cart);
		if(response!=null) {
			return GenericResponse.<Cart>builder()
					.success(true)
					.data(response)
					.message("cart added")
					.build();
		}
		else
		{
			return GenericResponse.<Cart>builder()
					.success(false)
					.data(response)
					.message("cart not added")
					.build();
		}		
	}
	
	@GetMapping("/all")
	public GenericResponse<List<Cart>> getCarts(){
		List<Cart>response = cartService.getCarts();
		if(!response.isEmpty())
		{
			return GenericResponse.<List<Cart>>builder()
					.success(false)
					.data(response)
					.message("")
					.build();
		}
		else
		{
			return GenericResponse.<List<Cart>>builder()
					.success(false)
					.data(null)
					.message("")
					.build();
		}
	}
	
	@GetMapping("by-id/{cartId}")
	public GenericResponse<Cart> getCart(@PathVariable("cartId") int cartId){
		Cart response = cartService.getCart(cartId);
		if(response!=null) {
			return GenericResponse.<Cart>builder()
					.success(true)
					.data(response)
					.message("")
					.build();
		}
		else
		{
			return GenericResponse.<Cart>builder()
					.success(false)
					.data(response)
					.message("")
					.build();
		}
	}
	

	
	
	@GetMapping("by-ref-id/{userId}")
	public GenericResponse<List<Cart>> getCartByuserId(@PathVariable("userId") int userId){
		List<Cart> response = cartService.getCartByuserId(userId);
		if(response!=null) {
			return GenericResponse.<List<Cart>>builder()
					.success(true)
					.data(response)
					.message("")
					.build();
		}
		else
		{
			return GenericResponse.<List<Cart>>builder()
					.success(false)
					.data(response)
					.message("")
					.build();
		}
	}
	
	
	
}
