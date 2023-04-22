package com.whertotravel.entities.user.model;

import lombok.Data;

@Data
public class UserCreateRequest {
  private String firstname;
  private String lastname;
  private String email;
  private String password;
}
