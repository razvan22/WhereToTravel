package com.whertotravel.entities.image.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whertotravel.entities.destination.models.Destination;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Image {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String imagePath;
  @ManyToOne
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Destination destination;
}
