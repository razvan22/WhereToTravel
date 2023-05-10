package com.whertotravel.entities.destination.controller;

import com.whertotravel.config.Config;
import com.whertotravel.entities.destination.models.DestinationResponseDTO;
import com.whertotravel.entities.destination.service.DestinationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(Config.API_V_1 + "destination")
public class DestinationController {
  private final DestinationService destinationService;

  public DestinationController(DestinationService destinationService) {
    this.destinationService = destinationService;
  }

  @PostMapping
  ResponseEntity<String> saveDestination(
    @RequestParam String description,
    @RequestParam String title,
    @RequestParam MultipartFile[] images
    , HttpServletRequest request) {
    return destinationService.saveDestination(description, title, images, request);
  }

  @GetMapping("/all")
  ResponseEntity<List<DestinationResponseDTO>> getAll() {
    return destinationService.getAll();
  }

  @GetMapping("/{id}")
  ResponseEntity<DestinationResponseDTO> findById(@PathVariable UUID id) {
    return destinationService.findById(id);
  }
}
