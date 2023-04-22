package com.whertotravel.entities.user.service;


import com.whertotravel.entities.user.model.User;
import com.whertotravel.entities.user.model.UserCreateRequest;

import java.util.List;

public interface UserService {
  User saveNewUser(UserCreateRequest user);

  List<User> getAll();
}
