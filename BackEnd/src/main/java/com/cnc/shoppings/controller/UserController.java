package com.cnc.shoppings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnc.shoppings.GenericResponse;
import com.cnc.shoppings.model.User;
import com.cnc.shoppings.service.UserService;


@RestController
@RequestMapping("user")
@CrossOrigin("http://localhost:4200")


public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("add")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PostMapping("login")
	public GenericResponse<User> login(@RequestBody User user) {
		User userRes = userService.login(user.getEmail(), user.getPassword());
		if(userRes!=null) {
			return GenericResponse.<User>builder()
					.success(true)
					.data(userRes)
					.message("user login successfull")
					.build();
		}
		else
		{
			return GenericResponse.<User>builder()
					.success(false)
					.data(null)
					.message("user login failed")
					.build();
		}
	}
	
	@GetMapping("all")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("by-id/{userId}")
	public User getUser(@PathVariable("userId") int userId) {
		return userService.getUser(userId);
	}
}
