package com.cnc.shoppings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.shoppings.model.Product;
import com.cnc.shoppings.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		try
		{
			return productRepository.save(product);
		}
		catch(Exception e)
		{
			System.err.print("Exception occured in"+e.getMessage()+" cause:"+e.getCause());
		}
		return null;
	}
	
	public boolean removeProduct(int productId) {
		try
		{
		productRepository.deleteById(productId);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in removeProduct"+e.getMessage()+"cause"+e.getCause());
			return false;
		}
	}
	
	public List<Product> getProducts(){
		try
		{
			return productRepository.findAll();
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in getProduct"+e.getMessage()+"cause"+e.getCause());
		}
		return null;
	}
	
	public Product getProduct(int productId) {
		try {
			return productRepository.findById(productId).get();
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in productId"+e.getMessage()+"cause"+e.getCause());
		}
		return null;
		
	}
	
	public List<Product> getProductByCat(int catId){
		return productRepository.findByCatId(catId);
	}

	
}
