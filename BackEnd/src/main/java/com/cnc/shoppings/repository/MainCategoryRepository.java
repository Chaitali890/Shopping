package com.cnc.shoppings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cnc.shoppings.model.MainCategory;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory, Integer> {

}
