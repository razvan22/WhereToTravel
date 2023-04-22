package com.whertotravel.entities.image.service;

import com.whertotravel.entities.image.model.Image;
import com.whertotravel.entities.image.repository.ImageRepository;
import com.whertotravel.filestorage.service.FileSystemStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {
  private final ImageRepository imageRepository;
  private final FileSystemStorageService fileSystemStorageService;

  public ImageService(ImageRepository imageRepository, FileSystemStorageService fileSystemStorageService) {
    this.imageRepository = imageRepository;
    this.fileSystemStorageService = fileSystemStorageService;
  }

  public List<Image> saveAll(MultipartFile[] images) {
    var savedImagesPathList = storeImages(images);
    List<Image> imgList = new ArrayList<>();

    for (String imgPath : savedImagesPathList) {
      var newImage = new Image();
      newImage.setImagePath(imgPath);
      imgList.add(newImage);
    }

    return imageRepository.saveAll(imgList);
  }

  private List<String> storeImages(MultipartFile[] images) {
    List<String> savedImages = new ArrayList<>();

    for (MultipartFile image : images) {
      var filePath = fileSystemStorageService.store(image);
      savedImages.add(filePath);
    }
    return savedImages;
  }

}
