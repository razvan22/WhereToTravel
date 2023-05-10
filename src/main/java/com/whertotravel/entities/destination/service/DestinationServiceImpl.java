package com.whertotravel.entities.destination.service;

import com.whertotravel.entities.destination.mapper.DestinationMapper;
import com.whertotravel.entities.destination.models.Destination;
import com.whertotravel.entities.destination.models.DestinationResponseDTO;
import com.whertotravel.entities.destination.repository.DestinationRepository;
import com.whertotravel.entities.image.model.Image;
import com.whertotravel.entities.image.service.ImageService;
import com.whertotravel.entities.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Service
public class DestinationServiceImpl implements DestinationService {
  private final DestinationRepository destinationRepository;
  private final UserRepository userRepository;
  private final DestinationMapper destinationMapper;
  private final ImageService imageService;

  public DestinationServiceImpl(DestinationRepository destinationRepository, UserRepository userRepository, DestinationMapper destinationMapper, ImageService imageService) {
    this.destinationRepository = destinationRepository;
    this.userRepository = userRepository;
    this.destinationMapper = destinationMapper;
    this.imageService = imageService;
  }


  @Override
  public ResponseEntity<String> saveDestination(String description, String title, MultipartFile[] images, HttpServletRequest request) {
    Principal principal = request.getUserPrincipal();

    if (principal.getName() != null) {
      var user = userRepository.findUserByEmail(principal.getName());
      if (user.isPresent()) {
        var destination = Destination.builder()
          .author(user.get())
          .description(description)
          .title(title)
          .build();
        var imageList = saveImages(images);
        destination.setImages(imageList);
        var saveDestination = destinationRepository.save(destination);
        return new ResponseEntity<String>(saveDestination.getId().toString(), HttpStatus.CREATED);
      }
    }

    return new ResponseEntity<String>("Unauthorized", HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<List<DestinationResponseDTO>> getAll() {
    List<Destination> data = (List<Destination>) destinationRepository.findAll();
    var dataDTO = data.stream().map(destinationMapper::destinationToResponse).toList();

    return new ResponseEntity<>(dataDTO, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<DestinationResponseDTO> findById(UUID id) {
    return destinationRepository.findById(id)
      .map(value -> new ResponseEntity<>(destinationMapper.destinationToResponse(value), HttpStatus.OK))
      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  private List<Image> saveImages(MultipartFile[] images) {
    return imageService.saveAll(images);
  }
}
