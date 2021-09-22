package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	
	@GetMapping(path="/hello-world")
	public String HelloWorld() {
		return "Hello World"; 
		
		
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello World"); 
		
		
	}
}
