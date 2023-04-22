package com.whertotravel.filestorage.model;

import org.springframework.web.multipart.MultipartFile;


public interface StorageService {
  String store(MultipartFile file);
}
