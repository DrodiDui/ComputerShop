package by.kapitonov.computer.shop.backend.rest.vm;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class CoolingSystemVM {

    private Integer powerDissipation;
    private String radiatorMaterial;
    private Integer numberOfHeatPipes;
    private Integer fanDiameter;
    private Integer countOfFan;
    private Integer maxRotationSpeed;
    private Boolean backlight;
    private String socket;
    private ProductVM product;
    
}
