package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.controller.user.User;
import com.example.demo.controller.user.UserDaoService;
import com.example.demo.controller.user.exception.UserNotFoundException;

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
	public EntityModel<User> findById(@PathVariable int id){
		User user= service.findOne(id);  
		
		if(user==null) {
			throw new UserNotFoundException("id - " +id);
		}
		
		  EntityModel<User> resource = EntityModel.of(user);
		  Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retriveAllUsers()).withRel("all-users");
		  resource.add(link); 
		  return resource;
		 
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		User user=service.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("id - " +id);
		}
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
