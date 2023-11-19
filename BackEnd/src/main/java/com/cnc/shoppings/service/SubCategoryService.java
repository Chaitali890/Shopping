package com.cnc.shoppings.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cnc.shoppings.model.SubCategory;
import com.cnc.shoppings.repository.SubCategoryRepository;

@Repository
public class SubCategoryService {

	@Autowired
	private SubCategoryRepository subCategoryRepository;
	
	public SubCategory addSubCategory(SubCategory subcategory) {
		try
		{
			return subCategoryRepository.save(subcategory);
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in addsubcategory"+e.getMessage()+" cause: "+e.getCause());
		}
		return null;
	}
	
	public boolean removeSubCategory(int subCatId) {
		try
		{
			subCategoryRepository.deleteById(subCatId);
			return true;
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in addsubcategory"+e.getMessage()+" cause: "+e.getCause());
		}
		return false;
	}
	
	public List<SubCategory> getAllSubCategories(){
		try
		{
			return subCategoryRepository.findAll();
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in addsubcategory"+e.getMessage()+" cause: "+e.getCause());
		}
		return null;
	}
	
	public List<SubCategory> getCategoryBySubCatId(int subCatId){
		try
		{
			return subCategoryRepository.getCategoryBySubCatId(subCatId);
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in addsubcategory"+e.getMessage()+" cause: "+e.getCause());
		}
		return null;
	}
}