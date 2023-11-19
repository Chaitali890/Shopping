package com.cnc.shoppings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.shoppings.model.Admin;
import com.cnc.shoppings.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public int loginAdmin(Admin admin) {
		try
		{
			return adminRepository.getAdminByUnameAndPass(admin.getUsername(), admin.getPassword(), admin.getStatus());
		}
		catch(Exception e) {
			System.err.println("Exception occured in loginAdmin"+e.getMessage()+"cause "+e.getCause());
		}
		return 0;
	}
}
