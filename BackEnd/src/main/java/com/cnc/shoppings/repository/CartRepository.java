package com.cnc.shoppings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cnc.shoppings.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	
	@Query(nativeQuery=true, value="select * from cart where user_id=:userId and status='active'")
	public List<Cart> getCartByuserId(@Param("userId") Integer userId);

	
}
