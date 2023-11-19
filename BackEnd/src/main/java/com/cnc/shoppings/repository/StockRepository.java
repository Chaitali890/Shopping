package com.cnc.shoppings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cnc.shoppings.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

}
