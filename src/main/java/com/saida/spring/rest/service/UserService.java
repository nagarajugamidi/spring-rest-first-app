package com.saida.spring.rest.service;

import java.util.List;
import java.util.Optional;

import com.saida.spring.rest.repository.User;

public interface UserService {

	public List<User> getAllUsers();

	public List<User> findByName(String name);

	public Optional<User> getById(Long id);

	public void deleteUser(Long userId);

	public boolean addUser(User user);

	public boolean updateUser(User user);
}
