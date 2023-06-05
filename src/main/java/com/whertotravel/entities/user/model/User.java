package com.whertotravel.entities.user.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.whertotravel.entities.destination.models.Destination;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @JsonIgnore
  @OneToMany(mappedBy = "author")
  private List<Destination> destinations;
  private String firstname;
  private String lastname;
  @Column(name = "email", nullable = false, unique = true)
  private String email;
  private String password;
}
