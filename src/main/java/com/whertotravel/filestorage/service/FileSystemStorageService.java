package com.whertotravel.filestorage.service;

import com.whertotravel.filestorage.config.StorageProperties;
import com.whertotravel.filestorage.exceptions.StorageException;
import com.whertotravel.filestorage.model.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileSystemStorageService implements StorageService {
  private final Path rootLocation = Paths.get(StorageProperties.IMAGES_LOCATION);


  @Override
  public String store(MultipartFile file) {
    String filePah;
    try {
      if (file.isEmpty()) {
        throw new StorageException("Failed to store empty file.");
      }
      filePah = UUID.randomUUID() + file.getOriginalFilename();
      Path destinationFile = this.rootLocation.resolve(
          Paths.get(filePah))
        .normalize().toAbsolutePath();
      try (InputStream inputStream = file.getInputStream()) {
        Files.copy(inputStream, destinationFile);
      }
    } catch (IOException e) {
      throw new StorageException("Failed to store file.", e);
    }
    return "/images/" + filePah;
  }
}
