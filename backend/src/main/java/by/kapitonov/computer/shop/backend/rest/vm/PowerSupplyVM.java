package by.kapitonov.computer.shop.backend.rest.vm;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class PowerSupplyVM {

    private Integer power;
    private String certificate;
    private Boolean modulePowerCableConnection;
    private Integer width;
    private Integer depth;
    private Integer height;
    private String powerSupplyCategory;
    private ProductVM product;
}
