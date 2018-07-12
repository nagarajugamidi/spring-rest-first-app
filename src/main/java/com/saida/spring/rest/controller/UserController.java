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
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/User/{id}", method = RequestMethod.GET)
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

	@RequestMapping(value = "/User", method = RequestMethod.GET)
	public List<User> getAll() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/User/{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable Long id) {
		userService.deleteUser(id);
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/User", method = RequestMethod.POST)
	public HttpStatus insertUser(@RequestBody User User) {
		return userService.addUser(User) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/User", method = RequestMethod.PUT)
	public HttpStatus updateUser(@RequestBody User User) {
		return userService.updateUser(User) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
}