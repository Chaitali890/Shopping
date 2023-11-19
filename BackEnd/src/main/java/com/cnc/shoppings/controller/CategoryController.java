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
import com.cnc.shoppings.model.Category;
import com.cnc.shoppings.service.CategoryService;


@RestController
@RequestMapping("category-add")
@CrossOrigin("http://localhost:4200")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("add")
	public GenericResponse<Category> addCategory(@RequestParam Integer catId,@RequestParam String catName,@RequestParam String catDesc, @RequestParam String status, @RequestParam Integer mainCatId, @RequestParam MultipartFile catImage)throws IOException{
		
		Category category = new Category();
		if(catId!=null && catId!=0) {
			category.setCatId(catId);
		}
		
		if(catImage!=null) {
			category.setCatImage(Base64.getEncoder().encodeToString(catImage.getBytes()));
			category.setCatImageName(catImage.getOriginalFilename());
		}
		
		category.setCatName(catName);
		category.setCatDesc(catDesc);
		category.setStatus(status);
		category.setMainCatId(mainCatId);
		
		Category response = categoryService.addCategory(category);
			if(response!=null) {
				return GenericResponse.<Category>builder()
						.success(true)
						.data(response)
						.message("")
						.build();
			}
			else
			{
				return GenericResponse.<Category>builder()
						.success(false)
						.data(response)
						.message("")
						.build();
			}	
	}
	
	@GetMapping("remove/{catId}")
	public GenericResponse<Boolean> removeCategory(@PathVariable("catId") int catId){
		if(categoryService.removeCategory(catId)) {
			return GenericResponse.<Boolean>builder()
					.success(true)
					.data(null)
					.message("")
					.build();
		}
		else
		{
			return GenericResponse.<Boolean>builder()
					.success(false)
					.data(null)
					.message("")
					.build();
		}
	}
	
	@GetMapping("all")
	public GenericResponse<List<Category>>getCategories(){
		List<Category> reponse =  categoryService.getCategories();
		if(reponse!=null) {
			return GenericResponse.<List<Category>>builder()
					.success(true)
					.data(reponse)
					.message("")
					.build();
		}
		else
		{
			return GenericResponse.<List<Category>>builder()
					.success(false)
					.data(null)
					.message("")
					.build();
		}
	}
	
	@GetMapping("by-id/{catId}")
	public GenericResponse<Category> getCategory(@PathVariable int catId) {
		Category response = categoryService.getCategory(catId);
		if(response!=null) {
			return GenericResponse.<Category>builder()
					.success(true)
					.data(response)
					.message("")
					.build();
		}
		else
		{
			return GenericResponse.<Category>builder()
					.success(false)
					.data(response)
					.message("")
					.build();
		}
	}
	
	@GetMapping("by-ref-id/{mainCatId}")
	public GenericResponse<List<Category>> getMainCategory(@PathVariable("mainCatId") int mainCatId){
		List<Category> response = categoryService.getMainCategory(mainCatId);
		if(response!=null) {
			return GenericResponse.<List<Category>>builder()
					.success(true)
					.data(response)
					.message("added")
					.build();
		}
		else
		{
			return GenericResponse.<List<Category>>builder()
					.success(false)
					.data(response)
					.message("not added")
					.build();
		}
	}
}
