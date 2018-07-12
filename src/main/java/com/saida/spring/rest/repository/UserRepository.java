package com.saida.spring.rest.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository<P> extends CrudRepository<User, Long> {
    List<User> findByFirstName(String firstName);
}