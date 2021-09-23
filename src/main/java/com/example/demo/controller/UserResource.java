package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.controller.user.User;
import com.example.demo.controller.user.UserDaoService;

/**
 * The Class UserResource.
 */
@RestController
public class UserResource {
	
	/** The service. */
	@Autowired
	private UserDaoService service;
	
	
	/**
	 * Retrive all users.
	 *
	 * @return the list
	 */
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		
		return service.findAll();
	}
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the user
	 */
	@GetMapping("/users/{id}")
	public User findById(@PathVariable int id){
		return service.findOne(id);    
	}
	
	/**
	 * Adds the users.
	 *
	 * @param user the user
	 * @return the user
	 */
	@PostMapping("/users")
	public ResponseEntity<Object> addUsers(@RequestBody User user){
		User savedUser= service.save(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

}
