package by.kapitonov.computer.shop.backend.service.dto;

import by.kapitonov.computer.shop.backend.model.product.detail.PowerSupplyCategory;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PowerSupplyDTO {

    private Integer power;
    private String certificate;
    private Boolean modulePowerCableConnection;
    private Integer width;
    private Integer depth;
    private Integer height;
    private String powerSupplyCategory;
    private ProductDTO productDTO;

}
