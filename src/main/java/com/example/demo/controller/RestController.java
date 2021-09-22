package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * The Class RestController.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

	/**
	 * Hello world.
	 *
	 * @return the string
	 */
	@GetMapping(path = "/hello-world")
	public String HelloWorld() {
		return "Hello World";

	}

	/**
	 * Hello world bean.
	 *
	 * @return the hello world bean
	 */
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello World");

	}

	/**
	 * Hello world path variable.
	 *
	 * @param name the name
	 * @return the hello world bean
	 */
	@GetMapping(path = "/hello-world-pathVariable/{name}")
	public HelloWorldBean HelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello World :  " + name);

	}
}
