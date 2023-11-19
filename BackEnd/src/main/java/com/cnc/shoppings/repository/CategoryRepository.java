package com.cnc.shoppings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cnc.shoppings.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	@Query(nativeQuery=true, value="select * from category where main_cat_id=:mainCatId and status='active'")

	public List<Category> getMainCategory(@Param("mainCatId") Integer mainCatId);

}
