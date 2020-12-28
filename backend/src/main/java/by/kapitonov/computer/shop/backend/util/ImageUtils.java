package by.kapitonov.computer.shop.backend.util;

import by.kapitonov.computer.shop.backend.model.Image;
import lombok.extern.log4j.Log4j;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Log4j
public class ImageUtils {

    public static File getImage(Image image) {
        return new File(image.getImagePath() + image.getImageName());
    }

    public static Image uploadImage(MultipartFile multipartFile, String category) {

        String imagePath = "F:\\dev\\java\\ComputerShop\\backend\\src\\main\\resources\\images\\" + category + "\\";
        String originalImageName = multipartFile.getOriginalFilename() + '.' + UUID.randomUUID().toString();
        String name = multipartFile.getName();

        File file = new File(imagePath);
        if (!file.exists()) {
            file.mkdir();
        }

        try {
            BufferedImage writeImage = ImageIO.read(multipartFile.getInputStream());
            ImageIO.write(writeImage, "PNG", file);
        } catch (IOException e) {
            log.error(e);
        }

        return Image.builder()
                .imageOriginalName(originalImageName)
                .imageName(name)
                .imagePath(imagePath)
                .build();
    }
}
