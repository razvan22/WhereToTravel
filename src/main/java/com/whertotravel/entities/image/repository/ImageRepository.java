package com.whertotravel.entities.image.repository;

import com.whertotravel.entities.image.model.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ImageRepository extends CrudRepository<Image, UUID> {
}
