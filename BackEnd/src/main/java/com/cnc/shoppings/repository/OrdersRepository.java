package com.cnc.shoppings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cnc.shoppings.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	@Query(nativeQuery = true,value="update Orders set status='inactive'" + "where order_id=:orderId")
	
	public int cancelOrder(@Param("orderId") Integer orderId);
	
}
