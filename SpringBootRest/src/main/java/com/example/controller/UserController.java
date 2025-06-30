package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
public class UserController {
	
	@Autowired UserService service;
	@GetMapping("/")
	public List<User> home() {
		List<User> list = List.of(
				new User(1,"java",9876945,"ahmedabad"),
				new User(2,"python",9876945,"ahmedabad"),
				new User(3,"php",9876945,"ahmedabad"),
				new User(4,"dart",9876945,"ahmedabad"),
				new User(5,"kotlin",9876945,"ahmedabad")
				);
		return list;
	}
	
	@PostMapping("/user/save")
	public String aboutpage(@RequestBody User u) {
		System.out.println(u);
		this.service.insertOrUpdateUser(u);
		return "successs";
	} 
	
	@PostMapping("/allusers/save")
	public String aboutpage(@RequestBody List<User> u) {
		System.out.println(u);
		this.service.insertOrUpdateAllUsers(u);
		
		return "success";
	}
	
	@GetMapping("/allusers")
	public List<User> findAllUser() {
		return this.service.getAllUsers();
	}
	
	@GetMapping("/allusers/{id}")
	public Optional<User> getById(@PathVariable("id") int id){
		System.out.println("id:" + id);
		return this.service.getUserById(id);
	}
	
	@GetMapping("/allusers/fetchByname")
	public User getByName(@RequestParam("name") String name) {
		System.out.println(name);
		return this.service.getUserByName(name);
	}
	
	@PutMapping("/allusers/update")
	public void updateUser(@RequestBody User u) {
		this.service.insertOrUpdateUser(u);
	}
	
	@DeleteMapping("/allusers/delete/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		this.service.deleteUserById(id);
	}
		
}

//Annotation	   Extracts from	    Example URL	    Use case
//@PathVariable	   URL Path	            /user/10	    Resource identification
//@RequestParam	   Query Parameters	    /user?id=10	    Search/filter/query values
