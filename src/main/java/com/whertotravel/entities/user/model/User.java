package com.whertotravel.entities.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
  @Id
  private String id;

  private String firstname;
  private String lastname;
  private String email;
  private String password;
}
