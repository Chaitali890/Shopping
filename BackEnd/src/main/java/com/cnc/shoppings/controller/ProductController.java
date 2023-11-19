package com.cnc.shoppings.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cnc.shoppings.GenericResponse;
import com.cnc.shoppings.model.Product;
import com.cnc.shoppings.service.ProductService;

@RestController
@RequestMapping("product-add")
@CrossOrigin("http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("add")
	public GenericResponse<Product> addProduct(@RequestParam Integer prodId, @RequestParam String prodName, @RequestParam String prodDesc, @RequestParam Integer prodPrice, @RequestParam String status, @RequestParam Integer subCatId, @RequestParam MultipartFile prodImage) throws IOException{
			
			Product product = new Product();
			if(prodId!=null && prodId!=0) {
				product.setProdId(prodId);
			}
			
			if(prodImage!=null) {
				product.setProdImage(Base64.getEncoder().encodeToString(prodImage.getBytes()));
				product.setProdName(prodImage.getOriginalFilename());
			}
				
				product.setProdName(prodName);
				product.setProdDesc(prodDesc);
				product.setProdPrice(prodPrice);
				product.setStatus(status);
				product.setSubCatId(subCatId);
				
				Product response = productService.addProduct(product);
				if(response!=null) {
					return GenericResponse.<Product>builder()
							.success(true)
							.data(response)
							.message("")
							.build();
				}
				else
				{
					return GenericResponse.<Product>builder()
							.success(false)
							.data(response)
							.message("")
							.build();
				}
				
		}	
		
		
	
	@GetMapping("remove/{prodId}")
	public GenericResponse<Boolean> removeProduct(@PathVariable("prodId") int prodId){
		if(productService.removeProduct(prodId)) {
			return GenericResponse.<Boolean>builder()
					.success(true)
					.data(true)
					.message("")
					.build();
		}
		else
		{
			return GenericResponse.<Boolean>builder()
					.success(false)
					.data(true)
					.message("")
					.build();
		}
	}
	
	@GetMapping("all")
	public GenericResponse<List<Product>> getProducts(){
		List<Product>list = productService.getProducts();
			if(list!=null) {
				return GenericResponse.<List<Product>>builder()
						.success(true)
						.data(list)
						.message("")
						.build();
			}
			else
			{
				return GenericResponse.<List<Product>>builder()
						.success(false)
						.data(null)
						.message("")
						.build();
			}
		}
	
	@GetMapping("by-id/{prodId}")
	public GenericResponse<Product> getProduct(@PathVariable("prodId")int prodId){
		Product response = productService.getProduct(prodId);
		if(response!= null) {
			
			return GenericResponse.<Product>builder()
					.success(true)
					.data(response)
					.message("")
					.build();
		}
		else
		{
			return GenericResponse.<Product>builder()
					.success(true)
					.data(response)
					.message("")
					.build();
		}
	}
	
	
	@GetMapping("by-ref-id/{subCatId}")
	public GenericResponse<List<Product>> getProductByCat(@PathVariable("subCatId") int subCatId){
		if(productService.getProductByCat(subCatId)!=null) {
			return GenericResponse.<List<Product>>builder()
					.success(true)
					.data(null)
					.message("")
					.build();
		}
			else
			{
				return GenericResponse.<List<Product>>builder()
						.success(false)
						.data(null)
						.message("")
						.build();
			}
}
}
