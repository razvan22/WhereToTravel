package com.whertotravel.entities.destination.mapper;

import com.whertotravel.entities.destination.models.Destination;
import com.whertotravel.entities.destination.models.DestinationCreateRequestDTO;
import com.whertotravel.entities.destination.models.DestinationResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DestinationMapper {
  DestinationMapper INSTANCE = Mappers.getMapper(DestinationMapper.class);

  Destination destinationCreateRequestToDestination(DestinationCreateRequestDTO destinationCreateRequestDTO);

  DestinationResponseDTO destinationToResponse(Destination destination);
}
