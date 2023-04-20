package com.whertotravel.entities.base;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BaseEntity {
  @Id
  private String id;
}
