package com.whertotravel.entities.destination.service;

import com.whertotravel.entities.destination.mapper.DestinationMapper;
import com.whertotravel.entities.destination.models.Destination;
import com.whertotravel.entities.destination.models.DestinationCreateRequestDTO;
import com.whertotravel.entities.destination.models.DestinationResponseData;
import com.whertotravel.entities.destination.repository.DestinationRepository;
import com.whertotravel.entities.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class DestinationServiceImpl implements DestinationService {
  private final DestinationRepository destinationRepository;
  private final UserRepository userRepository;
  private final DestinationMapper destinationMapper;

  public DestinationServiceImpl(DestinationRepository destinationRepository, UserRepository userRepository, DestinationMapper destinationMapper) {
    this.destinationRepository = destinationRepository;
    this.userRepository = userRepository;
    this.destinationMapper = destinationMapper;
  }


  @Override
  public ResponseEntity<String> saveDestination(DestinationCreateRequestDTO createRequestDTO, HttpServletRequest request) {
    Principal principal = request.getUserPrincipal();

    if (principal.getName() != null) {
      var user = userRepository.findUserByEmail(principal.getName());
      if (user.isPresent()) {
        var destination = destinationMapper.destinationCreateRequestToDestination(createRequestDTO);
        destination.setAuthor(user.get());
        var saveDestination = destinationRepository.save(destination);
        return new ResponseEntity<String>(saveDestination.getId().toString(), HttpStatus.CREATED);
      }
    }
    return new ResponseEntity<String>("Un", HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<DestinationResponseData> getAll() {
    List<Destination> data = (List<Destination>) destinationRepository.findAll();
    var dataDTO = data.stream().map(destinationMapper::destinationToResponse).toList();
    return new ResponseEntity<DestinationResponseData>(new DestinationResponseData(dataDTO), HttpStatus.OK);
  }
}
