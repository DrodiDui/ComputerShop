package by.kapitonov.computer.shop.backend.rest.controller;

import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
public class ImageRestController {

    private final ImageService imageService;

    public ImageRestController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createImage(MultipartFile multipartFile) {

        imageService.create(multipartFile);

        return new ResponseEntity<>(new ApiResponse("Image successfully created"), HttpStatus.OK);
    }
}
