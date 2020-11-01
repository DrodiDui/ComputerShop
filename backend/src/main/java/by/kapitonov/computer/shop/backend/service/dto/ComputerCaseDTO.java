package by.kapitonov.computer.shop.backend.service.dto;

import by.kapitonov.computer.shop.backend.model.product.detail.ComputerCaseType;
import by.kapitonov.computer.shop.backend.model.product.detail.MotherboardFormFactor;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ComputerCaseDTO {

    private String color;
    private String windowMaterial;
    private Integer width;
    private Integer depth;
    private Integer height;
    private Integer weight;
    private String computerCaseType;
    private String formFactorName;
    private ProductDTO productDTO;

}
