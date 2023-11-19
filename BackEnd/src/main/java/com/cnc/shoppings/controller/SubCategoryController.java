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
import com.cnc.shoppings.model.SubCategory;
import com.cnc.shoppings.service.SubCategoryService;

@RestController
@RequestMapping("sub-category")
@CrossOrigin("http://localhost:4200")
public class SubCategoryController {

	@Autowired
	private SubCategoryService subCategoryService;
	
	@PostMapping("add")
	public GenericResponse<SubCategory> addSubCategory(@RequestParam Integer subCatId, @RequestParam String subCatName, @RequestParam String subCatDesc, @RequestParam MultipartFile subCatImage, @RequestParam Integer catId, @RequestParam String status) throws IOException
	{
	SubCategory subCategory = new SubCategory();
	
	if(subCatId!=0) {
		subCategory.setSubCatId(subCatId);
	}
	
	subCategory.setSubCatName(subCatName);
	subCategory.setSubCatDesc(subCatDesc);
	
	if(subCatImage !=null) {
		subCategory.setSubCatImage(Base64.getEncoder().encodeToString(subCatImage.getBytes()));
		subCategory.setSubCatImageName(subCatImage.getOriginalFilename());
	}
	
	subCategory.setCatId(catId);
	subCategory.setStatus(status);
	SubCategory response = subCategoryService.addSubCategory(subCategory);
	if(response!=null) {
		return GenericResponse.<SubCategory>builder()
				.success(true)
				.data(response)
				.message("")
				.build();
					}
		else
			{
		return GenericResponse.<SubCategory>builder()
				.success(false)
				.data(response)
				.message("")
				.build();
			}
	}
	
	@GetMapping("remove/{subCatId}")
	public GenericResponse<Boolean> removeSubCategory(@PathVariable("subCatId") int subCatId){
		if( subCategoryService.removeSubCategory(subCatId)) {
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
					.data(null)
					.message("")
					.build();
		}
	}
	
	@GetMapping("all")
	public GenericResponse<List<SubCategory>> getAllSubCategory(){
		List<SubCategory> response = subCategoryService.getAllSubCategories();
		if(response!=null) {
			return GenericResponse.<List<SubCategory>>builder()
					.success(true)
					.data(response)
					.message("")
					.build();
		}
		else
		{
			return GenericResponse.<List<SubCategory>>builder()
					.success(true)
					.data(null)
					.message("")
					.build();
		}
	}
	
	
	@GetMapping("by-ref-id/{subCatId}")
	public GenericResponse<List<SubCategory>> getCategoryBySubCatId(@PathVariable("subCatId") int subCatId){
		List<SubCategory> response = subCategoryService.getCategoryBySubCatId(subCatId);
		if(response!=null) {
			return GenericResponse.<List<SubCategory>>builder()
					.success(true)
					.data(response)
					.message("")
					.build();
		}
		else
		{
			return GenericResponse.<List<SubCategory>>builder()
					.success(true)
					.data(null)
					.message("")
					.build();
		}
	}
	
	
}
 