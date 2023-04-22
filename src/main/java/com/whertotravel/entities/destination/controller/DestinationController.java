package com.whertotravel.entities.destination.controller;

import com.whertotravel.config.Config;
import com.whertotravel.entities.destination.models.DestinationCreateRequestDTO;
import com.whertotravel.entities.destination.models.DestinationResponseData;
import com.whertotravel.entities.destination.service.DestinationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Config.API_V_1 + "destination")
public class DestinationController {
  private final DestinationService destinationService;

  public DestinationController(DestinationService destinationService) {
    this.destinationService = destinationService;
  }

  @PostMapping
  ResponseEntity<String> saveDestination(@RequestBody DestinationCreateRequestDTO destinationCreateRequestDTO, HttpServletRequest request) {
    return destinationService.saveDestination(destinationCreateRequestDTO, request);
  }

  @GetMapping("/all")
  ResponseEntity<DestinationResponseData> getAll() {
    return destinationService.getAll();
  }
}
