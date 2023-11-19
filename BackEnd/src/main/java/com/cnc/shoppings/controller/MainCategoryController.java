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
import com.cnc.shoppings.model.MainCategory;
import com.cnc.shoppings.service.MainCategoryService;

@RestController
@RequestMapping("Main-Category")
@CrossOrigin("http://localhost:4200")
public class MainCategoryController {

	@Autowired
	private MainCategoryService mainCategoryService;
	
	@PostMapping("add")
	public GenericResponse<MainCategory> addMainCategory(@RequestBody MainCategory mainCategory){
		MainCategory mainCat = mainCategoryService.addMainCategory(mainCategory);
		if(mainCat!=null) {
		return GenericResponse.<MainCategory>builder()
			.success(true)
			.data(mainCat)
			.message("main category added successfully")
			.build();
		}
		else
		{
			return GenericResponse.<MainCategory>builder()
					.success(false)
					.data(mainCat)
					.message("main category not found")
					.build();
		}
	}
		
	@GetMapping("remove/{mainCatId}")
	public GenericResponse<Boolean> removeMainCategory(@PathVariable("mainCatId") int mainCatId){
		if(mainCategoryService.removeMainCategory(mainCatId)) {
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
	public GenericResponse<List<MainCategory>>getCategories(){
		List<MainCategory> list = mainCategoryService.getCategories();
		if(list!=null) {
			return GenericResponse.<List<MainCategory>>builder()
					.success(true)
					.data(list)
					.message("")
					.build();
		}
		else
		{
			return GenericResponse.<List<MainCategory>>builder()
					.success(false)
					.data(null)
					.message("")
					.build();
		}
	}
	
	@GetMapping("by-id/{catId}")
	public GenericResponse<MainCategory>getCategory(@PathVariable("catId") int catId){
		if(mainCategoryService.getCategory(catId)!=null) {
			return GenericResponse.<MainCategory>builder()
					.success(true)
					.data(null)
					.message("")
					.build();
			}
		else
		{
			return GenericResponse.<MainCategory>builder()
					.success(false)
					.data(null)
					.message("")
					.build();
		}
}

}