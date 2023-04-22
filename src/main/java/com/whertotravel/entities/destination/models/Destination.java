package com.whertotravel.entities.destination.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.whertotravel.entities.image.model.Image;
import com.whertotravel.entities.user.model.User;
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
@Table(name = "destinations")
public class Destination {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @ManyToOne
  @JsonBackReference
  private User author;
  private String title;
  private String description;
  @OneToMany(mappedBy = "destination")
  private List<Image> images;
  //  private List<Comment> comments;
}
