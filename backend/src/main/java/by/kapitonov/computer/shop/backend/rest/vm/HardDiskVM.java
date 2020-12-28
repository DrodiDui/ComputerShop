package by.kapitonov.computer.shop.backend.rest.vm;

import lombok.*;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class HardDiskVM {

    private Integer diskSize;
    private Integer spindleSpeed;
    private ProductVM product;

}
