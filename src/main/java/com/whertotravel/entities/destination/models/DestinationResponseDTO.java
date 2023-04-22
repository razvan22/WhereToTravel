package com.whertotravel.entities.destination.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinationResponseDTO {
  UUID id;
  private String title;
  private String description;
}
