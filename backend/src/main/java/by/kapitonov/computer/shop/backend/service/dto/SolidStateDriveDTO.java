package by.kapitonov.computer.shop.backend.service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SolidStateDriveDTO {

    private Integer size;
    private ProductDTO productDTO;
}
