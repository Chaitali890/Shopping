package com.cnc.shoppings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.shoppings.model.MainCategory;
import com.cnc.shoppings.repository.MainCategoryRepository;

@Service
public class MainCategoryService {

	@Autowired
	private MainCategoryRepository mainCategoryRepository;
	
	public MainCategory addMainCategory(MainCategory maincategory) {
		try
		{
			return mainCategoryRepository.save(maincategory);
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in addmaincategory"+e.getMessage()+"cause: "+e.getCause());
		}
		return null;
	}
	
	
	public boolean removeMainCategory(int mainCatId) {
		try
		{
			mainCategoryRepository.deleteById(mainCatId);
			return true;
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in addmaincategory"+e.getMessage()+"cause: "+e.getCause());
			return false;
		}
	}
	
	public List<MainCategory> getCategories(){
		try
		{
			return mainCategoryRepository.findAll();
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in addmaincategory"+e.getMessage()+"cause: "+e.getCause());
		}
		return null;
	}
	
	public MainCategory getCategory(int mainCatId) {
		try
		{
			return mainCategoryRepository.findById(mainCatId).get();
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in addmaincategory"+e.getMessage()+"cause: "+e.getCause());
		}
		return null;
	}
}
