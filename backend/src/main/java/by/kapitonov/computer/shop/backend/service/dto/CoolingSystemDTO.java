package by.kapitonov.computer.shop.backend.service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CoolingSystemDTO {

    private Integer powerDissipation;
    private String radiatorMaterial;
    private Integer numberOfHeatPipes;
    private Integer fanDiameter;
    private Integer countOfFan;
    private Integer maxRotationSpeed;
    private Boolean backlight;
    private String socket;
    private ProductDTO productDTO;

}
