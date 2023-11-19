package com.cnc.shoppings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.shoppings.model.Category;
import com.cnc.shoppings.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category addCategory(Category category) {
		try
		{
			return categoryRepository.save(category);
		}
		catch(Exception e) {
			System.err.println("Exception occured in loginAdmin"+e.getMessage()+"cause "+e.getCause());
		}
		return null;
	}
	
	public boolean removeCategory(int catId) {
		try
		{
			categoryRepository.deleteById(catId);
			return true;
		}
		catch(Exception e) {
			System.err.println("Exception occured in loginAdmin"+e.getMessage()+"cause "+e.getCause());
			return false;
		}
	}
	
	public List<Category> getCategories(){
		try
		{
			return categoryRepository.findAll();
		}
		catch(Exception e) {
			System.err.println("Exception occured in loginAdmin"+e.getMessage()+"cause "+e.getCause());
		}
		return null;
	}
	
	public Category getCategory(int catId) {
		try
		{
			return categoryRepository.findById(catId).get();
		}
		catch(Exception e) {
			System.err.println("Exception occured in loginAdmin"+e.getMessage()+"cause "+e.getCause());
		}
		return null;
	}
	
	public List<Category> getMainCategory(int mainCatId){
		try
		{
			return categoryRepository.getMainCategory(mainCatId);
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in loginAdmin"+e.getMessage()+"cause "+e.getCause());

		}
		return null;
	}
}
