package com.cnc.shoppings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnc.shoppings.model.Product;
import com.cnc.shoppings.service.ProductService;

@RestController
public class ExampleController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("add-product")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	
	@GetMapping("remove-product/{ProdId}")
	public String removeProduct(@PathVariable("ProdId")int prodId) {
		if(productService.removeProduct(prodId)) {
			return "success";
		}
		else
		{
			return "unsuccess";
		}		
	}
	
	@GetMapping("all-product")
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("all-product/{prodId}")
	public Product getProduct(@PathVariable("prodId") int prodId) {
		return productService.getProduct(prodId);
	}
	
	@GetMapping("byprod-id/{catId}")
	public List<Product> getProductByCat(@PathVariable("catId") int catId) {
		return productService.getProductByCat(catId);
	}
}
