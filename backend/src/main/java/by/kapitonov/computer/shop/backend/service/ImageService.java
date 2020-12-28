package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    Image create(MultipartFile multipartFile);



}
