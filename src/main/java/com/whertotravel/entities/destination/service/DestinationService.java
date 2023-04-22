package com.whertotravel.entities.destination.service;

import com.whertotravel.entities.destination.models.DestinationResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DestinationService {
  ResponseEntity<String> saveDestination(String description, String title, MultipartFile[] images, HttpServletRequest request);

  ResponseEntity<List<DestinationResponseDTO>> getAll();
}
