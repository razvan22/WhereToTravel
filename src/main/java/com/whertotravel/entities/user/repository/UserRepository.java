package com.whertotravel.entities.user.repository;

import com.whertotravel.entities.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
  Optional<User> findUserByEmail(String email);

  List<User> findAll();
}
