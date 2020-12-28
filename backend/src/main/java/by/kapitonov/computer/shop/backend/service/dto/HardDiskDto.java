package by.kapitonov.computer.shop.backend.service.dto;

import lombok.*;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class HardDiskDTO {

    private Integer diskSize;
    private Integer spindleSpeed;
    private ProductDTO productDTO;
}
