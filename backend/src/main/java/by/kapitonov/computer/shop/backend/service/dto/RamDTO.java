package by.kapitonov.computer.shop.backend.service.dto;

import lombok.*;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RamDTO {

    private Integer size;
    private Integer frequency;
    private Boolean cooling;
    private Boolean backlight;
    private String typeOfMemory;
    private ProductDTO productDTO;

}
