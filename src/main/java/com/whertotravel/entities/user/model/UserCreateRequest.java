package com.whertotravel.entities.user.model;

public record UserCreateRequest(
  String firstname,
  String lastname,
  String email,
  String password
) {

}
