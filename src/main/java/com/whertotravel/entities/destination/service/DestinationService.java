package com.whertotravel.entities.destination.service;

import com.whertotravel.entities.destination.models.DestinationCreateRequestDTO;
import com.whertotravel.entities.destination.models.DestinationResponseData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface DestinationService {
  ResponseEntity<String> saveDestination(DestinationCreateRequestDTO destinationCreateRequestDTO, HttpServletRequest request);

  ResponseEntity<DestinationResponseData> getAll();
}
