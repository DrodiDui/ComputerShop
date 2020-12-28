package by.kapitonov.computer.shop.backend.util;

import by.kapitonov.computer.shop.backend.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class FileUploadUtils {

    private static final String IMAGE_UPLOAD_PATH = "/images";

    public static Image saveImage(MultipartFile multipartFile){

        File imagePath = new File(IMAGE_UPLOAD_PATH);
        if (!imagePath.exists()) {
            imagePath.mkdir();
        }

        String imageName = UUID.randomUUID().toString() + "." + multipartFile.getName();
        String originalImageName = multipartFile.getOriginalFilename();

        return Image.builder()
                .imagePath(IMAGE_UPLOAD_PATH)
                .imageName(imageName)
                .imageOriginalName(originalImageName)
                .build();
    }
}
