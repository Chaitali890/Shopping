package com.cnc.shoppings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.shoppings.model.User;
import com.cnc.shoppings.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		try
		{
			return userRepository.save(user);
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in"+e.getMessage()+" cause: "+e.getCause());
			
		}
		return null;
	}
	
	public User login(String username,String password) {
		try {
			return userRepository.login(username, password);			
	    	}
	catch(Exception e) {
		System.err.println("Exception occured in userlogin:"+e.getMessage()+" cause: "+e.getCause());
	      }
		return null;
	}

	public List<User> getUsers(){
		try
		{
			return userRepository.findAll();
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in"+e.getMessage()+" cause: "+e.getCause());	
		}
		return null;
	}
	
	public User getUser(int userId){
		try
		{
			return userRepository.findById(userId).get();
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in"+e.getMessage()+" cause: "+e.getCause());	
		}
		return null;
	}
}
