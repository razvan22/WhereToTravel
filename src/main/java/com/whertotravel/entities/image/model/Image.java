package com.whertotravel.entities.image.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Image {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String imagePath;
}
