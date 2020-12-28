package by.kapitonov.computer.shop.backend.service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ImageDTO {

    private String imagePath;
    private String imageName;
    private String imageOriginName;

}
