package com.saida.spring.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saida.spring.rest.repository.User;
import com.saida.spring.rest.service.UserService;

@RestController
@RequestMapping(value="/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<User> getUserById(@PathVariable Long id) {
		return userService.getById(id);
	}

	@RequestMapping(value = "/UserByName/{name}", method = RequestMethod.GET)
	public List<User> getUsereByName(@PathVariable String name) {
		List<User> users = userService.findByName(name);
		for (User user : users) {
			System.out.println("Printing User to check toString-->" + user);
		}

		return users;
	}

	@RequestMapping( method = RequestMethod.GET)
	public List<User> getAll() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable Long id) {
		userService.deleteUser(id);
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public HttpStatus insertUser(@RequestBody User user) {
		return userService.addUser(user) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public HttpStatus updateUser(@RequestBody User user) {
		return userService.updateUser(user) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
}