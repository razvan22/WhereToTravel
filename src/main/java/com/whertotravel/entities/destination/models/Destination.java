package com.whertotravel.entities.destination.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.whertotravel.entities.image.model.Image;
import com.whertotravel.entities.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Destination {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @ManyToOne
  @JsonBackReference
  private User author;
  private String title;
  private String description;
  @OneToMany
  private List<Image> images;
}
