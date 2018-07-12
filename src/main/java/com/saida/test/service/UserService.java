package com.saida.test.service;

import java.util.List;
import java.util.Optional;

import com.saida.test.repository.User;

public interface UserService {

	public List<User> getAllUsers();

	public List<User> findByName(String name);

	public Optional<User> getById(Long id);

	public void deleteUser(Long userId);

	public boolean addUser(User User);

	public boolean updateUser(User User);
}
