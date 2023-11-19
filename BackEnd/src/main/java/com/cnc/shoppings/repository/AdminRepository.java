package com.cnc.shoppings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cnc.shoppings.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query(nativeQuery=true, value="select count(*) from Admin where username=:username and password=:password and status=:status")
	
	public Integer getAdminByUnameAndPass(@Param("username") String username, @Param("password") String password, @Param("status") String status);
}
