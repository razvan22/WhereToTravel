package com.whertotravel.entities.destination.repository;

import com.whertotravel.entities.destination.models.Destination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DestinationRepository extends CrudRepository<Destination, UUID> {
}
