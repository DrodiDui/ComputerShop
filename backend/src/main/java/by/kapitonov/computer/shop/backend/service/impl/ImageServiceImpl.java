package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.model.Image;
import by.kapitonov.computer.shop.backend.repository.ImageRepository;
import by.kapitonov.computer.shop.backend.service.ImageService;
import by.kapitonov.computer.shop.backend.util.ImageUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image create(MultipartFile multipartFile) {

        Image image = ImageUtils.uploadImage(multipartFile, "test");

        return imageRepository.save(image);
    }
}
