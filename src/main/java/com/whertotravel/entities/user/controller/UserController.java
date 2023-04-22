package com.whertotravel.entities.user.controller;

import com.whertotravel.config.Config;
import com.whertotravel.entities.user.model.User;
import com.whertotravel.entities.user.model.UserCreateRequest;
import com.whertotravel.entities.user.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Config.API_V_1 + "user")
public class UserController {
  private final UserServiceImpl userService;

  public UserController(UserServiceImpl userService) {
    this.userService = userService;
  }

  @PostMapping
  void saveUser(@RequestBody UserCreateRequest userCreateRequest) {
    var savedUser = userService.saveNewUser(userCreateRequest);
  }

  @GetMapping("/all")
  List<User> getAll() {
    return userService.getAll();
  }

}
