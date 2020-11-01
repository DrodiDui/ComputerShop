package by.kapitonov.computer.shop.backend.service.dto;

import lombok.*;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class VideoCardDTO {

    private Integer videoMemory;
    private Integer frequency;
    private Integer maxFrequency;
    private Integer memoryBusWidth;
    private String videoMemoryType;
    private ProductDTO productDTO;

}
